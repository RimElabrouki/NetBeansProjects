/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClienteParking;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



/**
 *
 * @author Rim
 */
public class ClienteParkingTest {

    ClienteParking clienteValidoVIP;
    ClienteParking clienteValidoNoVIP;
    ClienteParking clienteValidoMenorEdad;

    public ClienteParkingTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        try {
            clienteValidoVIP = new ClienteParking("Pedro Moya Sáez",1, "699711861", true);
            clienteValidoNoVIP = new ClienteParking("Pedro Moya Sáez",2, "699711861", false);
            clienteValidoMenorEdad = new ClienteParking("Pedro Moya Sáez",3, "699711861",true);
        } catch (Cliente_ParkingException e) {
        }
    }
         

    @After
    public void tearDown() {
    }

    /**
     * Test of getNombre method, of class ClienteParking.
     */
    public void testGetNombre001() {
        System.out.println("getNombre");
        String expResult = "Pedro Moya Sáez";
        String result = clienteValidoVIP.getNombre();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetNombre() {
        try{
        System.out.println("getNombre");
        ClienteParking instance = new ClienteParking("",1, "699711861", true);
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        }catch(Cliente_ParkingException ex){
            System.out.println("ClienteParking.ClienteParkingTest.testGetNombre()"+ex.getMessage());
        }
    }
 
    @Test
    public void testGetNombre003() {
        try {
            System.out.println("getNombre");
            ClienteParking instance = new ClienteParking("Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",1, "987654321",  true);
            String expResult = "Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
            String result = instance.getNombre();
            assertEquals(expResult, result);
        } catch (Cliente_ParkingException ex) {
            System.out.println("ClienteParkingException:" + ex.getMessage());
        }
    }
    /**
     * Test of getEdad method, of class ClienteParking.
     */
    @Test
    public void testGetEdad() {
     
    }

    /**
     * Test of getTelefono method, of class ClienteParking.
     */
    @Test
    public void testGetTelefono() {
        System.out.println("getTelefono");
        ClienteParking instance = new ClienteParking();
        String expResult = "";
        String result = instance.getTelefono();
        assertEquals(expResult, result);
   
    }

    /**
     * Test of isVip method, of class ClienteParking.
     */
    @Test
    public void testIsVip() {
        System.out.println("isVip");
        ClienteParking instance = new ClienteParking();
        boolean expResult = false;
        boolean result = instance.isVip();
        assertEquals(expResult, result);
   
    }

}
