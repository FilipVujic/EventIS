package entityTests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entity.NaturalPerson;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**Tests NaturalPerson class.
 *
 * @author filip
 */
public class NaturalPersonTest {
    
    public NaturalPersonTest() {
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
    
        NaturalPerson np1 = new NaturalPerson(1010, "Jane", "Doe", "janedoe@gmail.com", null, "HR Assistant", "IBM");
        
        assertNotNull("Object is NULL!", np1);
        assertNotNull("Object ID is NULL!", np1.getId());

    }
}
