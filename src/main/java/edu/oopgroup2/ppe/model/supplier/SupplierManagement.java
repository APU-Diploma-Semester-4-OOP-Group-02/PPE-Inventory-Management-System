package edu.oopgroup2.ppe.model.supplier;

import java.util.List;

import edu.oopgroup2.ppe.configuration.AssignId;
import edu.oopgroup2.ppe.configuration.FileFunction;
import edu.oopgroup2.ppe.configuration.LogFunction;
import edu.oopgroup2.ppe.configuration.UserValidation;
import edu.oopgroup2.ppe.model.inventory.InventoryManagement;
import static edu.oopgroup2.ppe.model.inventory.InventoryManagement.isValidSupplier;
import java.util.ArrayList;

public class SupplierManagement {
    private static final String SUPPLIER_FILE_PATH = "txtFiles/suppliers.txt";
    private static final String PPE_FILE_PATH = "txtFiles/ppe.txt";

    public static void initializeSupplierFile() {
        try {
            if (!FileFunction.fileExists(SUPPLIER_FILE_PATH)) {
                FileFunction.createFileIfNotExists(SUPPLIER_FILE_PATH, "supplierCode,supplierName,supplierEmail,supplierContact,supplierStatus");
            }
        } catch (Exception e) {
            System.out.println("Error initializing supplier file: " + e.getMessage());
        }
    }
    
    // get all of the supplier
    public static List<String> getAllSuppliers() {
        initializeSupplierFile();
        List<String> allSuppliers = FileFunction.readFile(SUPPLIER_FILE_PATH);
        List<String> activeSuppliers = new ArrayList<>();
        for (String supplier : allSuppliers) {
            String[] supplierDetails = supplier.split(",");
            if (supplierDetails[4].equalsIgnoreCase("active")) {
                activeSuppliers.add(supplier);
            }
        }
        return activeSuppliers;
    }
    
    // get all of the supplier id (for dropdown purposes)
    public static List<String> getAllSupplierCodes() {
        List<String> supplierCodes = new ArrayList<>();
        try {
            List<String> suppliers = FileFunction.readFile(SUPPLIER_FILE_PATH);
            for (String supplier : suppliers) {
                String[] supplierDetails = supplier.split(",");
                if (supplierDetails[4].equalsIgnoreCase("active")) {
                    supplierCodes.add(supplierDetails[0]);
                }
            }
        } catch (Exception e) {
            System.out.println("Error fetching supplier codes: " + e.getMessage());
        }
        return supplierCodes;
    }

    // add supplier
    public static String addSupplier(String userID, String supplierName, String supplierEmail, String supplierContact) {
        try {
            List<String> suppliers = FileFunction.readFile(SUPPLIER_FILE_PATH);
            String checkEmail = UserValidation.validEmail(supplierEmail);
            if (!checkEmail.equals("Valid")) {
                return checkEmail;
            }
            String checkContact = UserValidation.validContact(supplierContact, "Supplier");
            if (!checkContact.equals("Valid")) {
                return checkContact;
            }
            String supplierCode = AssignId.assignID(SUPPLIER_FILE_PATH, "Supplier");
            String supplierStatus = "Active";
            Supplier newSupplier = new Supplier(supplierCode, supplierName, supplierEmail, supplierContact, supplierStatus);            
            FileFunction.writeFile(SUPPLIER_FILE_PATH, newSupplier.getID() + "," + newSupplier.getName() + "," + newSupplier.getEmail() + "," + newSupplier.getContact() + "," + newSupplier.getStatus());            LogFunction.writeLog(userID, "Add Supplier", "Added new supplier " + supplierCode);
            LogFunction.writeLog(userID, "Add Supplier", "Added new supplier " + supplierCode);
            return "Supplier added successfully: " + newSupplier.getID();
        } catch (Exception e) {
            return "Error adding supplier: " + e.getMessage();
        }
    }

    // modify supplier
    public static String modifySupplier(String userID, String supplierCode, String fieldToModify, String newValue) {
        initializeSupplierFile();
        try {
            List<String> suppliers = FileFunction.readFile(SUPPLIER_FILE_PATH);
            for (int i = 0; i < suppliers.size(); i++) {
                String[] supplierDetails = suppliers.get(i).split(",");
                if (supplierDetails[0].equals(supplierCode)) {
                    Supplier supplierModify = new Supplier(supplierDetails[0], supplierDetails[1], supplierDetails[2], supplierDetails[3], supplierDetails[4]);
                    if (fieldToModify.equalsIgnoreCase("name")) {
                        supplierModify.setName(newValue);
                        supplierDetails[1] = supplierModify.getName();
                    } else if (fieldToModify.equalsIgnoreCase("email")){
                        String checkEmail = UserValidation.validEmail(newValue);
                        if (!checkEmail.equals("Valid")) {
                            return checkEmail;
                        }
                        supplierModify.setEmail(newValue);
                        supplierDetails[2] = supplierModify.getEmail();
                    } else if (fieldToModify.equalsIgnoreCase("contact")) {
                        String checkContact = UserValidation.validContact(newValue, "Supplier");
                        if (!checkContact.equals("Valid")) {
                            return checkContact;
                        }
                        supplierModify.setContact(newValue);
                        supplierDetails[3] = supplierModify.getContact();
                    } else {
                        return "Error: Invalid choice.";
                    }
                    suppliers.set(i, String.join(",", supplierDetails));
                    FileFunction.overwriteFile(SUPPLIER_FILE_PATH, suppliers);
                    LogFunction.writeLog(userID, "Modify Supplier", "Modified " + supplierCode + "'s " + fieldToModify);
                    return "Supplier's details updated successfully!";
                }
            }
            return "Supplier ID not found.";
        } catch (Exception e) {
            return "Error modifying supplier: " + e.getMessage();
        }
    }

    // search for supplier
    public static List<Supplier> searchSupplier(String searchTerm) {
        List<Supplier> searchResults = new ArrayList<>();
        try {
            List<String> suppliers  = FileFunction.readFile(SUPPLIER_FILE_PATH);
            for (String supplier : suppliers) {
                String[] supplierDetails = supplier.split(",");
                if (supplierDetails[0].equalsIgnoreCase(searchTerm) || supplierDetails[1].equalsIgnoreCase(searchTerm)){
                    Supplier supplierSearch = new Supplier(supplierDetails[0], supplierDetails[1], supplierDetails[2], supplierDetails[3], supplierDetails[4]);
                    searchResults.add(supplierSearch);      
                }
            }
        } catch (Exception e) {
             System.out.println("Error searching for supplier: " + e.getMessage());
        }
        return searchResults;
    }

    // delete supplier
    public static String deleteSupplier(String userID, String supplierCodeSearch) {
        initializeSupplierFile();
        try {
            if (!isValidSupplier(supplierCodeSearch)) {
                return "Error: Supplier ID " + supplierCodeSearch + " does not exist.";
            }
            List<String> itemsBySupplier = InventoryManagement.getItemsBySupplier(supplierCodeSearch);
            if (!itemsBySupplier.isEmpty()) {
                List<String> ppeItems = FileFunction.readFile(PPE_FILE_PATH);
                List<String> updatedItems = new ArrayList<>();
                for (String item : ppeItems) {
                    String[] itemDetails = item.split(",");
                    if (itemDetails[2].equals(supplierCodeSearch)) {
                        itemDetails[2] = "";
                    }
                    updatedItems.add(String.join(",", itemDetails));
                }
                FileFunction.overwriteFile(PPE_FILE_PATH, updatedItems);
            }
            List<String> suppliers = FileFunction.readFile(SUPPLIER_FILE_PATH);
            for (int i = 0; i < suppliers.size(); i++) {
                String[] supplierDetails = suppliers.get(i).split(",");
                if (supplierDetails[0].equals(supplierCodeSearch)) {
                    supplierDetails[4] = "Deleted";
                    suppliers.set(i, String.join(",", supplierDetails));
                    FileFunction.overwriteFile(SUPPLIER_FILE_PATH, suppliers);
                    LogFunction.writeLog(userID, "Delete Supplier", "Deleted " + supplierCodeSearch);
                    return "Supplier: " + supplierCodeSearch + " deleted successfully";
                }
            }
            return "Supplier ID not found.";
        } catch (Exception e) {
            return "Error deleting supplier: " + e.getMessage();
        }
    }
}
