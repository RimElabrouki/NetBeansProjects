/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class RecetaExceptionTest {
    
    public RecetaExceptionTest() {
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
     * Test of validarNombreReceta method, of class RecetaException.
     */
    @Test
    public void testValidarNombreReceta() {
        System.out.println("validarNombreReceta");
        String nombrePizza = "";
        boolean expResult = false;
        boolean result = RecetaException.validarNombreReceta(nombrePizza);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validarvalorEnergitico method, of class RecetaException.
     */
    @Test
    public void testValidarvalorEnergitico() {
        System.out.println("validarvalorEnergitico");
        int valorEnergitico = 0;
        boolean expResult = false;
        boolean result = RecetaException.validarvalorEnergitico(valorEnergitico);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validaraltura method, of class RecetaException.
     */
    @Test
    public void testValidaraltura() {
        System.out.println("validaraltura");
        int altura = 0;
        boolean expResult = false;
        boolean result = RecetaException.validaraltura(altura);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
