package edu.oopgroup2.ppe.model.inventory;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import edu.oopgroup2.ppe.configuration.FileFunction;
import edu.oopgroup2.ppe.configuration.LogFunction;
import edu.oopgroup2.ppe.model.transaction.TransactionManagement;
import java.util.Collections;

public class InventoryManagement {
    private static final String PPE_FILE_PATH = "txtFiles/ppe.txt";
    private static final String SUPPLIER_FILE_PATH = "txtFiles/suppliers.txt";
    private static final String HOSPITAL_FILE_PATH = "txtFiles/hospitals.txt";

    public static void initializeInventoryFile() {
        try {
            if (!FileFunction.fileExists(PPE_FILE_PATH)) {
                FileFunction.createFileIfNotExists(PPE_FILE_PATH, "itemCode,itemName,supplierCode,quantityInStock");
            }
        } catch (Exception e) {
            System.out.println("Error initializing inventory file: " + e.getMessage());
        }
    }
    
    // initialize ppe stock if the file not exist
    public static String initializePPEStock() {
        initializeInventoryFile();
        try {
            if (!FileFunction.fileExists(SUPPLIER_FILE_PATH)) {
                FileFunction.createFileIfNotExists(SUPPLIER_FILE_PATH, "supplierID,supplierName,contactDetails");
            }
            List<String> defaultStock = new ArrayList<>();
            defaultStock.add("HC,Head Cover,,100");
            defaultStock.add("FS,Face Shield,,100");
            defaultStock.add("MS,Mask,,100");
            defaultStock.add("GL,Gloves,,100");
            defaultStock.add("GW,Gown,,100");
            defaultStock.add("SC,Shoe Covers,,100");
            FileFunction.overwriteFile(PPE_FILE_PATH, defaultStock);
            return "Initial inventory setup completed.";
        } catch (Exception e) {
            return "Error initializing PPE stock: " + e.getMessage();
        }
    }
    
    // get all item code (for dropdown purposes)
    public static List<String> getAllItemCodes() {
        List<String> itemCodes = new ArrayList<>();
        try {
            List<String> ppeItems = FileFunction.readFile(PPE_FILE_PATH);
            for (String item : ppeItems) {
                String[] itemDetails = item.split(",");
                itemCodes.add(itemDetails[0]);
            }
        } catch (Exception e) {
            System.out.println("Error fetching item IDs: " + e.getMessage());
        }
        return itemCodes;
    }
    
    // get all item code which dont have supplier ID (for dropdown purposes)
    public static List<String> getAllItemCodesWithoutSupplier() {
        List<String> itemCodes = new ArrayList<>();
        try {
            List<String> ppeItems = FileFunction.readFile(PPE_FILE_PATH);
            for (String item : ppeItems) {
                String[] itemDetails = item.split(",");
                if (itemDetails[2].isEmpty()) {
                    itemCodes.add(itemDetails[0]);
                }
            }
        } catch (Exception e) {
            System.out.println("Error fetching item IDs: " + e.getMessage());
        }
        return itemCodes;
    }

    // search inventory 
    public static List<Inventory> searchInventory(String searchTerm) {
        List<Inventory> searchResults = new ArrayList<>();
        try {
            List<String> inventories = FileFunction.readFile(PPE_FILE_PATH);
            for (String inv : inventories) {
                String[] inventoryDetails = inv.split(",");
                if (inventoryDetails[0].equalsIgnoreCase(searchTerm) || inventoryDetails[1].equalsIgnoreCase(searchTerm)) {
                    Inventory inventorySearch = new Inventory(inventoryDetails[0], inventoryDetails[1], inventoryDetails[2], Integer.parseInt(inventoryDetails[3]));
                    searchResults.add(inventorySearch);
                }
            }
        } catch (Exception e) {
            System.out.println("Error searching for inventory: " + e.getMessage());
        }
        return searchResults;
    }
    
    // check whether the stock is initialized
    public static boolean isStockInitialized() {
        try {
            List<String> items = FileFunction.readFile(PPE_FILE_PATH);
            return !items.isEmpty();
        } catch (Exception e) {
            return false;
        }
    }
        
    // check does the selected supplier existed in the txt
    public static boolean isValidSupplier(String supplierCode) {
        try {
            List<String> suppliers = FileFunction.readFile(SUPPLIER_FILE_PATH);
            for (String supplier : suppliers) {
                String[] supplierDetails = supplier.split(",");
                if (supplierDetails[0].equals(supplierCode)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            System.out.println("Error validating supplier: " + e.getMessage());
            return false;
        }
    }
    
    // view current stock (sort by item code)
    public static List<String> viewCurrentStock() {
        if (!FileFunction.fileExists(PPE_FILE_PATH)) {
            initializePPEStock();
        }
        try {
            List<String> items = FileFunction.readFile(PPE_FILE_PATH);
            List<Inventory> inventoryList = new ArrayList<>();
            for (String item : items) {
            String[] itemDetails = item.split(",");
            Inventory inventoryItem = new Inventory(itemDetails[0], itemDetails[1], itemDetails[2], Integer.parseInt(itemDetails[3]));
            inventoryList.add(inventoryItem);
            }
            // Collection.sort() - to sort the elements present in the specified list of Collection in ascending order
            // (a, b) - b is used where u can define ur order of list
            Collections.sort(inventoryList, new InventoryComparator());
            List<String> sortedStock = new ArrayList<>();
            for (Inventory inv : inventoryList) {
                sortedStock.add(inv.getItemCode() + "," + inv.getItemName() + "," + inv.getSupplierCode() + "," + inv.getQuantityInStock());
            }
            return sortedStock;
        } catch (NumberFormatException e) {
            System.out.println("Error viewing current stock: " + e.getMessage());
            return null;
        }
    }

    // view low stock (< 25 boxes)
    public static List<String> viewLowStock() {
        try {
            List<String> items = FileFunction.readFile(PPE_FILE_PATH);
            List<Inventory> lowStockItems = new ArrayList<>();
            for (String item : items) {
                String[] itemDetails = item.split(",");
                int quantity = Integer.parseInt(itemDetails[3]);
                if (quantity < 25) {
                    Inventory inventoryItem = new Inventory(itemDetails[0],itemDetails[1],itemDetails[2],quantity);
                    lowStockItems.add(inventoryItem);
                }
            }
            Collections.sort(lowStockItems, new InventoryComparator());
            List<String> sortedLowStock = new ArrayList<>();
            for (Inventory inv : lowStockItems) {
                sortedLowStock.add(inv.getItemCode() + "," + inv.getItemName() + "," + inv.getSupplierCode() + "," + inv.getQuantityInStock());
            }
            return sortedLowStock;
        } catch (NumberFormatException e) {
            System.out.println("Error viewing low stock items: " + e.getMessage());
            return null;
        }
    }
    
    // add new ppe item
    public static String addPPEItem(String itemCode, String itemName, String supplierCode, int quantity) {
        try {
            if (!isValidSupplier(supplierCode)) {
                return "Error: Supplier ID " + supplierCode + " does not exist.";
            }
            List<String> items = FileFunction.readFile(PPE_FILE_PATH);
            if (itemCode.length() != 2) {
                return "Item ID must have exactly 2 letters.";
            }
            for (String item : items) {
                String[] itemDetails =  item.split(",");
                if (itemCode.equalsIgnoreCase(itemDetails[0])) {
                    return "Item ID " + itemCode + " already exists.";
                }
            }
            if (quantity < 0) {
                return "Quantity cannot be negative";
            }
            Inventory newPPE = new Inventory(itemCode, itemName, supplierCode, quantity);
            FileFunction.writeFile(PPE_FILE_PATH, newPPE.getItemCode() + "," + newPPE.getItemName() + "," + newPPE.getSupplierCode() + "," + newPPE.getQuantityInStock());
            return "PPE item added successfully: " + newPPE.toString();
        } catch (Exception e) {
            return "Error adding PPE stock: " + e.getMessage();
        }
    }

    // update stock of ppe item (receive/distribute)
    public static String updateStock(String userID, String itemCode, String hospitalOrSupplier, int quantity, boolean isReceiving) {
        try {
            List<String> items = FileFunction.readFile(PPE_FILE_PATH);
            List<String> updatedItems = new ArrayList<>();
            boolean itemFound = false;
            String transactionType = "";
            String hospitalCode = "";
            String supplierCode = "";
            int quantityReceived = 0;
            int quantityDistributed = 0;
            for (String item : items) {
                String[] itemDetails =  item.split(",");
                if (itemDetails[0].equalsIgnoreCase(itemCode)) {
                    Inventory modifyPPE = new Inventory(itemDetails[0], itemDetails[1], itemDetails[2], Integer.parseInt(itemDetails[3]));
                    itemFound = true;
                    //int updatedStock;
                    if (isReceiving) {
                        modifyPPE.setQuantityInStock(modifyPPE.getQuantityInStock() + quantity);
                        transactionType = "Received";
                    } else {
                        if (modifyPPE.getQuantityInStock() < quantity) {
                            return "Error: Not enough stock available. Available: " + modifyPPE.getQuantityInStock() + " boxes.";
                        }
                        modifyPPE.setQuantityInStock(modifyPPE.getQuantityInStock() - quantity);
                        transactionType = "Distributed";
                    }
                    //String.valueOf - returns a type of data into string
                    itemDetails[3] = String.valueOf(modifyPPE.getQuantityInStock());
                }
                updatedItems.add(String.join(",", itemDetails));
            }
            if (!itemFound) {
                return "Item ID not found";
            }
            FileFunction.overwriteFile(PPE_FILE_PATH, updatedItems);
            String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            if (transactionType.equals("Received")) {
                supplierCode = hospitalOrSupplier;
                quantityReceived = quantity;
            } else {
                hospitalCode = hospitalOrSupplier;
                quantityDistributed = quantity;
            }
            TransactionManagement.logTransaction(userID, itemCode, supplierCode, hospitalCode, quantityReceived, quantityDistributed, dateTime);
            return "Stock updated successfully";
        } catch (NumberFormatException e) {
            return "Error updating stock: " + e.getMessage();
        }
    }

    // receive ppe stock
    public static String receivePPEStock(String userID, String itemCode, int quantity) {
        try {
            List<String> items = FileFunction.readFile(PPE_FILE_PATH);
            for (String item : items) {
                String[] itemDetails =  item.split(",");
                if (itemDetails[0].equalsIgnoreCase(itemCode)) {
                    Inventory PPE = new Inventory(itemDetails[0], itemDetails[1], itemDetails[2], Integer.parseInt(itemDetails[3]));
                    return updateStock(userID, itemCode, PPE.getSupplierCode(), quantity, true);
                }
            }
            return "Error: Item ID " + itemCode + " not found.";
        } catch (NumberFormatException e) {
            return "Error receiving PPE stock: " + e.getMessage();
        }
    }

    // distribute ppe stock
    public static String distributePPEStock(String userID, String itemCode, String hospitalCode, int quantity) {
        try {
            List<String> hospitals = FileFunction.readFile(HOSPITAL_FILE_PATH);
            boolean hospitalExists = false;
            for (String hospital : hospitals) {
                String[] hospitalDetails =  hospital.split(",");
                if (hospitalDetails[0].equalsIgnoreCase(hospitalCode)) {
                    hospitalExists = true;
                    break;
                }
            }
            if (!hospitalExists) {
                return "Error: Hospital ID " + hospitalCode + " not found.";
            }
            return updateStock(userID, itemCode, hospitalCode, quantity, false);
        } catch (Exception e) {
            return "Error distributing PPE stock: " + e.getMessage();
        }
    }
    
    // get the items that the supplier supplied (used when delete supplier - check whether the supplier supplied item, if yes, then reassign a supplier for that item)
    public static List<String> getItemsBySupplier(String supplierCode) {
        List<String> itemsBySupplier = new ArrayList<>();
        try {
            List<String> ppeItems = FileFunction.readFile(PPE_FILE_PATH);
            for (String item : ppeItems) {
                String[] itemDetails = item.split(",");
                if (itemDetails[2].equals(supplierCode)) {
                    itemsBySupplier.add(item);
                }
            }
        } catch (Exception e) {
            System.out.println("Error fetching items by supplier: " + e.getMessage());
        }
        return itemsBySupplier;
    }
    
    // get which supplier supplied the item (when select one of the item, then directly load the supplier data)
    public static String getSupplierForItem(String itemCode) {
        try {
            List<String> items = FileFunction.readFile(PPE_FILE_PATH);
            for (String item : items) {
                String[] itemDetails = item.split(",");
                if (itemDetails[0].equals(itemCode)) {
                    return itemDetails[2];
                }
            }
        } catch (Exception e) {
            System.out.println("Error fetching supplier for item: " + e.getMessage());
        }
        return null;
    }
    
    // assign supplier (if there is no supplier for the item)
    public static String assignSupplier(String userID, String itemCode, String newSupplierCode) {
        try {
            List<String> ppeItems = FileFunction.readFile(PPE_FILE_PATH);
            for (int i = 0; i < ppeItems.size(); i++) {
                String[] itemDetails = ppeItems.get(i).split(",");
                if (itemDetails[0].equals(itemCode)) {
                    if (!itemDetails[2].isEmpty()) {
                        return "Error: Item " + itemCode + " already has a supplier assigned.";
                    }
                    itemDetails[2] = newSupplierCode;
                    ppeItems.set(i, String.join(",", itemDetails));
                    FileFunction.overwriteFile(PPE_FILE_PATH, ppeItems);
                    LogFunction.writeLog(userID, "Assign Supplier", "Assigned supplier for item " + itemCode + " to " + newSupplierCode);
                    return "Supplier assigned successfully for item: " + itemCode;
                }
            }
            return "Item ID not found.";
        } catch (Exception e) {
            return "Error assigning supplier: " + e.getMessage();
        }
    }
}