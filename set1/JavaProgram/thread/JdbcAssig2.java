package com.jdbc;

import java.io.*;
import java.sql.*;
import java.util.Iterator;
import java.util.Scanner;

class ownThread extends Thread {
	 public void run() {
		 System.out.println("thread created.");
		 try {
			 // String threadNmaeString=Thread.currentThread().getName() ;
			String conURlString="jdbc:sqlserver://192.168.3.125;database=SQLTraining",userName ="RupeshKrish",userPassword="ruRk!sql56";
			Connection conn1=DriverManager.getConnection(conURlString,userName,userPassword);
			PreparedStatement	psmt=conn1.prepareStatement("select TOP 1 * from rup_studentlist");
			ResultSet resultSet=psmt.executeQuery();
			if(resultSet.isBeforeFirst()) {//Selected query is not empty are atleast a row of data
				System.out.println( String.format("%-8s %-15s %5s","|Student Roll No","|student name "," |classe") );				
				while (resultSet.next()) {					
					System.out.println(   String.format("\t%-8d |%-15s |%5s %15s",resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3),Thread.currentThread().getName())    	);
				}					
			}else {//empty Dataset is found by executing the executeQuery
				System.out.println("empty data base?");			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }
}
class JdbcAssig2 extends Thread{
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i <8; i++) {			
			ownThread t1=new ownThread();
			t1.start();
			t1.join();
		}
	}
}
