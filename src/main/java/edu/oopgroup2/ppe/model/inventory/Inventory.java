package edu.oopgroup2.ppe.model.inventory;

import edu.oopgroup2.ppe.model.supplier.Supplier;

public class Inventory {
    private String itemCode, itemName;
    private int quantityInStock;
    private Supplier supplier; // has-a relationship
    
    //constructor
    public Inventory() {}
    
    public Inventory(String itemCode, String itemName, String supplierCode, int quantityInStock) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.supplier = new Supplier(supplierCode, "", "", "", "active");
        this.quantityInStock = quantityInStock;
    }
    
     //getters
    public String getItemCode() {
        return itemCode;
    }

    public String getItemName() {
        return itemName.substring(0,1).toUpperCase() + itemName.substring(1).toLowerCase();
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public String getSupplierCode() {
        return supplier.getID();
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }
    
    //setters
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    
    public void setSupplierCode(String supplierCode) {
        this.supplier = new Supplier(supplierCode, "", "", "", "active");
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    @Override
    public String toString() {
        return "Item Code: " + itemCode + " , Name: " + itemName + " , Supplier: " + supplier.getSupplierCode() + " , Quantity: " + quantityInStock;
    }

}
