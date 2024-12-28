package com.rupesh;
import SavingAccountHdfc;
import java.util.*;
import java.util.HashMap;

public class BankApp {
	public static void main(String[] args) {
		HashMap <String, SavingAccountHdfc> custmerslist =new HashMap(); 
		//SavingAccountHdfc linkconnection=new SavingAccountHdfc();
		long custmercount=1;
		Scanner objScanner=new Scanner(System.in);
		
			System.out.println(accountNumber(9l,"cto"));
			
		while(true) {
			System.out.println("For continue creating account enter y/n : ");
			String chooseString=objScanner.nextLine();
			if(chooseString.equals("n")) {
				break;
			}
			String flag=CreateSavingAccount(objScanner,custmercount,custmerslist);
			if(!flag.isEmpty()) {
			custmercount+=1;
				System.out.println("THE PERSON ADDED SUCCESSFULLY.");
			}
			System.out.println(custmerslist);
			
		}
		System.out.println("To customer details enter Your account number : ");
		String accnumberString=objScanner.nextLine();
		 boolean flag=true;
		for (String name : custmerslist.keySet()) {
			if(accnumberString.equals(name)) {
				flag=false;
				System.out.print("\n\nYour bank details is : ");
				System.out.println(custmerslist.get(accnumberString));
			}
		}
		if(!flag) {

			System.out.print("\n\nYour account number not Exixts. ");
		}
		
	}
	private static String CreateSavingAccount(Scanner obj,long num,HashMap <String, SavingAccountHdfc> custmerslist) {
		System.out.println("Welcome to HDFC.");
		System.out.print("The minimum balances 500 is required.\nEnter the name :");
		String name=obj.nextLine().trim();
		System.out.print("The minimum balances 500 so required to deposit atleast 500 or more :");		
		double depositemoney=obj.nextDouble();
		obj.nextLine();
		if(depositemoney<500) {
			while(true) {
				System.out.println("Try to add some money ");
				System.out.print("The minimum balances 500 so required to deposit atleast 500 or more :");
				String tempstString=obj.nextLine();
				if(tempstString.equals("")) {
					return "";
				}
				if( Double.valueOf(tempstString)>=500) {
					depositemoney=obj.nextDouble();
					break;
				}
				
			}
		}
		System.out.print("Enter the phone number :");		
		String phon=obj.nextLine();
		System.out.print("Enter the branch name :");		
		String branchName=obj.nextLine();
		String tempString= accountNumber(num,branchName);
		//SavingAccountHdfc linkconnection=new SavingAccountHdfc();
		custmerslist.put(tempString,new SavingAccountHdfc(name,phon,branchName,tempString,depositemoney)) ;
		System.out.println(custmerslist.get(tempString));
		return tempString;
	}
	public static String accountNumber(long num,String branchName) {
		String preindex="";
		switch (branchName) {
		case "chittoor":
			preindex="09301";
			break;
		case "chennai":
			preindex="09302";
			break;
		case "cto":
			preindex="09303";
			break;
		default:
			preindex="09300";
		}
		if(num<10) {
			preindex+="00000";
		}else if(num<100) {
			preindex+="0000";
		}else if(num<1000) {
			preindex+="000";
		}else if(num<10000) {
			preindex+="00";
		}
		else {
			preindex+="0";
		}
		return preindex+Long.toString(num);
	}

}
