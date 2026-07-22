package com.loan.app;

public class Admin extends Employee{

    public Admin(int employeeId, String department, String phone, String name, String email){
        super(employeeId,department,phone, name, email);
    }

    @Override
    public void displayDetails(){
        System.out.println("Admin Details");
    }

    @Override
    public String toString(){
        return "Inside Admin:  "+super.toString();
    }
}
