package com.solvd.wordsstat;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.logging.*;

public class Main {

    private static final Logger resultLogger = Logger.getLogger("ResultLogger");
    private static final Logger errorLogger = Logger.getLogger("ErrorLogger");

    private static FileHandler resultFileHandler;
    private static FileHandler systemLogFileHandler;

    public static void main(String[] args) throws IOException {
        setupLoggers();

        File inputFile = new File("text.txt");
        if (!inputFile.exists()) {
            errorLogger.severe("File not found: " + inputFile.getAbsolutePath());
            return;
        }

        Map<String, Integer> wordCount = WordsStat.countWords(inputFile);

        wordCount.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(entry -> resultLogger.info(entry.getKey() + ": " + entry.getValue()));

        resultFileHandler.close();
        systemLogFileHandler.close();

        openResultFile();
    }

    private static void setupLoggers() throws IOException {
        resultLogger.setUseParentHandlers(false);
        errorLogger.setUseParentHandlers(false);

        resultLogger.setLevel(Level.INFO);
        errorLogger.setLevel(Level.INFO);

        resultFileHandler = new FileHandler("result.txt", false);
        resultFileHandler.setLevel(Level.INFO);
        resultFileHandler.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                return record.getMessage() + System.lineSeparator();
            }
        });
        resultLogger.addHandler(resultFileHandler);

        systemLogFileHandler = new FileHandler("WordsStat.log", false);
        systemLogFileHandler.setLevel(Level.INFO);
        systemLogFileHandler.setFormatter(new SimpleFormatter());
        errorLogger.addHandler(systemLogFileHandler);
    }

    private static void openResultFile() {
        try {
            File resultFile = new File("result.txt");
            if (resultFile.exists() && Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(resultFile);
            } else {
                errorLogger.warning("No result file is found");
            }
        } catch (IOException e) {
            errorLogger.severe("Error opening: " + e.getMessage());
        }
    }
}
