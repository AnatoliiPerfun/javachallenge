package com.example.javachallenge;

import java.util.Scanner;

public class PassComplexity {
    public static boolean isPassComplex(String pass) {
        return pass.length() >= 6 &&
                pass.matches(".*\\d.*") &&
                pass.matches(".*[a-z].*") &&
                pass.matches(".*[A-Z].*");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your password: ");
        String userInput = scanner.nextLine();
        System.out.println("Is the password complex? " + isPassComplex(userInput));
    }
}
