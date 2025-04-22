package com.pluralsight;

public class Employee {
    private short employeeId;
    private String name;
    private float hoursWorked, payRate;

    public Employee(short employeeId, String name, float hoursWorked, float payRate) {
        this.employeeId = employeeId;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;
    }
    public Employee(){
        this.employeeId = 0;
        this.name = "";
        this.hoursWorked = 0.0f;
        this.payRate = 0.0f;
    }

    public short getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(short employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(float hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public float getPayRate() {
        return payRate;
    }

    public void setPayRate(float payRate) {
        this.payRate = payRate;
    }
    public float getGrossPay(float hoursWorked, float payRate) {
        float result = 0;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;
        result = hoursWorked * payRate;
        return result;
    }
}
