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
public class RecetaTest {
     Receta clienteValidoNombrePizza;
    
    public RecetaTest() {
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
     * Test of getNombrePizza method, of class Receta.
     */
    @Test
    public void testGetNombrePizza() {
        System.out.println("getNombrePizza");
        String expResult = "pizza";
        String result = clienteValidoNombrePizza.getNombrePizza();
        assertEquals(expResult, result);
     
    }

    /**
     * Test of getDiametro method, of class Receta.
     */
    @Test
    public void testGetDiametro() {
        System.out.println("getDiametro");
        double expResult = 0.00;
        double result = clienteValidoNombrePizza.getDiametro();
        assertEquals(expResult, result, 0.0);
      
    }

    /**
     * Test of getValorEnergitico method, of class Receta.
     */
    @Test
    public void testGetValorEnergitico() {
        System.out.println("getValorEnergitico");
        Receta instance = null;
        int expResult = 0;
        int result = clienteValidoNombrePizza.getValorEnergitico();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getAltura method, of class Receta.
     */
    @Test
    public void testGetAltura() {
        System.out.println("getAltura");
        int expResult = 5;
        int result = clienteValidoNombrePizza.getAltura();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getTemperatura method, of class Receta.
     */
    @Test
    public void testGetTemperatura() {
        System.out.println("getTemperatura");
        
        int expResult = 0;
        int result = clienteValidoNombrePizza.getTemperatura();
        assertEquals(expResult, result);

    }

    /**
     * Test of getTiempo method, of class Receta.
     */
    @Test
    public void testGetTiempo() {
        System.out.println("getTiempo");
        Receta instance = null;
        int expResult = 0;
        int result = clienteValidoNombrePizza.getTiempo();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getOtrosDatos method, of class Receta.
     */
    @Test
    public void testGetOtrosDatos() {
        System.out.println("getOtrosDatos");
        Receta instance = null;
        String expResult = "";
        String result = clienteValidoNombrePizza.getOtrosDatos();
        assertEquals(expResult, result);
    
    }
    
}
