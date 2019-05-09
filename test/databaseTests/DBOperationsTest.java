package databaseTests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import database.DBInit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**Tests DBOperations class.
 *
 * @author filip
 */
public class DBOperationsTest {
    
    public DBOperationsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    /**Tests making an sql query and writing to database.
     * 
     * @throws SQLException 
     */
    @Test
    public void testWriteToDatabase() throws SQLException {
    
        String tableName = "naturalperson"; 
        String columns = "ID, NAME, SURNAME, EMAIL, PHONE_NUMBER, POSITION, WORKPLACE";
        LinkedList values = new LinkedList();
        values.add(1020);
        values.add("John");
        values.add("Smith");
        values.add("johnsmith@gmail.com");
        values.add(null);
        values.add("Sales Manager");
        values.add("SAP");
        
        String checkValues = "1020, 'John', 'Smith', 'johnsmith@gmail.com', null, 'Sales Manager', 'SAP'";
        String checkQuery = "INSERT INTO naturalperson (ID, NAME, SURNAME, EMAIL, PHONE_NUMBER, POSITION, WORKPLACE)\n" +
                            "VALUES (1020, 'John', 'Smith', 'johnsmith@gmail.com', null, 'Sales Manager', 'SAP')";
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
        
        assertEquals("Expanded values do not match check values!", valuesExpanded, checkValues);
        assertEquals("Built query does not match check query!", query, checkQuery);
    }
    
    /**Test making an sql query and returning column values.
     * 
     */
    @Test
    public void testReturnValuesOfColumns() {

        String tableName = "organisation";
        String uniqueColumn = "ID";
        String uniqueValue = "1001";
        String columnsAsString = "TYPE, ID, NAME, ADDRESS, PHONE_NUMBER, EMAIL, WEBSITE, YEARS_PARTNERED";
        String[] columns = columnsAsString.split(", ");
        String columnsAsStringSplit = "";
        String columnsAsStringSplitCheck = "TYPEIDNAMEADDRESSPHONE_NUMBEREMAILWEBSITEYEARS_PARTNERED";
        
        String checkQuery = "SELECT * FROM organisation\n" +
                            "WHERE ID='1001'";
        String checkColumns = "";
        
        LinkedList values = new LinkedList();
        String query = "SELECT * FROM " + tableName + "\n"
                + "WHERE " + uniqueColumn + "='" + uniqueValue + "'";

        for (int i = 0; i < columns.length; i++) {
            
            columnsAsStringSplit = columnsAsStringSplit + columns[i].toString();
        }

        assertEquals("Built query does not match check query!", query, checkQuery);
        assertEquals("Built columns list does not match check value!", columnsAsStringSplit, columnsAsStringSplitCheck);
    }
    
    /**Test making an sql query and logging access to database.
     * 
     */
    @Test
    public void testLogTimeAndDateAccessed() {
    
        String username = "root"; 
        String time = "10:45";
        String date = "utorak, 9. april";
        
        String checkQuery = "INSERT INTO connectionlog (USER, TIME_ACCESSED, DATE_ACCESSED)\n" +
                            "VALUES ('root', '10:45', 'utorak, 9. april')";
        
        String query = "INSERT INTO " + DBInit.accessLog + " (USER, TIME_ACCESSED, DATE_ACCESSED)" + "\n" +
                        "VALUES (" + "'"+username+"'" + ", " + "'"+time+"'" + ", " + "'"+date+"'" + ")";
        
        assertEquals("Built query does not match check query!", query, checkQuery);
    }
    
    /**Tests multi threaded operations.
     * 
     */
    @Test
    public void testMultiThreading() {
    
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread1 working");
            }
        });
        
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread2 working");
            }
        });
        
        thread1.start();
        thread2.start();
        
        while (thread1.isAlive() && thread2.isAlive()) {            
            System.out.print("izvrsava ");
        }
            System.out.println("");
            System.out.println("threads finished");
            
        assertTrue(true);
    }
}
