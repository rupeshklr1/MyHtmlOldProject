package com.jdbc6;


public class SavingAccountHdfc extends Bank {
	 	public static final double minBalance = 500.0;
		public String branch,phone_nu,cusNameString,AccountNumber;	
		public SavingAccountHdfc(String cusNameString,String phone_nu,String  branch,String accnum,double amount) {
		super(accnum,amount);
		this.branch=branch;
		this.AccountNumber=accnum;
		this.cusNameString=cusNameString;
		this.phone_nu=phone_nu;
	}
	public String getAccountNumber() {
		return this.AccountNumber;
	}	
	public String getName() {
		return this.cusNameString;
	}	
	public void deposit(double amount) {
		super.deposit(amount);
	}
	@Override
	public void withdraw(double amount) {
		if((getBalance()-amount)>=minBalance) {
			super.withdraw(amount);
		}else {
			System.out.println("You can't withdraw this much amount because balances is insuffieant.");
		}
	}
	public double getBalance() {
        return super.getBalance();
    }
	
	@Override
	public String toString() {		
	return "\nThe account Holder name : "+this.cusNameString +super.toString();
	}
}
