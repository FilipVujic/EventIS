package entityTests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entity.Organisation;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**Tests Organisation class.
 *
 * @author filip
 */
public class OrganisationTest {
    
    public OrganisationTest() {
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
    
        Organisation org1 = new Organisation(1001, "SomeOrg", "Belgade", "/", "someorg@gmail.com", "someorg.rs", null);
        
        assertNotNull("Object is NULL!", org1);
        assertNotNull("Object ID is NULL!", org1.getId());
        assertTrue("Object ID can't be negative!", (org1.getId() > 0));
    }
}
