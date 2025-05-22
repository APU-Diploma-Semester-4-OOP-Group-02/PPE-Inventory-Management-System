package edu.oopgroup2.ppe.model.hospital;

import edu.oopgroup2.ppe.model.Entity;

public class Hospital extends Entity {
    private String hospitalCode, hospitalEmail, hospitalContact;
    
    //constructor
    public Hospital() {}


    public Hospital(String hospitalCode, String hospitalName, String hospitalEmail, String hospitalContact, String status) {
        super(hospitalCode, hospitalName, hospitalEmail, hospitalContact, status);
    }
    
    // Getters
    public String getHospitalCode() {
        return getID().toUpperCase();
    }
    
    public String getHospitalName() {
        return getName();
    }

    // Setters
    public void setHospitalCode(String hospitalCode) {
        setID(hospitalCode);
    }
    
    public void setHospitalName(String hospitalName) {
        setName(hospitalName);
    }

}
