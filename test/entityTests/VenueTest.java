package entityTests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entity.Venue;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**Tests Venue class.
 *
 * @author filip
 */
public class VenueTest {
    
    public VenueTest() {
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
    
        Venue ven1 = new Venue(1040, "Madlenianum", "Zemun, Belgrade", "011/1353-252", "madlenianum@gmail.com", "madlenianum.rs",
                "2018", "10502030", "840-000000235234-25", 3, 450);
        
        assertNotNull("Object is NULL!", ven1);
        assertNotNull("Object ID is NULL!", ven1.getId());
        assertTrue("Object ID can't be negative!", (ven1.getId() > 0));
        assertTrue("Object NUMBER OF ROOMS can't be negative!", (ven1.getNumberOfRooms() > 0));
        assertTrue("Object TOTAL CAPACITY can't be negative!", (ven1.getTotalCapacity() > 0));
    }
    
    
}
