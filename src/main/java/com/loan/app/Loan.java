package com.loan.app;

public class Loan {
    private int loanId;
    private double amount;
    private double intrestRate;
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
    public double getintrestRate(){
        return intrestRate;
    }
    public void setintrestRate(float intrestRate){
        this.intrestRate=intrestRate;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public Loan(){}

    public Loan(int loanId,double amount,double intrestRate,String status){
        this.loanId=loanId;
        this.amount=amount;
        this.intrestRate=intrestRate;
        this.status=status;
    }

    @Override
    public String toString(){
        return "Loan{" +
                "loanId= "+ loanId +
                ", amount= "+ amount +'\''+
                ", intrestRate= "+ intrestRate +'\''+
                ", status= "+ status +'\''+
                '}';
    }
}