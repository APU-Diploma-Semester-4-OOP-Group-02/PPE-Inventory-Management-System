package edu.oopgroup2.ppe.model.tracking;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import edu.oopgroup2.ppe.configuration.FileFunction;
import edu.oopgroup2.ppe.model.inventory.InventoryManagement;
import edu.oopgroup2.ppe.model.transaction.SummarizedTransaction;
import static edu.oopgroup2.ppe.model.transaction.TransactionManagement.initializeTransactionsFile;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class TrackingManagement {
    private static final String TRANSACTION_FILE_PATH = "txtFiles/transactions.txt";
    
    public static List<String> getSummarizedTrackingData() {
        initializeTransactionsFile();
        List<String> transactions = FileFunction.readFile(TRANSACTION_FILE_PATH);
        List<String> currentStockData = InventoryManagement.viewCurrentStock();
        Map<String, SummarizedTransaction> summarizedData = new HashMap<>();
        Map<String, Integer> currentStockMap = new HashMap<>();
        for (String stock : currentStockData) {
            String[] details = stock.split(",");
            String itemCode = details[0];
            int quantity = Integer.parseInt(details[3]);
            currentStockMap.put(itemCode, currentStockMap.getOrDefault(itemCode, 0) + quantity);
        }
        for (String transaction : transactions) {
            String[] details = transaction.split(",");
            String itemCode = details[0];
            String supplierCode = details[1];
            String hospitalCode = details[2];
            int quantityReceived = Integer.parseInt(details[3]);
            int quantityDistributed = Integer.parseInt(details[4]);
            String key = itemCode + "," + supplierCode + "," + hospitalCode;
            SummarizedTransaction existing = summarizedData.get(key);
            if (existing == null) {
                int currentStock = currentStockMap.getOrDefault(itemCode, 0);
                summarizedData.put(key, new SummarizedTransaction(itemCode, supplierCode, hospitalCode, quantityReceived, quantityDistributed, currentStock));
            } else {
                int totalReceived = existing.getTotalReceived() + quantityReceived;
                int totalDistributed = existing.getTotalDistributed() + quantityDistributed;
                summarizedData.put(key, new SummarizedTransaction(itemCode, supplierCode, hospitalCode, totalReceived, totalDistributed, existing.getCurrentStock()));
            }
        }
        List<SummarizedTransaction> summarizedList = new ArrayList<>(summarizedData.values());
        summarizedList.sort(Comparator.comparing(SummarizedTransaction::getItemCode));
        List<String> result = new ArrayList<>();
        for (SummarizedTransaction transaction : summarizedList) {
            result.add(transaction.toString());
        }
        return result;
    }
    
    // low stock items (<25 boxes)
     public static List<String> getLowStockItems() {
        List<String> lowStockData = InventoryManagement.viewLowStock();
        List<String> transactions = FileFunction.readFile(TRANSACTION_FILE_PATH);
        Map<String, SummarizedTransaction> summarizedData = new HashMap<>();
        for (String lowStock : lowStockData) {
            String[] lowStockDetails = lowStock.split(",");
            String itemCode = lowStockDetails[0];
            int currentStock = Integer.parseInt(lowStockDetails[3]);
            for (String transaction : transactions) {
                String[] details = transaction.split(",");
                String transactionItemCode = details[0];
                String supplierCode = details[1];
                String hospitalCode = details[2];
                int quantityReceived = Integer.parseInt(details[3]);
                int quantityDistributed = Integer.parseInt(details[4]);
                if (transactionItemCode.equals(itemCode)) {
                    String key = itemCode + "," + supplierCode + "," + hospitalCode;
                    SummarizedTransaction existing = summarizedData.get(key);
                    if (existing == null) {
                        summarizedData.put(key, new SummarizedTransaction(itemCode, supplierCode, hospitalCode, quantityReceived, quantityDistributed, currentStock));
                    } else {
                        int totalReceived = existing.getTotalReceived() + quantityReceived;
                        int totalDistributed = existing.getTotalDistributed() + quantityDistributed;
                        summarizedData.put(key, new SummarizedTransaction(itemCode, supplierCode, hospitalCode, totalReceived, totalDistributed, currentStock));
                    }
                }
            }
        }
        List<SummarizedTransaction> summarizedList = new ArrayList<>(summarizedData.values());
        summarizedList.sort(Comparator.comparing(SummarizedTransaction::getItemCode));
        List<String> result = new ArrayList<>();
        for (SummarizedTransaction transaction : summarizedList) {
            result.add(transaction.toString());
        }
        return result;
    }

    // filter item received by date
    public static List<String> trackItemReceivedByDate(String startDate, String endDate) {
        try {
            List<String> transactions = FileFunction.readFile(TRANSACTION_FILE_PATH);
            List<String> filteredTransactions = new ArrayList<>();
            //DateTimeFormatter.ofPattern(“pattern u want”).
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            for (String transaction : transactions) {
                String[] transactionDetails = transaction.split(",");
                // LocalDate parse(CharSequence text)
                // to get an instance of LocalDate from a string
                // returns LocalDate which is the parsed local date-time
                LocalDate transactionDate = LocalDate.parse(transactionDetails[5].split(" ")[0], formatter);
                // LocalDate parse(CharSequence text,DateTimeFormatter formatter)
                LocalDate start = LocalDate.parse(startDate, formatter);
                LocalDate end = LocalDate.parse(endDate, formatter);
                if (!transactionDate.isBefore(start) && !transactionDate.isAfter(end) && !transactionDetails[1].isEmpty() && Integer.parseInt(transactionDetails[3]) > 0) {
                    String itemID = transactionDetails[0];
                    String supplierID = transactionDetails[1];
                    String quantity = transactionDetails[3];
                    String dateTime = transactionDetails[5];
                    filteredTransactions.add(itemID + "," + supplierID + "," + quantity + "," + dateTime);
                }
            }
            return filteredTransactions;
        } catch (NumberFormatException e) {
            System.out.println("Error tracking item: " + e.getMessage());
            return null;
        }
    }
    
    // filter item distributed by date
    public static List<String> trackItemDistributedByDate(String startDate, String endDate) {
        try {
            List<String> transactions = FileFunction.readFile(TRANSACTION_FILE_PATH);
            List<String> filteredTransactions = new ArrayList<>();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            for (String transaction : transactions) {
                String[] transactionDetails = transaction.split(",");
                LocalDate transactionDate = LocalDate.parse(transactionDetails[5].split(" ")[0], formatter);
                LocalDate start = LocalDate.parse(startDate, formatter);
                LocalDate end = LocalDate.parse(endDate, formatter);
                if (!transactionDate.isBefore(start) && !transactionDate.isAfter(end) && !transactionDetails[2].isEmpty() && Integer.parseInt(transactionDetails[4]) > 0) {
                    String itemID = transactionDetails[0];
                    String hospitalID = transactionDetails[2];
                    String quantity = transactionDetails[4];
                    String dateTime = transactionDetails[5];
                    filteredTransactions.add(itemID + "," + hospitalID + "," + quantity + "," + dateTime);
                }
            }
            return filteredTransactions;
        } catch (NumberFormatException e) {
            System.out.println("Error tracking item: " + e.getMessage());
            return null;
        }
    }

    // search tracking data
    public static List<String> searchTrackingData(String searchTerm) {
        List<String> searchResults = new ArrayList<>();
        try {
            List<String> trackingData = getSummarizedTrackingData();
            for (String data : trackingData) {
                String[] details = data.split(",");
                if (details[0].equalsIgnoreCase(searchTerm) || details[1].equalsIgnoreCase(searchTerm) || details[2].equalsIgnoreCase(searchTerm)) {
                    searchResults.add(data);
                }
            }
        } catch (Exception e) {
            System.out.println("Error searching for tracking data: " + e.getMessage());
        }
        return searchResults;
    }
}
