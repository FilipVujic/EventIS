/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseTests;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**Tests CurrentDateAndTimeTest class.
 *
 * @author filip
 */
public class CurrentDateAndTimeTest {
    
    public CurrentDateAndTimeTest() {
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
    
    /**Tests getting current time.
     * 
     * @throws IOException 
     */
    @Test
    public void testGetTime() throws IOException {

        String url = "https://www.timeanddate.com/worldclock/serbia/belgrade";
        Document doc = (Document) Jsoup.connect(url).get();
        String currentTime = doc.getElementById("ct").text();
        
        assertNotNull("Could not get current time!", currentTime);
    }
    
    /**Tests getting current date.
     * 
     * @throws IOException 
     */
    public void testGetDate() throws IOException {

        String url = "https://www.timeanddate.com/worldclock/serbia/belgrade";
        Document doc = (Document) Jsoup.connect(url).get();
        String currentDate = doc.getElementById("ctdat").text();
        
        assertNotNull("Could not get current time!", currentDate);
    }
}
