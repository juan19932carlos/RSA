package primalidad;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;

public class Algoritmos {
	
	private static final BigInteger ZERO = BigInteger.ZERO;
	private static final BigInteger ONE = BigInteger.ONE;
	private static final BigInteger TWO = new BigInteger("2");
	private static final BigInteger THREE = new BigInteger("3");

public static boolean isProbablePrime(BigInteger n, int k) {
		if (n.compareTo(THREE) < 0)
			return true;
		int s = 0;
		BigInteger d = n.subtract(ONE);
		while (d.mod(TWO).equals(ZERO)) {
			s++;
			d = d.divide(TWO);
		}
		for (int i = 0; i < k; i++) {
			BigInteger a = uniformRandom(TWO, n.subtract(ONE));
			BigInteger x = a.modPow(d, n);
			if (x.equals(ONE) || x.equals(n.subtract(ONE)))
				continue;
			int r = 1;
			for (; r < s; r++) {
				x = x.modPow(TWO, n);
				if (x.equals(ONE))
					return false;
				if (x.equals(n.subtract(ONE)))
					break;
			}
			if (r == s) // None of the steps made x equal n-1.
				return false;
		}
		return true;
}

private static BigInteger uniformRandom(BigInteger bottom, BigInteger top) {
	Random rnd = new Random();
	BigInteger res;
	do {
		res = new BigInteger(top.bitLength(), rnd);
	} while (res.compareTo(bottom) < 0 || res.compareTo(top) > 0);
	return res;
}
    public static boolean isPrime(BigInteger n) {
        BigInteger TWO = new BigInteger("2");
        BigInteger b = new BigInteger("1");
        BigInteger c = new BigInteger("0");
        BigInteger r = sqrt(n).add(b);
        //System.out.println("$$ = " + r);
        for (int i = 0; i < 2; i++) {
            if (TWO.compareTo(r) <= 0) {
                //System.out.println("@@@=" + a);
                if (n.mod(TWO).compareTo(c) == 0) {
                    return false;
                }
                TWO = TWO.add(b);
                i = -1;
            } else {
                i = 3;
            }
        }
        return true;
    }

    private static BigInteger sqrt(BigInteger m) {
        BigInteger CERO = BigInteger.ZERO;
        int diff = m.compareTo(CERO);
        if (diff < 0) {
            return null; // No existe la raíz cuadrada
        }
        if (diff == 0) {
            return BigInteger.valueOf(0);
        }
        BigDecimal n = new BigDecimal(m);
        byte[] barray = new byte[m.bitLength() / 16 + 1];
        barray[0] = (byte) 255;
        BigDecimal two = new BigDecimal("2");
        BigDecimal r = new BigDecimal(new BigInteger(1, barray));
        r = r.subtract(r.multiply(r).subtract(n).divide(r.multiply(two), BigDecimal.ROUND_UP));
        while (r.multiply(r).compareTo(n) > 0) {
            r = r.subtract(r.multiply(r).subtract(n).divide(r.multiply(two), BigDecimal.ROUND_UP));
        }
        return r.toBigInteger();
    }
 //esto es una pruebaaaaaaa
}
