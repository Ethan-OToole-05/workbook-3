package com.pluralsight;

import java.util.Scanner;
import java.io.*;

public class BedtimeApp {
    public static void main(String[] args) {
        try {
            //Initialize our variables and print our welcome message with a prompt.
            Scanner userInput = new Scanner(System.in);
            int userOption = 0, counter = 0;
            System.out.println("Welcome to the bedtime ap plication! Please pick a bedtime story.");
            System.out.print("(1) Goldilocks, (2) Hansel and Gretel, (3) Mary had a little lamb: ");
            userOption = userInput.nextInt();

            switch (userOption) {
                //Reads file if goldilocks is picked.
                case 1:
                    //Open a new file input stream to read information from a file.
                    FileInputStream fis = new FileInputStream("goldilocks.txt");
                    Scanner inputScanner = new Scanner(fis);

                    String input;
                    //Also long as there's something in the file we will print it to the console.
                    while(inputScanner.hasNextLine()) {
                        input = inputScanner.nextLine();
                        counter++;
                        System.out.println(counter + ". " + input);
                    }
                    inputScanner.close();
                    break;
                //Runs if hansel and gretel is picked.
                case 2:
                    fis = new FileInputStream("hansel_and_gretel.txt");
                    inputScanner = new Scanner(fis);

                    while(inputScanner.hasNextLine()) {
                        input = inputScanner.nextLine();
                        counter++;
                        System.out.println(counter + ". " + input);
                    }
                    inputScanner.close();
                    break;
                //Runs if mary had a little lamb is picked.
                case 3:
                    fis = new FileInputStream("mary_had_a_little_lamb.txt");
                    inputScanner = new Scanner(fis);

                    while(inputScanner.hasNextLine()) {
                        input = inputScanner.nextLine();
                        counter++;
                        System.out.println(counter + ". " + input);
                    }
                    inputScanner.close();
                    break;
                default:
                    System.out.println("Option not found. Please try again.");
                    break;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
