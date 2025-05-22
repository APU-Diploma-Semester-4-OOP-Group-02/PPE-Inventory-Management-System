package edu.oopgroup2.ppe.model.hospital;

import java.util.List;

import edu.oopgroup2.ppe.configuration.AssignId;
import edu.oopgroup2.ppe.configuration.FileFunction;
import edu.oopgroup2.ppe.configuration.LogFunction;
import edu.oopgroup2.ppe.configuration.UserValidation;
import java.util.ArrayList;

public class HospitalManagement {
    private static final String HOSPITAL_FILE_PATH = "txtFiles/hospitals.txt";

    public static void initializeHospitalFile() {
        try {
            if (!FileFunction.fileExists(HOSPITAL_FILE_PATH)) {
                FileFunction.createFileIfNotExists(HOSPITAL_FILE_PATH, "hospitalCode,hospitalName,hospitalEmail,hospitalContact,hospitalStatus");
            }
        } catch (Exception e) {
            System.out.println("Error initializing hospital file: " + e.getMessage());
        }
    }
    
    // get all hospitals
    public static List<String> getAllHospitals() {
        initializeHospitalFile();
        List<String> allHospitals = FileFunction.readFile(HOSPITAL_FILE_PATH);
        List<String> activeHospitals = new ArrayList<>();
        for (String hospital : allHospitals) {
            String[] hospitalDetails = hospital.split(",");
            if (hospitalDetails[4].equalsIgnoreCase("active")) {
                activeHospitals.add(hospital);
            }
        }
        return activeHospitals;
    }
    
    // get all hospital id (for dropdown purposes)
    public static List<String> getAllHospitalCodes() {
        List<String> hospitalCodes = new ArrayList<>();
        try {
            List<String> hospitals = FileFunction.readFile(HOSPITAL_FILE_PATH);
            for (String hospital : hospitals) {
                String[] hospitalDetails = hospital.split(",");
                if (hospitalDetails[4].equalsIgnoreCase("active")) {
                    hospitalCodes.add(hospitalDetails[0]);
                }
            }
        } catch (Exception e) {
            System.out.println("Error fetching hospital id: " + e.getMessage());
        }
        return hospitalCodes;
    }

    // add hospital
    public static String addHospital(String userID, String hospitalName, String hospitalEmail, String hospitalContact) {
        try {
            List<String> hospitals = FileFunction.readFile(HOSPITAL_FILE_PATH);
            String checkEmail = UserValidation.validEmail(hospitalEmail);
            if (!checkEmail.equals("Valid")) {
                return checkEmail;
            }
            String checkContact = UserValidation.validContact(hospitalContact, "Hospital");
            if (!checkContact.equals("Valid")) {
                return checkContact;
            }
            String hospitalCode = AssignId.assignID(HOSPITAL_FILE_PATH, "Hospital");
            String hospitalStatus = "Active";
            Hospital newHospital = new Hospital(hospitalCode, hospitalName, hospitalEmail, hospitalContact, hospitalStatus);
            FileFunction.writeFile(HOSPITAL_FILE_PATH, newHospital.getID() + "," + newHospital.getName() + "," + newHospital.getEmail() + "," + newHospital.getContact() + "," + newHospital.getStatus());
            LogFunction.writeLog(userID, "Add Hospital", "Added new hospital " + hospitalCode);
            return "Hospital added successfully: " + newHospital.getID();
        } catch (Exception e) {
            return "Error adding hospital: " + e.getMessage();
        }
    }

    // modify hospital
    public static String modifyHospital(String userID, String hospitalCode, String fieldToModify, String newValue) {
        initializeHospitalFile();
        try {
            List<String> hospitals = FileFunction.readFile(HOSPITAL_FILE_PATH);
            for (int i = 0; i < hospitals.size(); i++) {
                String[] hospitalDetails = hospitals.get(i).split(",");
                if (hospitalDetails[0].equals(hospitalCode)) {
                    Hospital hospitalModify = new Hospital(hospitalDetails[0], hospitalDetails[1], hospitalDetails[2], hospitalDetails[3], hospitalDetails[4]);
                    if (fieldToModify.equalsIgnoreCase("name")) {
                        hospitalModify.setName(newValue);
                        hospitalDetails[1] = hospitalModify.getName();
                    } else if (fieldToModify.equalsIgnoreCase("email")){
                        String checkEmail = UserValidation.validEmail(newValue);
                        if (!checkEmail.equals("Valid")) {
                            return checkEmail;
                        }
                        hospitalModify.setEmail(newValue);
                        hospitalDetails[2] = hospitalModify.getEmail();
                    } else if (fieldToModify.equalsIgnoreCase("contact")) {
                        String checkContact = UserValidation.validContact(newValue, "Hospital");
                        if (!checkContact.equals("Valid")) {
                            return checkContact;
                        }
                        hospitalModify.setContact(newValue);
                        hospitalDetails[3] = hospitalModify.getContact();
                    } else {
                        return "Error: Invalid choice.";
                    }
                    hospitals.set(i, String.join(",", hospitalDetails));
                    FileFunction.overwriteFile(HOSPITAL_FILE_PATH, hospitals);
                    LogFunction.writeLog(userID, "Modify Hospital", "Modified " + hospitalCode + "'s " + fieldToModify);
                    return "Hospital's details updated successfully!";
                }
            }
            return "Hospital ID not found.";
        } catch (Exception e) {
            return "Error modifying hospital: " + e.getMessage();
        }
    }

    //search for hospital
    public static List<Hospital> searchHospital(String searchTerm) {
        List<Hospital> searchResults = new ArrayList<>();
        try {
            List<String> hospitals = FileFunction.readFile(HOSPITAL_FILE_PATH);
            for (String hospital : hospitals) {
                String[] hospitalDetails = hospital.split(",");
                if (hospitalDetails[0].equalsIgnoreCase(searchTerm) || hospitalDetails[1].equalsIgnoreCase(searchTerm)) {
                    Hospital hospitalSearch = new Hospital(hospitalDetails[0], hospitalDetails[1], hospitalDetails[2], hospitalDetails[3], hospitalDetails[4]);
                    searchResults.add(hospitalSearch);
                }
            }
        } catch (Exception e) {
            System.out.println("Error searching for hospital: " + e.getMessage());
        }
        return searchResults;
    }

    // delete hospital
    public static String deleteHospital(String userID, String hospitalCode) {
        initializeHospitalFile();
        try {
            List<String> hospitals = FileFunction.readFile(HOSPITAL_FILE_PATH);
            for (int i = 0; i < hospitals.size(); i++) {
                String[] hospitalDetails = hospitals.get(i).split(",");
                if (hospitalDetails[0].equals(hospitalCode)) {
                    hospitalDetails[4] = "Deleted";
                    hospitals.set(i, String.join(",", hospitalDetails));
                    FileFunction.overwriteFile(HOSPITAL_FILE_PATH, hospitals);
                    LogFunction.writeLog(userID, "Delete Hospital", "Deleted  " + hospitalCode);
                    return "Hospital: " + hospitalCode + " deleted successfully!";
                }
            }
            return "Hospital ID not found.";
        } catch (Exception e) {
            return "Error deleting hospital: " + e.getMessage();
        }
    }
}

