/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClienteParking;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rim
 */
public class Cliente_ParkingExceptionTest {
    
    public Cliente_ParkingExceptionTest() {
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

    /**
     * Test of validarClienteParking method, of class Cliente_ParkingException.
     */
    @Test
    public void testValidarClienteParking() {
        System.out.println("validarClienteParking");
        ClienteParking c = null;
        boolean expResult = false;
        boolean result = Cliente_ParkingException.validarClienteParking(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validarNombreClienteParking method, of class Cliente_ParkingException.
     */
    @Test
    public void testValidarNombreClienteParking() {
        System.out.println("validarNombreClienteParking");
        String nombre = "";
        boolean expResult = false;
        boolean result = Cliente_ParkingException.validarNombreClienteParking(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validarTelefonoClienteParking method, of class Cliente_ParkingException.
     */
    @Test
    public void testValidarTelefonoClienteParking() {
        System.out.println("validarTelefonoClienteParking");
        String telefono = "";
        boolean expResult = false;
        boolean result = Cliente_ParkingException.validarTelefonoClienteParking(telefono);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validarEdadClienteParking method, of class Cliente_ParkingException.
     */
    @Test
    public void testValidarEdadClienteParking() {
        System.out.println("validarEdadClienteParking");
        int edad = 0;
        boolean expResult = false;
        boolean result = Cliente_ParkingException.validarEdadClienteParking(edad);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
