package business;

import java.math.BigInteger;
import data.MetodosRSA;
import data.NumerosPrimos;

/**
 *
 * @author bhd
 */

public class RSA1 {

    public static void main(String[] args) {
        
        BigInteger n =  new BigInteger("100160063");
        
        System.out.println("# = " + MetodosRSA.phiEulerArreglo(n));
        
    }
    
}