package edu.oopgroup2.ppe.configuration;

public class UserValidation {
    public static String validPassword(String password) {
        try {
            boolean hasLetter = false;
            boolean hasDigit = false;
            boolean hasUpper = false;
            boolean hasLower = false;
            if (password.isEmpty()) {
                return "Password cannot be empty.";
            }
            if (password.length() < 8) {
                return "Password must contain at least 8 characters.";
            }
            for (char character : password.toCharArray()) {
                if (Character.isLetter(character)) {
                    hasLetter = true;
                    if (Character.isUpperCase(character)) hasUpper = true;
                    if (Character.isLowerCase(character)) hasLower = true;
                }
                if (Character.isDigit(character)) {
                    hasDigit = true;
                }
            }
            if (!hasLetter || !hasDigit) {
                return "Password must contain both letters and numbers.";
            }
            if (!hasUpper || !hasLower) {
                return "Password must contain both uppercase and lowercase letters.";
            }
            return "Valid";
        } catch (Exception e) {
            return "Error validating password: " + e.getMessage();
        }
    }

    public static String validEmail(String email) {
        try {
            if (email.isEmpty()) {
                return "Email cannot be empty.";
            }
            if (email.contains("@") && email.contains(".")) {
                return "Valid";
            } else {
                return "Invalid email format. Expected format: x@x.com";
            }
        } catch (Exception e) {
            return "Error validating email: " + e.getMessage();
        }
    }

    public static String validContact(String contact, String userType) {
        try {
            if (contact.isEmpty()) {
                return "Contact number cannot be empty.";
            }
            if (!contact.contains("-")) {
                return "Contact number must contain a dash '-'.";
            }
            String[] parts = contact.split("-");
            if (userType.equalsIgnoreCase("admin") || userType.equalsIgnoreCase("staff")) {
                if (parts.length != 2) {
                    return "Invalid contact format. Expected format: 01x-xxxxxxx or 01x-xxxxxxxx";
                }
                if (parts[0].length() != 3 || !parts[0].startsWith("01")) {
                    return "Invalid prefix. Expected format: 01x";
                }
                if (parts[1].length() < 7 || parts[1].length() > 8) {
                    return "Invalid length. Expected 7 or 8 digits after the dash.";
                }
                for (char c : (parts[0] + parts[1]).toCharArray()) {
                    if (!Character.isDigit(c)) {
                        return "Contact number must contain only digits except for the dash.";
                    }
                }
            } else if (userType.equalsIgnoreCase("supplier") || userType.equalsIgnoreCase("hospital")) {
                if (parts.length != 2) {
                    return "Invalid contact format. Expected format: 03-xxxxxxxx";
                }
                if (!parts[0].equals("03")) {
                    return "Invalid prefix. Expected format: 03.";
                }
                if (parts[1].length() != 8) {
                    return "Invalid length. Expected 8 digits after the dash.";
                }
                for (char c : (parts[0] + parts[1]).toCharArray()) {
                    if (!Character.isDigit(c)) {
                        return "Contact number must contain only digits except for the dash.";
                    }
                }
            } else {
                return "Invalid user type for contact validation.";
            }

            return "Valid";
        } catch (Exception e) {
            return "Error validating contact number: " + e.getMessage();
        }
    }
}
