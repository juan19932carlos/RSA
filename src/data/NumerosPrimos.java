package data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;

/**
 *
 * @author BioPeligro99
 * @author Juan19932carlos
 * 
 */
public class NumerosPrimos {
    
    /**
     * Retorna Un Numero primo aleatorio de del numero de cifras especificado 
     * generando un numero aleatorio cualquiera y buscando ql numero primo 
     * siguiente, se antiende que el numero de digitos es positivo, no se 
     * hace correción de errores.
     * 
     * @param digitos Cantidad de digitos que tendra el numero aleatorio.
     * @return El BigInteger es por a lo menos de el numero de cifras de {@code digitos}
     * 
     */    
    public static BigInteger aleatorio(int digitos) {

        String tmp = "";

        for (int i = 0; i < digitos; i++) {
            tmp += ((new Random().nextInt(10)) + "");
        }
        return new BigInteger(tmp).nextProbablePrime();

    }
    /**
     * Comprueva la primalidad del numero ingresado realizando el modulo 
     * con todos los numeros primos de 2 hasta el valor dado menos 1.
     * 
     * @param supPrimo e numero a comprovar su primalidad.
     * @return {@code true} si el valor dado es primo o {@code false} 
     *         en caso contrario
     * 
     */ 
    public static boolean esPrimoFuerzaBruta(BigInteger supPrimo) {

        BigInteger x = new BigInteger("2");
        BigInteger y = new BigInteger("1");
        BigInteger z = new BigInteger("0");

        for (int i = 0; i < 3; i++) {
            if (supPrimo.mod(y) == z) {
                return false;
            } else {
                if (x.compareTo(supPrimo.subtract(y)) <= 0 ) {
                    x = x.add(y);
                    i = 0;                    
                } else {
                    i = 4;
                }
            }
        }
        return true;
    }
    /**
     * Comprueva la primalidad del numero ingresado realizando el modulo 
     * con todos los numeros primos de 2 hasta el valor dado menos 1.
     * 
     * @param supPrimo e numero a comprovar su primalidad.
     * @return {@code true} si el valor dado es primo o {@code false} 
     *         en caso contrario
     * 
     */ 
    public static boolean esPrimoRaiz(BigInteger supPrimo) {
        BigInteger TWO = new BigInteger("2");
        BigInteger b = new BigInteger("1");
        BigInteger c = new BigInteger("0");
        BigInteger r = Raiz(supPrimo).add(b);
        
        for (int i = 0; i < 2; i++) {
            if (TWO.compareTo(r) <= 0) {
                if (supPrimo.mod(TWO).compareTo(c) == 0) {
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

    public static BigInteger Raiz(BigInteger numero) {
        BigInteger CERO = BigInteger.ZERO;
        int diff = numero.compareTo(CERO);
        if (diff < 0) {
            return null; // No existe la raíz cuadrada
        }
        if (diff == 0) {
            return BigInteger.valueOf(0);
        }
        BigDecimal n = new BigDecimal(numero);
        byte[] barray = new byte[numero.bitLength() / 16 + 1];
        barray[0] = (byte) 255;
        BigDecimal two = new BigDecimal("2");
        BigDecimal r = new BigDecimal(new BigInteger(1, barray));
        r = r.subtract(r.multiply(r).subtract(n).divide(r.multiply(two), BigDecimal.ROUND_UP));
        while (r.multiply(r).compareTo(n) > 0) {
            r = r.subtract(r.multiply(r).subtract(n).divide(r.multiply(two), BigDecimal.ROUND_UP));
        }
        return r.toBigInteger();
    }
    
    public static boolean esPrimoMillerRabin(BigInteger supPrime){
        return supPrime.isProbablePrime(10);
    }
    
}

