package log4jPracties;

import org.apache.log4j.Logger;


import java.io.*;  
import java.sql.SQLException;  
import java.util.*;  
  
public class Example{  
   static Logger errorLog = Logger.getLogger("errorLogger"); 
   static Logger debugLog  = Logger.getLogger("debugLogger"); 
   static Logger statusLog = Logger.getLogger("statusLogger");  
     
   public static void main(String[] args)throws IOException{ 
	   // errorLog.debug("Debug Message!E");  
//	   errorLog.info("Error Message!E");  
//	   
//   }
//}
	  // /*
	   Scanner objScanner=new Scanner(System.in);

	   statusLog.info("\nThe programe has been started!");
	   debugLog.info("at step-1 Scanner object is created "); 
	   
	   System.out.print("Enter your name : ");
	   String userName= objScanner.nextLine();
	   System.out.println("Welcome our page "+userName);
	   String chooseString="";
	   int count=1;
	   try {
		   do {
			   System.out.println(userName+" can do 1-addition, 2-subtraction, 3-multiplication, 4-division & 5-stop.");
			   System.out.print("Enter your choose ");
			   
			   debugLog.info("at step-2 picking user choose for "+Integer.toString(count++));   
			   chooseString=objScanner.nextLine();
			   if(chooseString.equals("1") || chooseString.equals("2") || chooseString.equals("3") || chooseString.equals("4")) {
				   System.out.println("Enter frist number : ");
				   String temp=objScanner.nextLine();
				   int x1=Integer.valueOf(temp);
				   System.out.println("Enter second number : ");
				   temp=objScanner.nextLine();
				   int x2=Integer.valueOf(temp);
				   int res=0;
				   switch (chooseString) {
					case "1": 
						res=x1+x2;
						System.out.println("The sum of given numbers is "+res);
						break;
					case "2": 
						res=sub(x1,x2);
						System.out.println("The difference between of given numbers is "+res);
						break;
					case "3": 
						res=x1*x2;
						System.out.println("The multiplication of given numbers is "+res);
						break;
					case "4": 
						res=Div(x1,x2);
						System.out.println("The division of given numbers is "+ res);
						break;
					default:
						System.out.println("Your choose is wrong try again.");
					}
				   debugLog.info("at step-2 "+Integer.toString(count++)+"the output of numbers "+x1+" "+x2+" is "+res);   
			   }
		   } while (!chooseString.equals(""));
		   
	   }catch (Exception e) {
		   System.out.println(e.getMessage());
		   errorLog.error(e);
	}
	   
	   statusLog.info("\nThe programe has finished successfully!");
	   
   }  
   public static int sub(int x1,int x2) {
	   if(x1==x2) {
		   return 0;
	   }
	   if(x1>x2) {
		   return x1-x2;
	   }
	   return x2-x1;	
   }
   private static int  Div(int x1,int x2) {
	if(x2<=0 || x1<0) {
		return 0;
	}
	return x1/x2;
   }
   
} 
// */ 