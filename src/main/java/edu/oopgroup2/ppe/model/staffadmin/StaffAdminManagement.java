package edu.oopgroup2.ppe.model.staffadmin;

import java.util.ArrayList;
import java.util.List;

import edu.oopgroup2.ppe.configuration.AssignId;
import edu.oopgroup2.ppe.configuration.FileFunction;
import edu.oopgroup2.ppe.configuration.LogFunction;
import edu.oopgroup2.ppe.configuration.UserSession;
import edu.oopgroup2.ppe.configuration.UserValidation;

public class StaffAdminManagement {
    private static final String USER_FILE_PATH = "txtFiles/users.txt";

    public static void initializeUserFile() {
        try {
            if (!FileFunction.fileExists(USER_FILE_PATH)) {
                FileFunction.createFileIfNotExists(USER_FILE_PATH, "userID,userName,password,userType,userEmail,userContact,userStatus");
            }
        } catch (Exception e) {
            System.out.println("Error initializing user file: " + e.getMessage());
        }
    }

    // get all admins
    public static List<String> getAllAdmins() {
        initializeUserFile();
        List<String> allUsers = FileFunction.readFile(USER_FILE_PATH);
        List<String> activeAdmins = new ArrayList<>();
        for (String users : allUsers) {
            String[] userDetails = users.split(",");
            if (userDetails[3].equalsIgnoreCase("admin") && userDetails[6].equalsIgnoreCase("active")) {
                activeAdmins.add(users);
            }
        }
        return activeAdmins;
    }
    
    // get all staffs
    public static List<String> getAllStaffs() {
        initializeUserFile();
        List<String> allUsers = FileFunction.readFile(USER_FILE_PATH);
        List<String> activeStaffs = new ArrayList<>();
        for (String users : allUsers) {
            String[] userDetails = users.split(",");
            if (userDetails[3].equalsIgnoreCase("staff")  && userDetails[6].equalsIgnoreCase("active")) {
                activeStaffs.add(users);
            }
        }
        return activeStaffs;
    }

    // add user (staff n admin)
    public static String addUser(String userID, String userName, String userType, String password, String confirmPassword, String userEmail, String userContact) {
        try {
            if (!userType.equalsIgnoreCase("admin") && !userType.equalsIgnoreCase("staff")) {
                return "Invalid user type";
            }
            if (!password.equals(confirmPassword)) {
                return "Error: Passwords do not match. Please try again.";
            }
            String checkPassword = UserValidation.validPassword(password);
            if (!checkPassword.equals("Valid")) {
                return checkPassword;
            }
            String checkEmail = UserValidation.validEmail(userEmail);
            if (!checkEmail.equals("Valid")) {
                return checkEmail;
            }
            String checkContact = UserValidation.validContact(userContact, userType);
            if (!checkContact.equals("Valid")) {
                return checkContact;
            }
            String newUserID = AssignId.assignID(USER_FILE_PATH, userType);
            String userStatus = "Active";
            User newUser = new User(newUserID, userName, password, userType, userEmail, userContact, userStatus);
            FileFunction.writeFile(USER_FILE_PATH, newUser.getID() + "," + newUser.getName() + "," + newUser.getPassword() + "," + newUser.getUserType() + "," + newUser.getEmail() + "," + newUser.getContact() + "," + newUser.getStatus());
            LogFunction.writeLog(userID, "Add User", "Added new " + userType.toLowerCase() + " " + newUserID);
            return "User added successfully: " + newUser.getID();
        } catch (Exception e) {
            return "Error adding user: " + e.getMessage();
        }
    }

    // modify (modify admin and staff)
    public static String adminModify(String userID, String selectedUserID, String choice, String newValue, String oldPassword, String confirmPassword) {
        initializeUserFile();
        try {
            List<String> users = FileFunction.readFile(USER_FILE_PATH);
            for (int i = 0; i < users.size(); i++) {
                String[] userDetails = users.get(i).split(",");
                if (userDetails[0].equals(selectedUserID)) {
                    User userModify = new User(userDetails[0], userDetails[1], userDetails[2], userDetails[3], userDetails[4], userDetails[5], userDetails[6]);
                    if (choice.equalsIgnoreCase("name")) {
                        userModify.setName(newValue);
                        userDetails[1] = userModify.getName();
                        // update user session
                        if (selectedUserID.equals(userID)) {
                            UserSession.setUser(userID, newValue);
                        }
                    } else if (choice.equalsIgnoreCase("password")) {
                        if (!oldPassword.equals(userDetails[2])) {
                            return "Old password do not match. Please try again.";
                        }
                        if (!confirmPassword.equals(newValue)) {
                            return "Password do not match. Please try again.";
                        }
                        String checkPassword = UserValidation.validPassword(confirmPassword);
                        if (!checkPassword.equals("Valid")) {
                            return checkPassword;
                        }
                        userModify.setPassword(newValue);
                        userDetails[2] = userModify.getPassword();
                    } else if (choice.equalsIgnoreCase("email")) {
                        String checkEmail = UserValidation.validEmail(newValue);
                        if (!checkEmail.equals("Valid")) {
                            return checkEmail;
                        }
                        userModify.setEmail(newValue);
                        userDetails[4] = userModify.getEmail();
                    } else if (choice.equalsIgnoreCase("contact")) {
                        String checkContact = UserValidation.validContact(newValue, "Admin");
                        if (!checkContact.equals("Valid")) {
                            return checkContact;
                        }
                        userModify.setContact(newValue);
                        userDetails[5] = userModify.getContact();
                    } else {
                        return "Error: Invalid choice.";
                    }
                    //.set(index, newElement) - replaces an element at a specified position with another element in an ArrayList instance
                    users.set(i, String.join(",", userDetails));
                    FileFunction.overwriteFile(USER_FILE_PATH, users);
                    LogFunction.writeLog(userID, "Modify User", "Modified " + selectedUserID + "'s " + choice);
                    return "User's details updated successfully";
                }
            }
            return "Admin ID not found";
        } catch (Exception e) {
            return "Error modifying Admin user: " + e.getMessage();
        }
    }
    
    // modify (staff - can only modify personal details)
    public static String staffModify(String userID, String choice, String newValue, String oldPassword, String confirmPassword) {
        initializeUserFile();
        try {
            List<String> users = FileFunction.readFile(USER_FILE_PATH);
            for (int i = 0; i < users.size(); i++) {
                String[] userDetails = users.get(i).split(",");
                if (userDetails[0].equals(userID)) {
                    User userModify = new User(userDetails[0], userDetails[1], userDetails[2], userDetails[3], userDetails[4], userDetails[5], userDetails[6]);
                    if (choice.equalsIgnoreCase("password")) {
                        if (!oldPassword.equals(userDetails[2])) {
                            return "Old password do not match. Please try again.";
                        }
                        if (!confirmPassword.equals(newValue)) {
                            return "Password do not match. Please try again.";
                        }
                        String checkPassword = UserValidation.validPassword(confirmPassword);
                        if (!checkPassword.equals("Valid")) {
                            return checkPassword;
                        }
                        userModify.setPassword(newValue);
                        userDetails[2] = userModify.getPassword();
                    } else if (choice.equalsIgnoreCase("email")) {
                        String checkEmail = UserValidation.validEmail(newValue);
                        if (!checkEmail.equals("Valid")) {
                            return checkEmail;
                        }
                        userModify.setEmail(newValue);
                        userDetails[4] = userModify.getEmail();
                    } else if (choice.equalsIgnoreCase("contact")) {
                        String checkContact = UserValidation.validContact(newValue, "Staff");
                        if (!checkContact.equals("Valid")) {
                            return checkContact;
                        }
                        userModify.setContact(newValue);
                        userDetails[5] = userModify.getContact();
                    } else {
                        return "Error: Invalid choice.";
                    }
                    users.set(i, String.join(",", userDetails));
                    FileFunction.overwriteFile(USER_FILE_PATH, users);
                    LogFunction.writeLog(userID, "Modify Personal Details", "Modified " + choice);
                    return "Staff's details updated successfully";
                }
            }
            return "Staff ID not found";
        } catch (Exception e) {
            return "Error modifying Staff user: " + e.getMessage();
        }
    }

    // search user (staff n admin)
    public static List<User> searchUser(String searchTerm, String userType) {
        List<User> searchResults = new ArrayList<>();
        try {
            List<String> users = FileFunction.readFile(USER_FILE_PATH);
            for (String user : users) {
                String[] userDetails = user.split(",");
                if ((userDetails[0].equalsIgnoreCase(searchTerm) || userDetails[1].equalsIgnoreCase(searchTerm)) && userDetails[3].equalsIgnoreCase(userType)) {
                    User userSearch = new User(userDetails[0], userDetails[1], userDetails[2], userDetails[3], userDetails[4], userDetails[5], userDetails[6]);
                    searchResults.add(userSearch);
                }
            }
        } catch (Exception e) {
            System.out.println("Error searching for user: " + e.getMessage());
        }
        return searchResults;
    }

    // delete user (staff n admin)
    public static String deleteUser(String userID, String userIDSearch) {
        initializeUserFile();
        try {
            List<String> users = FileFunction.readFile(USER_FILE_PATH);
            for (int i = 0; i < users.size(); i++) {
                String[] userDetails = users.get(i).split(",");
                if (userDetails[0].equals(userIDSearch)) {
                    userDetails[6] = "Deleted";
                    users.set(i, String.join(",", userDetails));
                    FileFunction.overwriteFile(USER_FILE_PATH, users);
                    LogFunction.writeLog(userID, "Delete User", "Deleted " + userIDSearch);
                    return "User: " + userIDSearch + " deleted successfully";
                }
            }
            return "User ID not found.";
        } catch (Exception e) {
            return "Error deleting user: " + e.getMessage();
        }
    }
}
