package com.rupesh;


public class SavingAccountHdfc extends Bank {
		//String name,brach,phone_nu;
		//Date date_of_brithDate;
		//SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		// Date date = formatter.parse("26-09-1989"); 
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
	@Override
	public String toString() {		
	return "The account name : "+this.cusNameString +super.toString();
	}
}
