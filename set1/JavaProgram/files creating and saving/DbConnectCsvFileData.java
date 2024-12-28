package io.files;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class DbConnectCsvFileData {
	Connection conn1=null;
	PreparedStatement psmt=null;
	ResultSet resultSet=null;
	static String conURlString="jdbc:sqlserver://192.168.3.125;database=SQLTraining",userName ="RupeshKrish",userPassword="ruRk!sql56",
	 tableName=" klr.csvFileData ", 	tableDataNameSet=" (empName,phone,empRole,empId,empExperiencesYear,empExperiencesInMonth,isDelected,lastModifiedDate) ",
			tableValuesSet="(?,?,?,?,?,?,?,?)";
	public DbConnectCsvFileData() {
		try {
			conn1 =DriverManager.getConnection(conURlString,userName,userPassword);
		}catch (Exception e) {System.out.print("not connected");}
	}
	public void getConnection() {
		try {
			conn1 =DriverManager.getConnection(conURlString,userName,userPassword);
		}catch (Exception e) {conn1=null;		}
	}
	public String AddDataSet(csvFileObj obj) {
		try {
			getConnection();
			if(conn1==null) {
				return "Failed to connect to DB-->";
			}
			//conn1 =DriverManager.getConnection(conURlString,userName,userPassword);
			psmt=conn1.prepareStatement("INSERT INTO "+tableName+tableDataNameSet+" values "+tableValuesSet);
			//psmt.setString(0, obj.id);	because its identity function automatically genrates the id
			psmt.setString(1, obj.empName);
			psmt.setString(2, obj.phone);
			psmt.setString(3, obj.empRole);
			psmt.setString(4, obj.empId);
			psmt.setString(5, String.valueOf( obj.empExperiencesYear));
			psmt.setString(6, String.valueOf( obj.empExperiencesInMonth));
			psmt.setString(7, String.valueOf( obj.isDelected) );
			String tempString =obj.lastModifiedDate;
			//System.out.println(tempString);
			if(tempString.equals("NULL") || tempString.equals("")) {				tempString=null;		}
			psmt.setString(8, null);
			psmt.executeUpdate();
		}catch (Exception e) {System.out.print("Not connected"+e);return "Failed to Insert-->";
		}finally {
			try {
				if(resultSet!=null) {resultSet.close();			}
				if(psmt!=null) {psmt.close();		}
				if(conn1!=null) { conn1.close();		}		
			} catch (Exception e2) {System.out.print("Failed to disconnect ");return "Failed to disconnect";}
		}
		return "Successfully inserted";
	}
}
