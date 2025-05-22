package edu.oopgroup2.ppe.configuration;

public class UserSession {
    private static String userID, userName;
    
    public static void setUser(String id, String name) {
        userID = id;
        userName = name;
    }
    
    public static String getUserID() {
        return userID.toUpperCase();
    }

    public static String getUserName() {
        return userName;
    }
}
