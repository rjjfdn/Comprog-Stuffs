import java.util.*;
import java.io.*;
import java.sql.*;

public class Rows {
        
    public static void main(String[] args) throws Exception {
    	PrintWriter printer = new PrintWriter(new FileWriter("inserts.txt"));
    	Connection connection = null;
    	ResultSet resultSet = null;
    	Statement statement = null;
    	
    	try {
    		Class.forName("org.firebirdsql.jdbc.FBDriver");
    		connection = DriverManager.getConnection(
    			"jdbc:firebirdsql://localhost:3050/C:/Users/ReinaldKim/Documents/fleetdata/FLEETDATA.FDB", 
    			"sysdba", "masterkey");
    		statement = connection.createStatement();
    		resultSet = statement.executeQuery("SELECT rdb$relation_name " +
 												"FROM rdb$relations " +
 												"WHERE rdb$view_blr IS NULL " + 
 												"AND (rdb$system_flag IS NULL OR rdb$system_flag = 0) " +
 												"ORDER BY rdb$relation_name;");
    		Vector<String> tables = new Vector<String>();
    		while(resultSet.next()) {
    			tables.addElement(resultSet.getString("rdb$relation_name"));
    		}
    		for(String str : tables) {
    			statement = connection.createStatement();
    			resultSet = statement.executeQuery("SELECT * FROM " + str.trim() + ";");
    			while(resultSet.next()) {
    				printer.print("INSERT INTO " + str.trim() + " VALUES(");
    				try {
    					printer.print("'" + resultSet.getString(1) + "'");
    					for(int idx=2;; idx++) {
    						if(resultSet.getString(idx) == null)
    							printer.print(", NULL");
    						else
    							printer.print(", '" + resultSet.getString(idx) + "'");
    					}
    				}
    				catch(Exception e) {
    					printer.println(");");
    					continue;
    				}
    			}
    		}
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	finally {
    		resultSet.close();
    		statement.close();
    		connection.close();
    	}
    	printer.close();
    }
}