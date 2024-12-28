package com.jdbc6;

public class Bank {
	  private String accountNum;
	    private double balance;

	    Bank(String accountNum, double balance) {
	        this.accountNum = accountNum;
	        this.balance = balance;
	    }
	    public void deposit(double amount) {
	        balance += amount;
	    }
	    public void withdraw(double amount) {
	            balance -= amount;
	    }
	    public double getBalance() {
	        return balance;
	    }
	    @Override
	    public String toString() {
	    	String kString="\nThe Account number is "+this.accountNum+"\nThe balance amount is "+ String.valueOf(balance) ;
	    	return kString;
	    }
}



































