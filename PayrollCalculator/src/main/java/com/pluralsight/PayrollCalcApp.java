package com.pluralsight;
import java.io.*;

public class PayrollCalcApp {
    public static void main(String[] args) {
        try {
            FileReader file = new FileReader("employees.csv");
            BufferedReader reader = new BufferedReader(file);

            short employeeId, counter = 0;
            String name;
            float hoursWorked, payRate;
            Employee[] employees = new Employee[10];
            Employee employee;

            String input;

            while((input = reader.readLine()) != null) {
                //Used to skip the first line containing the id | name | ..."
                if(input.startsWith("id")) {
                    continue;
                }
                String[] employeeInfo = input.split("\\|");
                while(counter <= employees.length) {
                    for(int i = 0; i < employeeInfo.length; i++) {
                        employee = new Employee();
                        employee.setEmployeeId(Short.parseShort(employeeInfo[i]));
                        employee.setName(employeeInfo[i + 1]);
                        employee.setHoursWorked(Float.parseFloat(employeeInfo[i + 2]));
                        employee.setPayRate(Float.parseFloat(employeeInfo[i + 3]));
                        System.out.println(employee.getEmployeeId() + employee.getName() + employee.getGrossPay(employee.getHoursWorked(), employee.getPayRate()));
                        continue;
                    }
                    counter++;
                }

            }
            reader.close();
        }catch(IOException e) {
            System.out.println("Error reading file");
            System.out.println(e.getMessage());
        }


    }
}
