package edu.oopgroup2.ppe.model;

public abstract class Entity {
    protected String id, name, email, contact, status;

    //method
    
    public Entity(){}
    
    public Entity(String id, String name, String email, String contact, String status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.status = status;
    }
    
    public String getID() {
        return id.toUpperCase();
    }

    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getContact() {
        return contact;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setID(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
}
