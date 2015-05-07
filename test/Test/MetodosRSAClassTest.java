package Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import data.MetodosRSA;
import data.NumerosPrimos;
import java.math.BigInteger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author JHON JAIRO
 */
public class MetodosRSAClassTest {
    
    public MetodosRSAClassTest() {
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
    
    @Test(timeout = 60000)
    public void testPhiEulerArreglo() {
        System.out.println("Test - PhiEulerArreglo");
        BigInteger p = NumerosPrimos.aleatorio(2),
                   q = NumerosPrimos.aleatorio(2),
                   expResult = MetodosRSA.phiEulerPQ(p, q),
                   numero = p.multiply(q);
        
        System.out.println(numero);
        BigInteger result = MetodosRSA.phiEulerArreglo(numero);
        System.out.println(result);
        assertEquals(expResult, result);
    }
}
