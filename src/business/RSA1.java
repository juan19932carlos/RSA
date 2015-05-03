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
        
        BigInteger  n =  NumerosPrimos.aleatorio(100),
                    m =  NumerosPrimos.aleatorio(100);;
        
        System.out.println("# = " + n + "\n # =" + m + " \n multiplicaion = " + m.multiply(n));
        
    }
    
}