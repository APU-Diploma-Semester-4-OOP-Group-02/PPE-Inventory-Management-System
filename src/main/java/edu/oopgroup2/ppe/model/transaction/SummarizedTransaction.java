package edu.oopgroup2.ppe.model.transaction;

public class SummarizedTransaction {
    private String itemCode;
    private String supplierCode;
    private String hospitalCode;
    private int totalReceived;
    private int totalDistributed;
    private int currentStock;
    
    // Constructor
    public SummarizedTransaction(String itemCode, String supplierCode, String hospitalCode, int totalReceived, int totalDistributed, int currentStock) {
        this.itemCode = itemCode;
        this.supplierCode = supplierCode;
        this.hospitalCode = hospitalCode;
        this.totalReceived = totalReceived;
        this.totalDistributed = totalDistributed;
        this.currentStock = currentStock;
    }

    // Getters and Setters
    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getHospitalCode() {
        return hospitalCode;
    }

    public void setHospitalCode(String hospitalCode) {
        this.hospitalCode = hospitalCode;
    }

    public int getTotalReceived() {
        return totalReceived;
    }

    public void setTotalReceived(int totalReceived) {
        this.totalReceived = totalReceived;
    }

    public int getTotalDistributed() {
        return totalDistributed;
    }

    public void setTotalDistributed(int totalDistributed) {
        this.totalDistributed = totalDistributed;
    }

    public int getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(int currentStock) {
        this.currentStock = currentStock;
    }
    
    @Override
    public String toString() {
        return itemCode + "," + supplierCode + "," + hospitalCode + "," + totalReceived + "," + totalDistributed + "," + currentStock;
    }
}
