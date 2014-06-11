import java.util.*;
import java.io.*;
import java.sql.*;

public class Main {
        
    public static void main(String[] args) throws Exception {
    	PrintWriter printer = new PrintWriter(new FileWriter("test.txt"));
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
    			resultSet = statement.executeQuery(
 "SELECT " +
 "  RF.RDB$FIELD_NAME FIELD_NAME, " +
 "  CASE F.RDB$FIELD_TYPE " +
 "    WHEN 7 THEN " +
 "      CASE F.RDB$FIELD_SUB_TYPE " +
 "        WHEN 0 THEN 'TINYINT(1)' " +
 "        WHEN 1 THEN 'NUMERIC(' || F.RDB$FIELD_PRECISION || ', ' || (-F.RDB$FIELD_SCALE) || ')' " +
 "        WHEN 2 THEN 'DECIMAL' " +
 "      END " +
 "    WHEN 8 THEN " +
 "      CASE F.RDB$FIELD_SUB_TYPE " +
 "        WHEN 0 THEN 'INT' " +
 "        WHEN 1 THEN 'NUMERIC('  || F.RDB$FIELD_PRECISION || ', ' || (-F.RDB$FIELD_SCALE) || ')' " +
 "        WHEN 2 THEN 'DECIMAL' " +
 "      END " +
 "    WHEN 9 THEN 'QUAD' " +
 "    WHEN 10 THEN 'FLOAT' " +
 "    WHEN 12 THEN 'DATE' " +
 "    WHEN 13 THEN 'TIME' " +
 "    WHEN 14 THEN 'CHAR(' || (TRUNC(F.RDB$FIELD_LENGTH / CH.RDB$BYTES_PER_CHARACTER)) || ') ' " +
 "    WHEN 16 THEN " +
 "      CASE F.RDB$FIELD_SUB_TYPE " +
 "        WHEN 0 THEN 'BIGINT' " +
 "        WHEN 1 THEN 'NUMERIC(' || F.RDB$FIELD_PRECISION || ', ' || (-F.RDB$FIELD_SCALE) || ')' " +
 "        WHEN 2 THEN 'DECIMAL' " +
 "      END " +
 "    WHEN 27 THEN 'DOUBLE' " +
 "    WHEN 35 THEN 'DATETIME(6)' " +
 "    WHEN 37 THEN 'VARCHAR(' || (TRUNC(F.RDB$FIELD_LENGTH / CH.RDB$BYTES_PER_CHARACTER)) || ')' " +
 "    WHEN 40 THEN 'CSTRING' || (TRUNC(F.RDB$FIELD_LENGTH / CH.RDB$BYTES_PER_CHARACTER)) || ')' " +
 "    WHEN 45 THEN 'BLOB_ID' " +
 "    WHEN 261 THEN 'TEXT' " +
 "    ELSE 'RDB$FIELD_TYPE: ' || F.RDB$FIELD_TYPE || '?' " +
 "  END FIELD_TYPE, " +
 "  F.RDB$DEFAULT_VALUE DEFAULT_VALUE, " +
 "  IIF(COALESCE(RF.RDB$NULL_FLAG, 0) = 0, NULL, 'NOT NULL') FIELD_NULL, " +
 "  RF.RDB$RELATION_NAME RELATION_NAME " +
 "FROM RDB$RELATION_FIELDS RF " +
 "JOIN RDB$FIELDS F ON (F.RDB$FIELD_NAME = RF.RDB$FIELD_SOURCE) " +
 "LEFT OUTER JOIN RDB$CHARACTER_SETS CH ON (CH.RDB$CHARACTER_SET_ID = F.RDB$CHARACTER_SET_ID) " +
 "LEFT OUTER JOIN RDB$COLLATIONS DCO ON ((DCO.RDB$COLLATION_ID = F.RDB$COLLATION_ID) AND (DCO.RDB$CHARACTER_SET_ID = F.RDB$CHARACTER_SET_ID)) " +
 "WHERE (RF.RDB$RELATION_NAME = '" + str + "') AND (COALESCE(RF.RDB$SYSTEM_FLAG, 0) = 0) " +
 "ORDER BY RF.RDB$FIELD_POSITION;");
 				Vector<String> fields = new Vector<String>();
 				Vector<String> types = new Vector<String>();
 				Vector<String> defs = new Vector<String>();
 				Vector<Integer> nulls = new Vector<Integer>();
 				String pkey = "";
 				while(resultSet.next()) {
 					String one = resultSet.getString(1).trim();
 					String two = resultSet.getString(2).trim();
 					fields.addElement(one);
 					types.addElement(two);
 					String three = resultSet.getString(3);
 					if(three == null)
 						defs.addElement("");
 					else
 						defs.addElement("0");
 					String four = resultSet.getString(4);
 					if(four != null)
 						nulls.addElement(fields.size()-1);
 				}
    			statement = connection.createStatement();
    			resultSet = statement.executeQuery(
 "SELECT ris.rdb$field_name FROM rdb$relation_constraints rc " +
 "JOIN rdb$index_segments ris ON ris.rdb$index_name = rc.rdb$index_name " +
 "WHERE rc.rdb$relation_name = '" + str + "'  " +
 "AND rc.rdb$constraint_type = 'PRIMARY KEY'");
 				while(resultSet.next())
 					pkey = pkey+","+resultSet.getString(1).trim();
 				pkey = pkey.substring(1);
 				printer.println("CREATE TABLE " + str);
 				printer.println("(");
 				for(int i=0; i<fields.size(); i++) {
 					printer.print(fields.elementAt(i) + " " + types.elementAt(i));
 					if(!defs.elementAt(i).equals(""))
 						printer.print(" DEFAULT " + defs.elementAt(i));
 					if(Collections.binarySearch(nulls, i) >= 0)
 						printer.print(" NOT NULL");
	 				printer.println(",");
 				}
 				printer.println("PRIMARY KEY (" + pkey.trim() + ")");
 				printer.println(");");
 				printer.println("");
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

/**
 -- Show all Tables
 SELECT rdb$relation_name
 FROM rdb$relations
 WHERE rdb$view_blr IS NULL 
 AND (rdb$system_flag IS NULL OR rdb$system_flag = 0);
 */

/**
 -- Getting the Primary Key --
 SELECT ris.rdb$field_name FROM rdb$relation_constraints rc
 JOIN rdb$index_segments ris ON ris.rdb$index_name = rc.rdb$index_name
 WHERE rc.rdb$relation_name = 'WKINVH' 
 AND rc.rdb$constraint_type = 'PRIMARY KEY'
 */

/**
 -- Getting Table Data --
 SELECT
   RF.RDB$FIELD_NAME FIELD_NAME,
   CASE F.RDB$FIELD_TYPE
     WHEN 7 THEN
       CASE F.RDB$FIELD_SUB_TYPE
         WHEN 0 THEN 'TINYINT(1)'
         WHEN 1 THEN 'NUMERIC(' || F.RDB$FIELD_PRECISION || ', ' || (-F.RDB$FIELD_SCALE) || ')'
         WHEN 2 THEN 'DECIMAL'
       END
     WHEN 8 THEN
       CASE F.RDB$FIELD_SUB_TYPE
         WHEN 0 THEN 'INT'
         WHEN 1 THEN 'NUMERIC('  || F.RDB$FIELD_PRECISION || ', ' || (-F.RDB$FIELD_SCALE) || ')'
         WHEN 2 THEN 'DECIMAL'
       END
     WHEN 9 THEN 'QUAD'
     WHEN 10 THEN 'FLOAT'
     WHEN 12 THEN 'DATE'
     WHEN 13 THEN 'TIME'
     WHEN 14 THEN 'CHAR(' || (TRUNC(F.RDB$FIELD_LENGTH / CH.RDB$BYTES_PER_CHARACTER)) || ') '
     WHEN 16 THEN
       CASE F.RDB$FIELD_SUB_TYPE
         WHEN 0 THEN 'BIGINT'
         WHEN 1 THEN 'NUMERIC(' || F.RDB$FIELD_PRECISION || ', ' || (-F.RDB$FIELD_SCALE) || ')'
         WHEN 2 THEN 'DECIMAL'
       END
     WHEN 27 THEN 'DOUBLE'
     WHEN 35 THEN 'DATETIME'
     WHEN 37 THEN 'VARCHAR(' || (TRUNC(F.RDB$FIELD_LENGTH / CH.RDB$BYTES_PER_CHARACTER)) || ')'
     WHEN 40 THEN 'CSTRING' || (TRUNC(F.RDB$FIELD_LENGTH / CH.RDB$BYTES_PER_CHARACTER)) || ')'
     WHEN 45 THEN 'BLOB_ID'
     WHEN 261 THEN 'TEXT'
     ELSE 'RDB$FIELD_TYPE: ' || F.RDB$FIELD_TYPE || '?'
   END FIELD_TYPE,
   IIF(COALESCE(RF.RDB$NULL_FLAG, 0) = 0, NULL, 'NOT NULL') FIELD_NULL,
   RF.RDB$RELATION_NAME RELATION_NAME
 FROM RDB$RELATION_FIELDS RF
 JOIN RDB$FIELDS F ON (F.RDB$FIELD_NAME = RF.RDB$FIELD_SOURCE)
 LEFT OUTER JOIN RDB$CHARACTER_SETS CH ON (CH.RDB$CHARACTER_SET_ID = F.RDB$CHARACTER_SET_ID)
 LEFT OUTER JOIN RDB$COLLATIONS DCO ON ((DCO.RDB$COLLATION_ID = F.RDB$COLLATION_ID) AND (DCO.RDB$CHARACTER_SET_ID = F.RDB$CHARACTER_SET_ID))
 WHERE (RF.RDB$RELATION_NAME = 'WKINVH') AND (COALESCE(RF.RDB$SYSTEM_FLAG, 0) = 0)
 ORDER BY RF.RDB$FIELD_POSITION;
 */