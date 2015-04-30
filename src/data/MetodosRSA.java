package data;

import java.math.BigInteger;

/**
 *
 * @author BioPeligro99
 */
public class MetodosRSA {

    public static BigInteger maxComDiv(BigInteger a, BigInteger b) {
        return mcd(a, b);
    }

    private static BigInteger mcd(BigInteger a, BigInteger b) {
        if (a.compareTo(b) == -1) {
            return maxComDiv(b, a);
        }
        if (a.compareTo(b) == 0) {
            return a;
        }
        BigInteger tmp = a.mod(b);
        if (tmp.compareTo(BigInteger.ZERO) == 0) {
            return b;
        }
        return maxComDiv(b, tmp);
    }

    public static BigInteger phiEulerPQ(BigInteger p, BigInteger q) {
        return ((p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE)));
    }

    public static BigInteger phiEulerArreglo(BigInteger producto) {

        BigInteger contador = new BigInteger("0");
        BigInteger tmp = new BigInteger("1");
        BigInteger prodMenos = producto.subtract(BigInteger.ONE);

        for (int i = 0; i < 3; i++) {
            if (tmp.compareTo(prodMenos) != 1) {

                if (producto.gcd(tmp).compareTo(BigInteger.ONE) == 0) {
                    contador = contador.add(BigInteger.ONE);
                }
                i = 0;
            } else {
                i = 4;
            }

            tmp = tmp.add(BigInteger.ONE);

        }

        return contador;
    }

}
