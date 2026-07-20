package com.loan.app;

public class Loan {
    private int loanId;
    private double amount;
    private float interestRate;
    private String status;

    public int getLoanId(){
        return loanId;
    }
    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }
    public double getAmount(){
        return amount;
    }
    public void setAmount(double amount){
        this.amount=amount;
    }
    public float getInterestRate(){
        return interestRate;
    }
    public void setInterestRate(float interestRate){
        this.interestRate=interestRate;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public Loan(){}

    public Loan(int loanId,double amount,float interestRate,String status){
        this.loanId=loanId;
        this.amount=amount;
        this.interestRate=interestRate;
        this.status=status;
    }

    @Override
    public String toString(){
        return "Loan{" +
                "loanId = "+ loanId +
                ", amount = "+ amount +'\''+
                ", intrestRate = "+ interestRate +'\''+
                ", status = "+ status +'\''+
                '}';
    }
}