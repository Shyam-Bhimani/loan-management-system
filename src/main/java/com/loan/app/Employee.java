package com.loan.app;

public class Employee extends Person {
    private int employeeId;
    private String department;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    public Employee() {

    }

    public Employee(int employeeId, String department, String phone, String name, String email){
        super(phone, name, email);
        this.employeeId=employeeId;
        this.department=department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", department='" + department + '\'' +
                ", " + super.toString() +
                '}';
    }

    @Override
    public void displayDetails(){
        System.out.println("Employee ID : " + employeeId);

        super.displayDetails();
    }
}