package com.rupesh;
import java.util.Scanner;
public class Task2 {
	public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int choose=0;
        while(true) {
            double num1=0,num2=0;
            try{
                System.out.print("Which opertion you want to do.\n1)Addtion \t2)Subtraction \t3)multiplication");
                System.out.println("\n4)division \t5)modulus \t6)square root \n7)cube root \t8)Stop or empty");
                String data = scanner.nextLine();
                if(data.equals("8") || data.isEmpty()) {
                    System.out.println("Thanks for using me!");
                    break;                                   
                }
                choose=Integer.valueOf(data.trim());
                if(choose<0 || choose>7) {
                    System.out.println("you did't choose correct option");
                    System.out.println("choose any one option among them");   
                }
                System.out.println("Enter 1st value : ");
                num1=Double.valueOf( scanner.nextLine().trim());
                if(choose<6){                
                    System.out.println("Enter 2nd  value : ");
                    num2=Double.valueOf( scanner.nextLine().trim());
                }
                switch(choose) {
                    case 1:System.out.println("The sum of given two number is"+(num1+num2));                
                        break;
                    case 2: System.out.println("The subtrackion of given two number is"+(num1-num2));
                        break;
                    case 3:System.out.println("The multiplecation of given two number is"+ (num1*num2) );
                        break;
                    case 4:
                    	if(num2<=0 || num1<0){
                            System.out.println("This operation can't be performed.\n"
                            		+ "Numarator is +ve and Denominator should be greater than zero.");
                            continue;
                        }
                        System.out.println("The division of given two number is"+(num1/num2));
                        break;
                    case 5:
                    	if(num2<=0 || num1<0){
                    		System.out.println("This operation can't be performed."
                    				+ "Numarator is +ve and Denominator should be greater than zero.");
                    		continue;
                    	}
                        System.out.println("The modulus of given two number is"+(num1%num2));
                        break;
                    case 6: squreroot(num1);
                        	break;
                    case 7:cuberoot(num1);
                        break;                          
                }
            } catch (Exception e) {
                System.out.println("\nFor entering string for input/calculation is not designed in this application!\n\n");
            }
        }
	}
	private static void squreroot(double value1) {
		if (value1 >= 0) {
            double result = Math.sqrt(value1);
            System.out.println("Result: " + result);
        } else {
            System.out.println("calculation of squre root is for only +ve numbers only!");
        }
	}
	private static void cuberoot(double value1) {
		if (value1 >= 0) {
            double result = Math.cbrt(value1);
    		System.out.println("The cude root of given number is: " + result);
        } else {
            System.out.println("calculation of cube root is for only +ve numbers only!");
        }
	}
}
