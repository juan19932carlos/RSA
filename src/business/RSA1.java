package business;

import java.math.BigInteger;
import data.MetodosRSA;
import data.NumerosPrimos;

/**
 *
 * @author BioPeligro99
 * @author Juan19932carlos
 * 
 */

public class RSA1 {

    public static void main(String[] args) {
        
        BigInteger  n = new BigInteger("2147483647");
        BigInteger isPrime = NumerosPrimos.Raiz(n);
        
        System.out.println(isPrime);
        
    }
    
}