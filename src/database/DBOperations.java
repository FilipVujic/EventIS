/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;


/**Provides methods for database operations.
 *
 * @author filip
 */
public abstract class DBOperations {
    
    /**Writes data to a specific table.
     * 
     * @param tableName Name of DB table that we are inserting into.
     * @param columns Columns of the table given as a String.
     * @param values List of values we are inserting into columns.
     * @throws SQLException Throws SQLException.
     */
    public static void writeToDatabase(String tableName, String columns, LinkedList values) throws SQLException{
        
//        String columnsExpanded = "";
//        
//            for (int i = 0; i < columns.size(); i++){
//            
//            columnsExpanded = columnsExpanded + columns.get(i).toString();
//            if (columns.get(i) != columns.getLast()) {
//                columnsExpanded = columnsExpanded + ", ";
//            } 
//        }

        String valuesExpanded = "";
  
        for (int i = 0; i < values.size(); i++){
            if (values.get(i) == null) {
                valuesExpanded = valuesExpanded + "null";
            }
            else if (values.get(i).getClass().getSimpleName().equalsIgnoreCase("Integer")) {
                valuesExpanded = valuesExpanded + values.get(i).toString();
            }
            else if (true) {
                valuesExpanded = valuesExpanded + "'" + values.get(i).toString() + "'";
            }
            
            if (values.get(i) != values.getLast()) {
                valuesExpanded = valuesExpanded + ", ";
            }          
        }
        
        String query = "INSERT INTO " + tableName + " (" + columns + ")" + "\n" +
                        "VALUES (" + valuesExpanded + ")";
  
        try {
            Statement st = DBInit.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            st.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        
    }
    
    /**Searches for a specific row using a unique value.
     * @deprecated
     * @param tableName Name of the table to look into.
     * @param column Column to compare the unique value to.
     * @param matchValue Value to search for in the column.
     * @return Returns values from a specific row as a String.
     * @throws SQLException Throws SQLException.
     */
    public static String searchByUniqueValue(String tableName, String column, String matchValue) throws SQLException {
    
        String query = "SELECT * FROM " + tableName + "\n" +
                        "WHERE " + column + "=" + matchValue;
  
        try {
            Statement st = DBInit.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery(query);

            rs = st.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            String resultString = "";
            int columnsNumber = rsmd.getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) {
                        resultString = resultString + "\n";
                    }
                    String columnValue = rs.getString(i);
                    resultString = resultString + rsmd.getColumnName(i) + ": " + columnValue + "\n";
                }
        }
        return resultString;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return null;
    }

    /**Searches for a specific row using unique values and returns its values as a list.
     * 
     * @param tableName Name of the table to look into.
     * @param uniqueColumn Name of the column that contains a unique value.
     * @param uniqueValue Unique value to match the row to.
     * @param columns List of columns our table has.
     * @return Returns a list of values from a row that matches our unique value.
     * @throws SQLException Throws SQLException.
     */
    public static LinkedList returnValuesOfColumns(String tableName, String uniqueColumn, String uniqueValue, String[] columns) 
            throws SQLException {
                
//        String testQuery = "SELECT " + uniqueColumn + " FROM " + tableName + "\n" +
//                            "WHERE " + uniqueColumn + "='" + uniqueValue + "'";
//        
//        rs = st.executeQuery(testQuery);
//        
//        if (rs.getString(1) != null) {   
//        }
        
        LinkedList values = new LinkedList();
        String query = "SELECT * FROM " + tableName + "\n" +
                        "WHERE " + uniqueColumn + "='" + uniqueValue + "'";
        try {
            Statement st = DBInit.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                for (String column : columns) {
                    values.add(rs.getString(column));
                }
            }

            return values;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return null;
    }
    
    /**Logs database access.
     * 
     * @param username Username that is accessing the database.
     * @param time Time of establishing connection.
     * @param date Date of establishing connection.
     * @throws SQLException Throws SQLException.
     */
    public static void logTimeAndDateAccessed(String username, String time, String date) throws SQLException {
    
        String query = "INSERT INTO " + DBInit.accessLog + " (USER, TIME_ACCESSED, DATE_ACCESSED)" + "\n" +
                        "VALUES (" + "'"+username+"'" + ", " + "'"+time+"'" + ", " + "'"+date+"'" + ")";
        
        try {
            Statement st = DBInit.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            st.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        
    }
}
