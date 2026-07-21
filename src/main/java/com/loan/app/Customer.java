package com.loan.app;

public class Customer extends Person {
    private int customerId;


    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Customer() {

    }

    public Customer(int customerId,String phone, String name, String email){
        super(phone, name, email);
        this.customerId=customerId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +", "+
                super.toString()+
                '}';
    }

    @Override
    public void displayDetails(){
        System.out.println("Customer Details");
    }
}