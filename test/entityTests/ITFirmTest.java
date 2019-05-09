package entityTests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entity.ITFirm;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**Tests ITFirm class.
 *
 * @author filip
 */
public class ITFirmTest {
    
    public ITFirmTest() {
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
    
        ITFirm itf1 = new ITFirm(1011, "MegaSoft", "USA", null, "megasoft@gmail.com", "megasoft.com", "2017, 2018", "1532235", 
                "840-000000274357-27", "Java, C#, C++", -1500);
        
        assertNotNull("Object is NULL!", itf1);
        assertNotNull("Object ID is NULL!", itf1.getId());
        assertTrue("Object ID can't be negative!", (itf1.getId() > 0));
        assertTrue("Object SIZE can't be negative!", (itf1.getSize() > 0));
    }
}
