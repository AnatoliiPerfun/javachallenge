package com.example.javachallenge;

import org.springframework.util.StringUtils;

import java.io.*;
import java.util.Scanner;

public class SecretMessage {
    public static void redactTextFile(String fileName, String[] redactedWordsArray) {

        if (!fileName.contains(".txt")) {
            System.out.println("This is not a text file.");
            return;
        }

        try {
            File originalFile = new File(fileName);
            BufferedReader originFileReader = new BufferedReader(new FileReader(originalFile));
            File redactedFile = new File("redacted-" + fileName);
            BufferedWriter redactedFileWriter = new BufferedWriter(new FileWriter(redactedFile));
            String currentLine = originFileReader.readLine();

            while(currentLine != null) {
                for (String redactedWord : redactedWordsArray) {
                    currentLine = StringUtils.replace(currentLine, redactedWord, "REDACTED");
                }
                redactedFileWriter.append(currentLine).append("\n");
                currentLine = originFileReader.readLine();
            }
            originFileReader.close();
            redactedFileWriter.close();
        } catch (IOException e) {
            System.out.println("Something went wrong..." + e);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What file would u like to" + "redact?");
        String fileName = scanner.nextLine();

        System.out.println("What words would u like to redact? " +
                "Separate each word or phrase with a comma.");

        String redactedWords = scanner.nextLine();
        String[] redactedWordsList = redactedWords.split(",");
        redactTextFile(fileName, redactedWordsList);
    }
}

