package com.loan.app;
import java.util.Objects;

public class Customer extends Person {
    private int customerId;
    private final String bankName = "HDFC Bank";

    //wrote intentionally to check final functionality
    //bankName="ABCBank";

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
        System.out.println("Customer ID : " + customerId);

        super.displayDetails();
    }

    @Override
    public boolean equals(Object o){
        if(this==o){
            return true;
        }
        if(o==null || getClass()!=o.getClass()){
            return false;
        }
        Customer cust = (Customer) o;
        return customerId == cust.customerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId);
    }
}