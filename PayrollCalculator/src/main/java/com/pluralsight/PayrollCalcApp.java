package com.pluralsight;
import java.io.*;
import java.util.Scanner;

public class PayrollCalcApp {
    public static void main(String[] args) {
        try {
            FileReader file = new FileReader("PayrollCalculator/employees.csv");
            BufferedReader reader = new BufferedReader(file);

            String input;

            while((input = reader.readLine()) != null) {
                System.out.println(input);
            }
            reader.close();
        }catch(IOException e) {
            System.out.println("Error reading file");
            System.out.println(e.getMessage());
        }


    }
}
