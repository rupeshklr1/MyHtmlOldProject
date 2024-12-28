package io.files;

import java.io.*;  
import java.util.Scanner;  

public class task1 {
	public static void main(String[] args) {
		try {
		Scanner sc = new Scanner(new File("C:\\Users\\rupesh\\Desktop\\Daily task\\Java project\\jdbcProject1\\io\\files\\Results.csv")).useDelimiter("\n");  
//		sc.useDelimiter("\n");
		sc.next();
		DbConnectCsvFileData insertobj=new DbConnectCsvFileData();
		while (sc.hasNext())  
		{  
			String kString=sc.next().replace("\n", "");
	        String[] arrOfStr = kString.substring(0, kString.length()-1).split(",");	
	        System.out.println();
	        int i=0;
//	        for (String a : arrOfStr)
//	            System.out.print(i+" ->"+a);
	        int i1=Integer.parseInt(arrOfStr[0]);
	        csvFileObj obj= new csvFileObj(
	        		i1, 
	        		arrOfStr[1],
	        		arrOfStr[2],
	        		arrOfStr[3],
	        		arrOfStr[4],
	        		Integer.valueOf(arrOfStr[5]),
	        		Integer.valueOf(arrOfStr[6]),
	        		Integer.valueOf(arrOfStr[7]),
	        		arrOfStr[8] );
	        //System.out.println(insertobj.AddDataSet(obj));      
	        
		}   
		sc.close(); 
		}catch (Exception e) {e.printStackTrace();System.out.println(e);}
	}
	

	
	
}

class csvFileObj{
	protected int id,isDelected,empExperiencesInMonth,empExperiencesYear;
	protected String lastModifiedDate,empName,phone,empRole,empId;
	public csvFileObj(int id,String empName,String phone,String empRole,String empId,int empExperiencesYear,int empExperiencesInMonth) {
		this(id, empName, phone, empRole, empId, empExperiencesYear, empExperiencesInMonth, 0, "")	;	
	}
	public csvFileObj(int id,String empName,String phone,String empRole,String empId,int empExperiencesYear,int empExperiencesInMonth,int isDelected,String lastModifiedDate) {
		this.id=id;
		this.empName=empName;
		this.phone=phone;
		this.empRole=empRole;
		this.empId=empId;
		this.empExperiencesYear=empExperiencesYear;
		this.empExperiencesInMonth=empExperiencesInMonth;
		this.isDelected=isDelected;
		if(lastModifiedDate.equals("NULL")) {			
			lastModifiedDate="";
		}
		this.lastModifiedDate=lastModifiedDate;
	}
	@Override
	public String toString() {
		return this.empName;
	}
}
