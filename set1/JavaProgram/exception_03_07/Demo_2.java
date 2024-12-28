package exception_03_07;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Demo_2 {
	public static void ioException() throws IOException{
		FileReader fileReader = new FileReader("Test.txt");
	    System.out.println(fileReader.read());
	    fileReader.close();
	}

	public static void ArtException() throws ArithmeticException{
		int x1=8/0;//this make division can't be done by zero 
	}
	public static void NumberForException() throws NumberFormatException{
		int x1=Integer.valueOf("hkk");
	}
	public static void StringIndexException() throws StringIndexOutOfBoundsException{
		String n1="hello";
		System.out.println(n1.charAt(5));
	}
	public static void ArrayIndexException() throws ArrayIndexOutOfBoundsException{
		int[] arr=new int[5];
		// arr [4]=8 will won't show any error 
		arr[5]=8;
	}
	
	///the below method are example for throw 
	public static void findFile() throws IOException {
	    throw new IOException("User [[-- File not found text --]] come here.");
	  }

	public static void main(String[] args) {
		System.out.println("Enter choose to get any one of the below exception using throws.");
		System.out.println("1)Io exception\t2)ArithmeticException \t3)NumberFormatException \n4) StringIndexOutOfBoundsException\t5) ArrayIndexOutOfBoundsException.");
		try {
			Scanner objScanner=new Scanner(System.in);
			int choose=objScanner.nextInt();
			switch (choose) {
			case 1:
				ioException();
//				break;
			case 2:
				ArtException();
//				break;
			case 3:
				NumberForException();
//				break;
			case 4:
				StringIndexException();
//				break;
			case 5:
				ArrayIndexException();
//				break;
			default:
				throw new IllegalArgumentException("Unexpected at default block:|n your choose is incorrect. ");
			}
		} catch (Exception e) {
			System.out.println(e+"\n\n\n");
		}
		///this is for throw example

		try {
		      findFile();
		      System.out.println("this block nevr exectued till findfile throws a exception.");
		    } catch (IOException e) {
		    	System.out.print("This is to handling the findFile() make an ioexecption\n");
		      System.out.println(e.getMessage());
		    }
	}

}
