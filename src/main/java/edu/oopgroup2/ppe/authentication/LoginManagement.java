package edu.oopgroup2.ppe.authentication;

import java.util.List;

import edu.oopgroup2.ppe.configuration.FileFunction;
import edu.oopgroup2.ppe.configuration.LogFunction;


public class LoginManagement {
    static final String USER_FILE_PATH = "txtFiles/users.txt";

    public static String[] authenticate(String userID, String password) {
        try {
            List<String> users = FileFunction.readFile(USER_FILE_PATH);
            if (users == null || users.isEmpty()) {
                LogFunction.writeLog("SYSTEM", "Error", "User file is empty or not found");
                return null;
            }
            for (String user : users) {
                String[] userDetails = user.split(",");
                if (userDetails[0].equalsIgnoreCase(userID)) {
                    if (userDetails[2].equals(password)) {
                        LogFunction.writeLog(userID, "Login", "User logged into the system");
                        return new String[]{userID, userDetails[1], userDetails[3]};
                    } else {
                        LogFunction.writeLog(userID, "Failed Login", "Invalid credentials");
                        return null;
                    }
                }
            }
            LogFunction.writeLog(userID, "Failed Login", "User ID not found");
            return null;
        } catch (Exception e) {
            LogFunction.writeLog("SYSTEM", "Error", "Error during login: " + e.getMessage());
            System.out.println("Error logging in: " + e.getMessage());
            return null;
        }
    }
}
