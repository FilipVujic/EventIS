/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;




import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**Initializes database connection.
 *
 * @author filip
 */
public abstract class DBInit {
    
    public static Connection conn = null;
    public static String lastConnected = null;
    public static String accessLog = "connectionlog";
    
    /**Initializes DB connection.
     * 
     * @param username Database username.
     * @param password Database password.
     * @throws SQLException Throws SQLException.
     * @throws IOException Throws IOException.
     */
    public static void connectToDatabase(String username, String password) throws SQLException, IOException {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String driverName = "com.mysql.cj.jdbc.Driver";
                    Class.forName(driverName);
                    String serverName = "eventis";
                    String serverPort = "3306";
                    String url = "jdbc:mysql://localhost:" + serverPort + "/" + serverName;
//            String username = "root";
//            String password = "filip665";

                    Thread.sleep(15000);

                    conn = DriverManager.getConnection(url, username, password);
                    System.out.println("Successfully connected to the database");
                } catch (ClassNotFoundException ex) {
                    System.out.println("Could not find the database driver" + ex.getMessage());
                } catch (SQLException ex) {
                    System.out.println("Could not connect to the database" + ex.getMessage());
                } catch (InterruptedException ex) {
                    //Logger.getLogger(DBInit.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println(ex.toString());
                }
                
            }
        });
        
        
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                
                String currentTime = null;
                try {
                    currentTime = CurrentDateAndTime.getCurrentTime();
                } catch (IOException ex) {
                    //Logger.getLogger(DBInit.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Could not get current time!");
                    System.out.println(ex.toString());
                }
                String currentDate = null;
                try {
                    currentDate = CurrentDateAndTime.getCurrentDate();
                } catch (IOException ex) {
                    //Logger.getLogger(DBInit.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Could not get current time!");
                    System.out.println(ex.toString());
                }
                
                System.out.println(currentDate + " " + currentTime);
                
                try {
                    thread1.join();
                } catch (InterruptedException ex) {
                    //Logger.getLogger(DBInit.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println(ex.toString());
                }
                
                try {
                    DBOperations.logTimeAndDateAccessed(username, currentTime, currentDate);
                } catch (SQLException ex) {
                    //Logger.getLogger(DBInit.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println(ex.toString());
                }
            }
        });
        
        thread1.start();
        thread2.start();

    }
}
