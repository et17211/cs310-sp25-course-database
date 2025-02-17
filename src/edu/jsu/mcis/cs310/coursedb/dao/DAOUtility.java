package edu.jsu.mcis.cs310.coursedb.dao;

import java.sql.*;
import com.github.cliftonlabs.json_simple.*;
import java.util.ArrayList;


public class DAOUtility {
    
    public static final int TERMID_FA24 = 1;
    
    public static String getResultSetAsJson(ResultSet rs) {
        
        JsonArray records = new JsonArray();
        
        try {
        
            if (rs != null) {

                // INSERT YOUR CODE HERE
                ResultSetMetaData mData = rs.getMetaData();
                int numbercolumn = mData.getColumnCount();

                while (rs.next()) {
                    JsonObject obj = new JsonObject();
                    for (int i = 1; i <= numbercolumn; i++) {
                        String columnName = mData.getColumnName(i);
                        Object object = rs.getObject(i);
                        String value = object.toString();
                        
                        obj.put(columnName, value);
                    }
                    records.add(obj);
                }
            

            }
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return Jsoner.serialize(records);
        
    }
    
}
