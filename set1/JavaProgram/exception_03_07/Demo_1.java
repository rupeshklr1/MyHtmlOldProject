package exception_03_07;

import java.io.FileReader;
import java.io.IOException;

public class Demo_1 {

	public static void main(String[] args) {
		// IO exception that file not found error using IOException
		try {
			FileReader fileReader = new FileReader("Test.txt");
		    System.out.println(fileReader.read());
		    fileReader.close();
		} catch (IOException e) {
			System.out.println(e);
		}
		//Arithmetic exception that occures when Arithmetic calculation errors can be handled by this 
		try {
			int x1=8/0;//this make division can't be done by zero 
		} catch (ArithmeticException e) {
			System.out.println(e);			
		}
		//NumberFormat exception that occures when string try to convert into integer are any number value 
		try {
			int x1=Integer.valueOf("hk");//this string can't be convert into number 
		} catch (NumberFormatException e) {
			System.out.println(e);			
		}
		//IndexOutOfBound is for array and also for string
		try {
			//h-0,e-1,L-2,L-3,o-4
			String n1="hello";
			System.out.println(n1.charAt(5));
		} catch (StringIndexOutOfBoundsException e) {
			//catch (IndexOutOfBoundsException e) {
			System.out.println(e);			
		}
		try {
			int[] arr=new int[5];
			// arr [4]=8 will won't show any error 
			arr[5]=8;
		} catch (ArrayIndexOutOfBoundsException e) {
			//catch (IndexOutOfBoundsException e) {
			System.out.println(e);			
		}
		finally {
			System.out.print("\n\nThis is finally block will exectued always either "
					+ "/ nir the catch block is executed are not");
			
		}
	}

}
