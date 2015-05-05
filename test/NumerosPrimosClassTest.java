/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
 * @author juancho
 */
public class NumerosPrimosClassTest {
    
    private static BigInteger primo;
    
    public NumerosPrimosClassTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        primo = NumerosPrimos.aleatorio(9).multiply
               (NumerosPrimos.aleatorio(9));
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
     * Test para numeros primos aleatorios.
     */
    @Ignore
    @Test
    public void testAleatorio() {
        System.out.println("Test - aleatorio");
        BigInteger result;
        boolean resultado = false;
        for (int digitos = -3; digitos < 9; digitos++) {
            System.out.println("Prueva con " + digitos +" Digitos");
            try{
                result = NumerosPrimos.aleatorio(digitos);
            }catch(final Exception e){
                System.err.println(e.getMessage());
                continue;
            }
            if(!result.isProbablePrime(13)) {
                resultado = false;
                break;
            } else
                resultado = true;
        }
        boolean expResult = true;

        assertEquals(expResult, resultado);
    }

    /**
     * Test of esPrimoFuerzaBruta method, of class NumerosPrimos.
     */
    @Ignore
    @Test(timeout = 60000)
    public void testEsPrimoFuerzaBruta() {
        System.out.println("Test - esPrimoFuerzaBruta");
        System.out.println(primo);
        boolean expResult = primo.isProbablePrime(13);
        boolean result = NumerosPrimos.esPrimoFuerzaBruta(primo);
        System.out.println(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of esPrimoRaiz method, of class NumerosPrimos.
     */
    @Ignore
    @Test(timeout = 60000)
    public void testEsPrimoRaiz() {
        System.out.println("Test - esPrimoRaiz");
        System.out.println(primo);
        boolean expResult = primo.isProbablePrime(13);
        
        boolean result = NumerosPrimos.esPrimoRaiz(primo);
        System.out.println(result);
        assertEquals(expResult, result);
    }
    @Ignore
    @Test
    public void testEsPrimoMillerRabin() {
        System.out.println("Test - esPrimoMillerRabin");
        System.out.println(primo);
        boolean expResult = primo.isProbablePrime(13);
        boolean result = NumerosPrimos.esPrimoMillerRabin(primo, 12);
        System.out.println(result);
        assertEquals(expResult, result);
    }
    
    @Test( timeout = 30000 )
    public void testPrimoDefinidoMillerRabin() {
        System.out.println("Test - PrimoDefinidoMillerRabin");
        BigInteger numero = new BigInteger("1999");
        System.out.println(numero);
        boolean expResult = numero.isProbablePrime(13);
        boolean result = NumerosPrimos.esPrimoMillerRabin(numero, 12);
        System.out.println(result);
        assertEquals(expResult, result);
    }
    
}
