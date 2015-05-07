package data;

import java.math.BigInteger;

/**
 *
 * @author BioPeligro99
 * @author Juan19932Carlos
 * 
 */
public class MetodosRSA {
    
    private static final BigInteger UNO = BigInteger.ONE;

    public static BigInteger euclidesExtendido(BigInteger a, BigInteger b) {
        if (a.compareTo(b) == -1) {  // Invierte si b es mayor a a
            return euclidesExtendido(b, a);
        }
        if (a.compareTo(b) == 0) {
            return a;
        }
        BigInteger resto    = a.mod(b),
                   cociente = a.subtract(resto).divide(b) ;
        
        if (resto.compareTo(UNO) == 0) {
            return cociente;
        }
        return euclidesExtendido(b, resto);
    }

    public static BigInteger mcd(BigInteger a, BigInteger b) {
        if (a.compareTo(b) == -1) {
            return mcd(b, a);
        }
        if (a.compareTo(b) == 0) {
            return a;
        }
        BigInteger tmp = a.mod(b);
        if (tmp.compareTo(BigInteger.ZERO) == 0) {
            return b;
        }
        return mcd(b, tmp);
    }

    public static BigInteger phiEulerPQ(BigInteger p, BigInteger q) {
        return ((p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE)));
    }

    public static BigInteger phiEulerArreglo(BigInteger producto) {

        BigInteger contador = new BigInteger("0");
        BigInteger tmp = new BigInteger("1");
        BigInteger prodMenos = producto.subtract(BigInteger.ONE);

        do{
            if (producto.gcd(tmp).compareTo(BigInteger.ONE) == 0) {
                contador = contador.add(BigInteger.ONE);
            }

            tmp = tmp.add(BigInteger.ONE);

        }while(tmp.compareTo(prodMenos) != 1);

        return contador;
    }

}
