package entityTests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entity.Media;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**Tests Media class.
 *
 * @author filip
 */
public class MediaTest {
    
    public MediaTest() {
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
    
    /**Tests creating a new object.
     * 
     */
    @Test
    public void test() {
    
        Media med1 = new Media(2022, "Netokracija", "Belgrade", null, "netokracija@gmail.com", "netokracija.rs", "2017, 2018",
                false);
        
        assertNotNull("Object is NULL!", med1);
        assertNotNull("Object ID is NULL!", med1.getId());
        assertTrue("Object ID can't be negative!", (med1.getId() > 0));
    }
}
