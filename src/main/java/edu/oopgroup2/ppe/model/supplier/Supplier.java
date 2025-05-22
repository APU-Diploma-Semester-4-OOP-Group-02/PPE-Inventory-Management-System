package edu.oopgroup2.ppe.model.supplier;

import edu.oopgroup2.ppe.model.Entity;

public class Supplier extends Entity {
    
    //constructor
    public Supplier() {}

    public Supplier(String supplierCode, String supplierName, String supplierEmail, String supplierContact, String status) {
        super(supplierCode, supplierName, supplierEmail, supplierContact, status);
    }
    
    // Getters
    public String getSupplierCode() {
        return getID().toUpperCase();
    }
    
    public String getSupplierName() {
        return getName();
    }

    // Setters
    public void setSupplierCode(String supplierCode) {
        setID(supplierCode);
    }
    
    public void setSupplierName(String supplierName) {
        setName(supplierName);
    }

}
