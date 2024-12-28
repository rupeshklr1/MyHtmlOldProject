package com.rupesh;
import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;
public class JSONReadFromTheFileTest {
   public static void main(String[] args) {
      JSONParser parser = new JSONParser();
      try {
//         Object obj = parser.parse(new FileReader("C:\\Users\\rupesh\\Desktop\\Daily task\\Java project\\external src\\temp.json"));
//         JSONObject jsonObject = (JSONObject)obj;
//         String name = (String)jsonObject.get("Name");
//         String course = (String)jsonObject.get("Course");
//         JSONArray subjects = (JSONArray)jsonObject.get("Subjects");
//         System.out.println("Name: " + name);
//         System.out.println("Course: " + course);
//         System.out.println("Subjects:");
//         Iterator iterator = subjects.iterator();
//         while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//         }
    	  Object obj = parser.parse(new FileReader("C:\\Users\\rupesh\\Desktop\\Daily task\\Java project\\external src\\temp.json"));
    	  JSONArray jsonObject =  (JSONArray)obj;
    	  System.out.println(jsonObject);
      } catch(Exception e) {
//         e.printStackTrace();
    	  System.out.println("Error occured while handling json file."+e);
      }
   }
}