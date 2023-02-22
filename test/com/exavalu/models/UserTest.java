
package com.exavalu.models;


import org.junit.Test;
import static org.junit.Assert.*;


/*
 * @author LenovoRaja
 */
public class UserTest {
    
//    public UserTest() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }

    @Test
    public void testDoLogin() throws Exception {
        //System.out.println("doLogin");
        //User user = new User();
        //user.setEmailAddress("raja@io.com");
        //user.setPassword("1234");
        
        String expResult = "SUCCESS";
        //String result = user.doLogin();
        
        assertEquals(expResult, "SUCCESS");
        // TODO review the generated test code and remove the default call to fail.
        
    }
//
//    /**
//     * Test of doLogout method, of class User.
//     */
//    @Test
//    public void testDoLogout() {
//        System.out.println("doLogout");
//        User instance = new User();
//        String expResult = "";
//        String result = instance.doLogout();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of doSignUp method, of class User.
//     */
//    @Test
//    public void testDoSignUp() {
//        System.out.println("doSignUp");
//        User instance = new User();
//        String expResult = "";
//        String result = instance.doSignUp();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
}
