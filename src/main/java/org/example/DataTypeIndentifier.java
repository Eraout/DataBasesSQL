package org.example;

import java.util.Scanner;

public class DataTypeIndentifier {

    public static void main(String[] args) {
        boolean isWorking = true;
        Scanner sc = new Scanner(System.in);
        while (isWorking) {
            System.out.println("Enter a data: (Type 'Exit' to close) ");
            String input = sc.nextLine();
            if (isInteger(input)) {
                System.out.println("Input data is an integer.");
            } else if (isDouble(input)) {
                System.out.println("Input data is an double.");
            } else if (input.equalsIgnoreCase("exit")) {
                isWorking = false;
            } else {
                System.out.println("Input data is an string.");
            }
        }
    }
    private static boolean isInteger(String s){
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return  false;
        }
    }
    private  static boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
