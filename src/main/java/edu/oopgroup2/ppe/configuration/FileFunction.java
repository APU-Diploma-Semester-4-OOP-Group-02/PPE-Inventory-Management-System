package edu.oopgroup2.ppe.configuration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileFunction {
    
    public static boolean fileExists(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }

    public static void createFileIfNotExists(String filePath, String header) {
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                try (FileWriter writer = new FileWriter(filePath)) {
                    writer.write(header + "\n");
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println("Error creating file: " + filePath);
            }
        }
    }

    public static void writeFile(String filePath, String data) {
        try {
            try (FileWriter writer = new FileWriter(filePath, true)) {
                writer.write(data + "\n"); //save one row data, then \n to next line save another data
                writer.close();
            }
        } catch (IOException e) {
            System.out.println("Error writing data into file: "+ filePath);
        }
    }

    public static List<String> readFile(String filePath) {
        // Creating object of ArrayList class
        List<String> fileInformations = new ArrayList<>();
        // Load data from file
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        String line;
        boolean firstLine = true;
        while ((line = reader.readLine()) != null) {
            if (firstLine) {
                firstLine = false; //dont need to read the first line header
                continue;
            }
            fileInformations.add(line);
        }
        } catch (IOException e) {
            System.out.println("Error reading file: " + filePath);
        }
        return fileInformations;
    }

    public static void overwriteFile(String filePath, List<String> data) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String header = reader.readLine(); // header = first line
            reader.close();
            try (FileWriter writer = new FileWriter(filePath)) {
                if (header != null) {
                    writer.write(header + "\n"); // always write the header first
                }
                for (String line : data) {
                    writer.write(line + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Error overwriting file: " + filePath);
        }
    }
}
