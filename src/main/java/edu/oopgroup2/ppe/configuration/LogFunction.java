package edu.oopgroup2.ppe.configuration;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LogFunction {
    private static final String LOG_FILE_PATH = "txtFiles/log.txt";
    
    public static void initializeLogFile() {
        try {
            if (!FileFunction.fileExists(LOG_FILE_PATH)) {
                FileFunction.createFileIfNotExists(LOG_FILE_PATH, "datetime,userID,action,details");
            }
        } catch (Exception e) {
            System.out.println("Error initializing log file: " + e.getMessage());
        }
    }

    public static void writeLog(String userID, String action, String details) {
        initializeLogFile();
        try (FileWriter writer = new FileWriter(LOG_FILE_PATH, true)) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            String logEntry = timestamp + "," + userID.toUpperCase() + "," + action + "," + details + "\n";
            writer.write(logEntry);
        } catch (IOException e) {
            System.out.println("Error writing to log file: " + e.getMessage());
        }
    }
    
    public static List<String> viewLog() {
        try {
            List<String> logs = FileFunction.readFile(LOG_FILE_PATH);
            List<String> logList = new ArrayList<>();
            for (String log : logs) {
                String[] logDetails = log.split(",");
                logList.add(logDetails[0] + "," + logDetails[1] + "," + logDetails[2] + "," + logDetails[3]);
            }
            return logList;
        } catch (Exception e) {
            System.out.println("Error viewing log activities: " + e.getMessage());
            return new ArrayList<>();
        }
    }
    
    public static List<String> searchLog(String searchTerm) {
        List<String> filteredLogs = new ArrayList<>();
        try {
            List<String> logs = viewLog();
            for (String log : logs) {
                String[] logDetails = log.split(",");
                if (logDetails[1].equalsIgnoreCase(searchTerm) || logDetails[2].equalsIgnoreCase(searchTerm)) {
                    filteredLogs.add(logDetails[0]+","+logDetails[1]+","+logDetails[2]+","+logDetails[3]);
                }
            }
        }   catch (Exception e) {
            System.out.println("Error searching for log activities: " + e.getMessage());
        }
        return filteredLogs;
    }
}
