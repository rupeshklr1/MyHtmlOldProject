package io.files;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class task2Part2   {  
public static void main(String[] args){ 
		FileReader oldfile = null;  
		FileWriter updateFile = null;
		String oldFileP="C:\\Users\\rupesh\\Desktop\\Daily task\\Java project\\jdbcProject1\\io\\files\\files1.txt";
		String upDateFilePath="C:\\Users\\rupesh\\Desktop\\Daily task\\Java project\\jdbcProject1\\io\\files\\files2.txt";
		
		try   {  
			oldfile = new FileReader(oldFileP);
			updateFile = new FileWriter(upDateFilePath,true);
            int i;
            while ((i = oldfile.read()) != -1) {
            	updateFile.write((char)i);
            }
		}   
		catch (IOException e){  
			e.printStackTrace(); 
		}  finally {
			try {
				oldfile.close();
				updateFile.close();
				Files.deleteIfExists(Paths.get(oldFileP));
			} catch (IOException e) {e.printStackTrace();
			}
		} 
	}  
}  