package com.jdbc6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class BankApp {

	private  static Scanner obj = new Scanner(System.in);
	private  static Connection conn1=null;
	private  static ResultSet resultSet=null;
	private  static PreparedStatement psmt=null ;
	private  final static String conURlString="jdbc:sqlserver://192.168.3.125;database=SQLTraining",userName ="RupeshKrish",userPassword="ruRk!sql56",
			BanktableName=" klr.bankDetails ",BanktableInsertValuetype=" (cus_name,cus_phone,branch,accounctnumber ,amount)",BanktableInsertValuePara="(?,?, ? ,?,?)";
	//private final static int minBalance=500;
	public static void main(String[] args) {
		HashMap <String, SavingAccountHdfc> custmerslist =new HashMap(); 
		long custmercount=1;
		Scanner objScanner=new Scanner(System.in);	
		getBankDataSet(custmerslist);
		custmercount+=custmerslist.size();
		String optionString="",accNumber="";
		do {
			System.out.println("\n1-creating account\t2-bank details\t3-withdraw money\t4-deposite\t5-stop\n6-For number AccountHolders\t7-For Know all Accountnumbers");
			System.out.print("Enter your choose : ");
			optionString=objScanner.nextLine();
			switch (optionString) {
			case "1": {
				String flag=CreateSavingAccount(objScanner,custmercount,custmerslist);
				if(!flag.isEmpty()) {
						custmercount+=1;
						System.out.println("THE PERSON ADDED SUCCESSFULLY.");
					}
				break;
			}
			case "2":{
				System.out.print("Enter your Bank account number : ");
				accNumber=objScanner.nextLine();
				if(custmerslist.containsKey(accNumber)) {
					System.out.print(custmerslist.get(accNumber));
				}else {
					System.out.println("Given account is not found.Sorry we can't give our servies for this account number.");
				}
				accNumber="";
				break;
			}
			case "3":{
				System.out.print("Enter your Bank account number : ");
				accNumber=objScanner.nextLine();
				if(custmerslist.containsKey(accNumber)) {
					SavingAccountHdfc tempAccountHdfc=custmerslist.get(accNumber);
					System.out.print("Enter the amount to withdraw : ");
					String amString=objScanner.nextLine();
					tempAccountHdfc.withdraw( Double.valueOf(amString) );
				}else {
					System.out.println("Given account is not found.Sorry we can't give our servies for this account number.");
				}
				accNumber="";
				break;
			}
			case "4":{
				System.out.print("Enter your Bank account number : ");
				accNumber=objScanner.nextLine();
				if(custmerslist.containsKey(accNumber)) {
					SavingAccountHdfc tempAccountHdfc=custmerslist.get(accNumber);
					System.out.print("Enter the amount to deposite : ");
					String amString=objScanner.nextLine();
					tempAccountHdfc.deposit( Double.valueOf(amString) );
				}else {
					System.out.println("Given account is not found.Sorry we can't give our servies for this account number.");
				}
				accNumber="";
				break;
			}
			
			case "6":System.out.println("Account holder in our bank is "+(custmercount-1));
			case "5":break;
			case "7":
					if(custmerslist.isEmpty()) {
						System.out.println("No account holder are available."+custmerslist.keySet());
					}else {
						System.out.println(custmerslist.keySet());
					}
				break;		
			default:
				System.out.print("You Entered wrong choose.soory we can't help you now.");;
			}
		}while(!optionString.equals("5"));
		System.out.println("Thanks for using our bank.");
		
	}
	private static void getBankDataSet(HashMap <String, SavingAccountHdfc> custmerslist) {
		try {//all connection block
			conn1 =DriverManager.getConnection(conURlString,userName,userPassword);
			psmt=conn1.prepareStatement("select * from klr.bankDetails");
			resultSet=psmt.executeQuery();
			if(resultSet.isBeforeFirst()) {//Selected query is not empty are atleast a row of data				
				while (resultSet.next()) {	
					String accNumber=(String)resultSet.getString(4);
					custmerslist.put(accNumber,
							new SavingAccountHdfc(
									resultSet.getString(1),
									resultSet.getString(2),
									resultSet.getString(3),
									accNumber,
									Double.valueOf(resultSet.getString(5))
								));
				}					
			}else {//empty Dataset is found by executing the executeQuery
				System.out.println("empty database?");			
			}
			
		}catch (Exception e) {	System.out.println("While try to buliding connection / transaction  "+e);
		}finally {//closing all connection from DB 
			try {
				if(resultSet!=null) {
					resultSet.close();
				}
				if(psmt!=null) {
					psmt.close();
				}
				if(conn1!=null) {
					conn1.close();
				}
			}catch (Exception e) {System.out.println("while connection closeing form DB "+e);}
		}
	}
	private static void addToBankDataSet(SavingAccountHdfc tempuser) {
		try {//all connection block
			conn1 =DriverManager.getConnection(conURlString,userName,userPassword);
			psmt=conn1.prepareStatement("insert into "+BanktableName+BanktableInsertValuetype+" values "+BanktableInsertValuePara);
			psmt.setString(1,tempuser.cusNameString);
			psmt.setString(2,tempuser.phone_nu);
			psmt.setString(3,tempuser.branch);
			psmt.setString(4,tempuser.AccountNumber);
			psmt.setString(5,String.valueOf(tempuser.getBalance()));
			psmt.executeUpdate();	
			
		}catch (Exception e) {	System.out.println("While try to buliding connection / transaction  "+e);
		}finally {//closing all connection from DB 
			try {
				if(psmt!=null) {
					psmt.close();
				}
				if(conn1!=null) {
					conn1.close();
				}
			}catch (Exception e) {System.out.println("while connection closeing form DB "+e);}
		}
	}
	
	private static String CreateSavingAccount(Scanner obj,long num,HashMap <String, SavingAccountHdfc> custmerslist) {
		System.out.println("Welcome to HDFC.");
		System.out.print("The minimum balances 500 is required.\nEnter the name :");
		String name=obj.nextLine().trim();
		System.out.print("The minimum balances 500 so required to deposit atleast 500 or more :");		
		double depositemoney=obj.nextDouble();
		obj.nextLine();
		if(depositemoney<SavingAccountHdfc.minBalance) {
			while(true) {
				System.out.println("Try to add some more money equal to "+SavingAccountHdfc.minBalance);
				System.out.print("The minimum balances "+SavingAccountHdfc.minBalance+" so required to deposit atleast "+SavingAccountHdfc.minBalance+" or more :");
				String tempstString=obj.nextLine();
				if(tempstString.equals("")) {
					return "";
				}
				if( Double.valueOf(tempstString)>=SavingAccountHdfc.minBalance) {
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
		
		custmerslist.put(tempString,new SavingAccountHdfc(name,phon,branchName,tempString,depositemoney)) ;

		addToBankDataSet(custmerslist.get(tempString));
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




