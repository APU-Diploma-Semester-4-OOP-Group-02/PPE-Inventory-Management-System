package edu.oopgroup2.ppe.model.staffadmin;

import edu.oopgroup2.ppe.model.Entity;

public class User extends Entity {
    private String password, userType;
    
    //constructor
    public User() {}

    public User(String userID, String userName, String password, String userType, String userEmail, String userContact, String status) {
        super(userID, userName, userEmail, userContact, status);
        this.password = password;
        this.userType = userType;
    }

    //getters and setters
     //getters
    public String getPassword() {
        return password;
    }

    public String getUserType() {
        return (userType.substring(0,1).toUpperCase() + userType.substring(1).toLowerCase());
    }

    //setters
    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

}
