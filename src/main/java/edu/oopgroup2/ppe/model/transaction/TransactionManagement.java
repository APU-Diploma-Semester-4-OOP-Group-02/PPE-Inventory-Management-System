package edu.oopgroup2.ppe.model.transaction;

import java.util.List;

import edu.oopgroup2.ppe.configuration.FileFunction;
import edu.oopgroup2.ppe.configuration.LogFunction;
import java.util.ArrayList;

public class TransactionManagement {
    private static final String TRANSACTIONS_FILE_PATH = "txtFiles/transactions.txt";

    public static void initializeTransactionsFile() {
        try {
            if (!FileFunction.fileExists(TRANSACTIONS_FILE_PATH)) {
                FileFunction.createFileIfNotExists(TRANSACTIONS_FILE_PATH, "itemCode,supplierCode,hospitalCode,quantityReceived,quantityDistributed,dateTime");
            }
        } catch (Exception e) {
            System.out.println("Error initializing transaction file: " + e.getMessage());
        }
    }

    // view all transactions
    public static List<String> viewTransactions() {
        initializeTransactionsFile();
        List<String> transactions = FileFunction.readFile(TRANSACTIONS_FILE_PATH);
        return transactions;
    }

    // store data for each transaction from update inventory
    public static void logTransaction(String userID, String itemCode, String supplierCode, String hospitalCode, int quantityReceived, int quantityDistributed, String dateTime) {
        initializeTransactionsFile();
        try {
            Transaction newTransaction = new Transaction(itemCode, supplierCode, hospitalCode, quantityReceived, quantityDistributed, dateTime);
            FileFunction.writeFile(TRANSACTIONS_FILE_PATH, newTransaction.getItemCode() + "," + newTransaction.getSupplierCode() + "," + newTransaction.getHospitalCode() + "," + newTransaction.getQuantityReceived() + "," + newTransaction.getQuantityDistributed() + "," + newTransaction.getDateTime());
            LogFunction.writeLog(userID, "Transaction", "Item " + itemCode + " | Received: " + quantityReceived + " | Distributed: " + quantityDistributed);        } catch (Exception e) {
            System.out.println("Error inserting data into transaction file: " + e.getMessage());
        }
    }

    // get transaction data (total quantity distributed n total quantity received)
    public static List<String> getMergedTransactions() {
        List<String> transactions = viewTransactions();
        List<String> mergedTransactions = new ArrayList<>();
        for (String transaction : transactions) {
            String[] details = transaction.split(",");
            String itemCode = details[0];
            String supplierCode = details[1];
            String hospitalCode = details[2];
            int quantityReceived = Integer.parseInt(details[3]);
            int quantityDistributed = Integer.parseInt(details[4]);
            String dateTime = details[5];
            if (quantityReceived > 0) {
                mergedTransactions.add(itemCode + "," + supplierCode + ",-," + quantityReceived + ",Received," + dateTime);
            }
            if (quantityDistributed > 0) {
                mergedTransactions.add(itemCode + ",-," + hospitalCode + "," + quantityDistributed + ",Distributed," + dateTime);
            }
        }
        return mergedTransactions;
    }
    
    // filter transaction by date
    public static List<String> getFilteredTransactionsByDate(String startDate, String endDate) {
        List<String> transactions = viewTransactions();
        List<String> filteredTransactions = new ArrayList<>();
        for (String transaction : transactions) {
            String[] details = transaction.split(",");
            String dateTime = details[5];
            String transactionDate = dateTime.split(" ")[0];
            if (transactionDate.compareTo(startDate) >= 0 && transactionDate.compareTo(endDate) <= 0) {
                String itemCode = details[0];
                int quantityReceived = Integer.parseInt(details[3]);
                int quantityDistributed = Integer.parseInt(details[4]);
                if (quantityReceived > 0) {
                    filteredTransactions.add(itemCode + "," + details[1] + ",-," + quantityReceived + ",Received," + dateTime);
                }
                if (quantityDistributed > 0) {
                    filteredTransactions.add(itemCode + ",-," + details[2] + "," + quantityDistributed + ",Distributed," + dateTime);
                }
            }
        }
        return filteredTransactions;
    }
    
    // search transaction 
    public static List<String> searchTransaction(String searchTerm) {
        List<String> searchResults = new ArrayList<>();
        try {
            List<String> transactions = FileFunction.readFile(TRANSACTIONS_FILE_PATH);
            for (String transaction : transactions) {
                String[] details = transaction.split(",");
                if (details[0].equalsIgnoreCase(searchTerm) || details[1].equalsIgnoreCase(searchTerm) || details[2].equalsIgnoreCase(searchTerm)) {
                    searchResults.add(transaction);
                }
            }
        } catch (Exception e) {
            System.out.println("Error searching for transactions: " + e.getMessage());
        }
        return searchResults;
    }
}