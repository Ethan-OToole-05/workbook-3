package com.pluralsight;

import java.io.*;
import java.util.Scanner;

public class PayrollCalcApp {
    public static void main(String[] args) {
        try {
            //Initialize our variables below with scanner, reader, writer, employees.
            Scanner inputName = new Scanner(System.in);
            String readFileName, writeFileName;

            //Welcome message to get a employee file and what payroll file to create
            System.out.println("Welcome!");
            System.out.print("Please enter the name of the file employee file to process: ");
            readFileName = inputName.nextLine();
            System.out.print("Please enter the name of the payroll file to create: ");
            writeFileName = inputName.nextLine();

            //Initialize our reader to read from employee file.
            FileReader file = new FileReader("src/main/resources/" + readFileName);
            BufferedReader reader = new BufferedReader(file);
            Employee[] employees = new Employee[10];
            Employee employee = new Employee();


            //Initialize our file writer and buffered writer.
            FileWriter fileWriter = new FileWriter("src/main/resources/" + writeFileName);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            //This will contain the information to write to the file.
            String text;
            //For loop to write out text to our file below is for testing.
//            for (int i = 0; i <= 1; i++) {
//                text = String.format("%d|%s|%.2f", 111, "Cam Tay", 3277.65f);
//                writer.write(text);
//            }

            //Contains the entire line that will be reader by our BufferedReader object.
            String input;

            while ((input = reader.readLine()) != null) {
                //Used to skip the first line containing the id | name | ..."
                if (input.startsWith("id")) {
                    continue;
                }
                //Checks through each info for an employee the id name ...
                String[] employeeInfo = input.split("\\|");

                for (int i = 0; i < employeeInfo.length; i++) {
                    //Send each employee into an array of employees.
                    employees[i] = employee;
                    employee.setEmployeeId(Short.parseShort(employeeInfo[i]));
                    employee.setName(employeeInfo[i + 1]);
                    employee.setHoursWorked(Float.parseFloat(employeeInfo[i + 2]));
                    employee.setPayRate(Float.parseFloat(employeeInfo[i + 3]));
                    //Sends each info to a text file.

                    text = String.format("ID: " + "%d |" + " " + "Name: " + "%s |" + " Pay: $%.2f%n", employee.getEmployeeId(), employee.getName(), employee.getGrossPay(employee.getHoursWorked(), employee.getPayRate()));
                    writer.write(text);
                    
                    //Break when we are done displaying the information for each employee.
                    break;
                }
            }
            //Close reader and writer when we are done.
            reader.close();
            writer.close();
        }catch(IOException e){
            System.out.println("Error reading file");
            System.out.println(e.getMessage());
        }
    }
}
