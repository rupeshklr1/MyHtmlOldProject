package com.rupesh;

import java.io.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
public class Task1Acess {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		JSONParser parser = new JSONParser();
		try {
		
			Object jsonStdFile = parser.parse(new FileReader("C:\\\\Users\\\\rupesh\\\\Desktop\\\\Daily task\\\\Java project\\\\external src\\\\output file\\\\file2.json"));
			JSONArray studentDts=(JSONArray) jsonStdFile;
			jsonStudentList(studentDts);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	private static void jsonStudentList(JSONArray studentDts) {
		long totalSubject1=0,totalSubject2=0,totalSubject3=0;
		int count=0;
		try {
			for (Object each : studentDts) {
				JSONObject tempObj=(JSONObject)each;
				String name=(String)tempObj.get("name");
				String roll_no=(String)tempObj.get("roll_no");
				long sub1M=(long)tempObj.get("Subject_1");
				long sub2M=(long)tempObj.get("Subject_2");
				long sub3M=(long)tempObj.get("Subject_3");
				System.out.println("Student name & score card \n\t\t"+name);
				totalSubject1+=sub1M;
				totalSubject2+=sub2M;
				totalSubject3+=sub3M;
				count+=1;
				double avg=(sub1M+sub2M+sub3M)/(double)3;
				System.out.println("The total marks is "+(sub1M+sub2M+sub3M));
				System.out.println("The average marks is "+avg);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println("\nThe total students marks is subject 1 "+totalSubject1);
		System.out.println("The average  students marks is subject 1 "+ ( totalSubject1/(double)count ) );
		System.out.println("\nThe total students marks is subject 2 "+totalSubject1);
		System.out.println("The average  students marks is subject 2 "+ ( totalSubject2/(double)count ) );
		System.out.println("\nThe total students marks is subject 3 "+totalSubject1);
		System.out.println("The average  students marks is subject 3 "+ ( totalSubject3/(double)count ) );
	}
}
