package com.rupesh;

import java.util.Scanner;
import java.io.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Task1 {
	public static void main(String[] args) {
		JSONParser parser = new JSONParser();	
		Scanner obj=new Scanner(System.in);
		try {
			// creating json array and storeing json objects form private method that return json object
			JSONArray jsonMainArr=new JSONArray();
			System.out.println("Enter No.of student : ");
			int studentCount=obj.nextInt();
			obj.nextLine();
			for(int i=0; i<studentCount ;i++)
				jsonMainArr.add(jsonObjectadder(obj,i+1));
			// store json array into file
			FileWriter file = new FileWriter("C:\\Users\\rupesh\\Desktop\\Daily task\\Java project\\external src\\output file\\file2.json");
			file.write(jsonMainArr.toJSONString());
            System.out.println(jsonMainArr);
			file.close();

		} catch (IOException e) {
			System.out.println(e);
		}
	}
	private static JSONObject jsonObjectadder(Scanner obj,int count) {
		JSONObject jsonStudentObj=new JSONObject();
		System.out.println("Enter details of student number "+count);
		System.out.println("Enter roll number of the student : ");
		String roll_no=obj.nextLine();
		//roll_no=obj.nextLine();
		System.out.print("Enter Name.of the student : ");
		String name1=obj.nextLine();
		jsonStudentObj.put("name",name1);
		System.out.println("Enter marks in subject 1 for the student : ");
		int sub1=obj.nextInt();
		System.out.println("Enter marks in subject 2 for the student : ");
		int sub2=obj.nextInt();
		System.out.println("Enter marks in subject 3 for the student : ");
		int sub3=obj.nextInt();
		jsonStudentObj.put("roll_no", roll_no);
		jsonStudentObj.put("Subject_1", sub1);
		jsonStudentObj.put("Subject_2", sub2);
		jsonStudentObj.put("Subject_3", sub3);
		System.out.println(jsonStudentObj);
		return jsonStudentObj;
	}
}
