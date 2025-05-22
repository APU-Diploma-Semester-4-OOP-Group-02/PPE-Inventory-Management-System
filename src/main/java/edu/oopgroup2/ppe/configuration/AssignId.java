package edu.oopgroup2.ppe.configuration;

import java.util.List;

public class AssignId {
    public static String assignID(String filePath, String type) {
        List<String> users = FileFunction.readFile(filePath);
        String prefix;
        int maxID = 0;
        switch (type.toLowerCase()) {
            case "admin":
                prefix = "A";
                break;
            case "staff":
                prefix = "S";
                break;
            case "supplier":
                prefix = "SU";
                break;
            case "hospital":
                prefix = "H";
                break;
            default:
                System.out.println("Invalid user type.");
                return null;
        }
        for (String user:users) {
            String[] userDetails = user.split(",");
            if (userDetails[0].startsWith(prefix)) {
                try {
                    //substring(int start, int end) - juz get the string dat u want, so substring(prefix.length()) - if prefix = 'A'. den substring(1) remove the first char
                    //Integer.parseInt(String s) - returns an integer
                    int userID = Integer.parseInt(userDetails[0].substring(prefix.length())); // Extract number part
                    if (userID > maxID) {
                        maxID = userID;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error processing user ID: " + userDetails[0]);
                }
            }
        }
        // %03d - Formats it as a 3-digit number
        return prefix + String.format("%03d", maxID + 1);
    }
}
