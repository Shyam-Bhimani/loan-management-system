package com.loan.app;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Customer extends Person implements Comparable<Customer>{
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

    public static void displayCustomers(List<Customer> customers){
        Iterator<Customer> it = customers.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
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

    @Override
    public int compareTo(Customer obj) {
        return Integer.compare(this.getCustomerId(),obj.getCustomerId());
    }
}