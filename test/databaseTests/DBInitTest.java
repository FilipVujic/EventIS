package databaseTests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**Tests DBInit class.
 *
 * @author filip
 */
public class DBInitTest {
    
    public DBInitTest() {
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
    
    /**Tests establishing database connection.
     * 
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    @Test
    public void test() throws ClassNotFoundException, SQLException {
    
            Connection conn = null;
            Class.forName("com.mysql.cj.jdbc.Driver");
            String serverName = "eventis";
            String serverPort = "3306";
            String url = "jdbc:mysql://localhost:" + serverPort + "/" + serverName;
            String username = "root";
            String password = "filip665";
            
            conn = DriverManager.getConnection(url, username, password);
            
            assertFalse("Connection Failed!", conn.isClosed());
            assertTrue("Connection Failed!", conn.isValid(5));
            
    }
}
