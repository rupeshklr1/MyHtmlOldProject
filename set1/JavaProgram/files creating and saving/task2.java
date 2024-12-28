package io.files;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;  
public class task2   {  
public static void main(String[] args){  
		try   
		{  	Scanner sc=new Scanner(System.in);    
			String pathString="C:\\Users\\rupesh\\Desktop\\Daily task\\Java project\\jdbcProject1\\io\\files\\files1.txt";
			System.out.print("Enter file content: ");    
			FileOutputStream fileobj=new FileOutputStream(pathString);
			String str=sc.nextLine()+"\n"; 
			byte[] b= str.getBytes();  
			fileobj.write(b);          
			fileobj.close();   
		}   
		catch (IOException e){  
			e.printStackTrace(); 
		}         
	}  
}  