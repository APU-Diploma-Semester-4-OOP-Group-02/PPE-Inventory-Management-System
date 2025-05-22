package edu.oopgroup2.ppe.model.transaction;

public class Transaction {
    private String itemCode, supplierCode, hospitalCode, dateTime;
    private int quantityReceived, quantityDistributed;
    
    //constructor
    public Transaction() {}
    
    public Transaction(String itemCode, String supplierCode, String hospitalCode, int quantityReceived, int quantityDistributed, String dateTime) {
        this.itemCode = itemCode;
        this.supplierCode = supplierCode;
        this.hospitalCode = hospitalCode;
        this.quantityReceived = quantityReceived;
        this.quantityDistributed = quantityDistributed;
        this.dateTime = dateTime;
    }
    
     //getters
    public String getItemCode() {
        return itemCode;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public String getHospitalCode() {
        return hospitalCode;
    }

    public int getQuantityReceived() {
        return quantityReceived;
    }
    
    public int getQuantityDistributed() {
        return quantityDistributed;
    }
    
    public String getDateTime() {
        return dateTime;
    }
    
    //setters
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }
    
    public void setHospitalCode(String hospitalCode) {
        this.hospitalCode = hospitalCode;
    }

    public void setQuantityReceived(int quantityReceived) {
        this.quantityReceived = quantityReceived;
    }
    
    public void setQuantityDistributed(int quantityDistributed) {
        this.quantityDistributed = quantityDistributed;
    }  
    
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

}
