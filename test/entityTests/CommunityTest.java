package entityTests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entity.Community;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**Tests Community class.
 *
 * @author filip
 */
public class CommunityTest {
    
    public CommunityTest() {
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
    
        Community com1 = new Community(2014, "PHP Srbija", "Belgrade", null, "phpsrbija@gmail.com", "phpsrbija.rs", 
                "2016, 2017, 2018", "PHP");
        
        assertNotNull("Object is NULL!", com1);
        assertNotNull("Object ID is NULL!", com1.getId());
        assertTrue("Object ID can't be negative!", (com1.getId() > 0));
    }
}
