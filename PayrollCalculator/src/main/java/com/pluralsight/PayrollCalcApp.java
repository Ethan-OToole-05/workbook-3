package com.pluralsight;

import java.io.*;

public class PayrollCalcApp {
    public static void main(String[] args) {
        try {
            //Initialize our array, variable, file reader, and our buffered reader.

            /*FileReader file = new FileReader("src/main/resources/employees.csv");
            BufferedReader reader = new BufferedReader(file);
            Employee[] employees = new Employee[10];
            Employee employee = new Employee();

             */

            //Initialize our file writer and buffered writer.
            FileWriter fileWriter = new FileWriter("src/main/resources/payroll-sept-2023.csv");
            BufferedWriter writer = new BufferedWriter(fileWriter);

            String text;
            //For loop to write out text to our file below is for testing.
            for(int i = 0; i <= 1; i++) {
                text = String.format("%d|%s|%.2f", 111, "Cameron Tay", 3277.65f);
                writer.write(text);
            }
            writer.close();
            //Contains the entire line that will be reader by our BufferedReader object.
            /*String input;

            while ((input = reader.readLine()) != null) {
                //Used to skip the first line containing the id | name | ..."
                if (input.startsWith("id")) {
                    continue;
                }
                //Checks through each info for an employee the id name ...
                String[] employeeInfo = input.split("\\|");
                /*


                for (int i = 0; i < employeeInfo.length; i++) {
                    //Send each employee into an array of employees.
                    employees[i] = employee;
                    employee.setEmployeeId(Short.parseShort(employeeInfo[i]));
                    employee.setName(employeeInfo[i + 1]);
                    employee.setHoursWorked(Float.parseFloat(employeeInfo[i + 2]));
                    employee.setPayRate(Float.parseFloat(employeeInfo[i + 3]));
                    System.out.printf("ID: " + "%d |" + " " + "Name: " + "%s |" + " Pay: $%.2f%n", employee.getEmployeeId(), employee.getName(), employee.getGrossPay(employee.getHoursWorked(), employee.getPayRate()));
                    //Break when we are done displaying the information for each employee.
                    break;
                }
                */

            //Close the reader when we are done looking inside the employees.csv
            //reader.close();
        } catch (IOException e) {
            System.out.println("Error reading file");
            System.out.println(e.getMessage());
        }
    }
}
