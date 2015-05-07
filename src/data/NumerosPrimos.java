package data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;

/**
 *
 * @author BioPeligro99
 * @author Juan19932carlos
 * @author Jamuq
 * 
 */
public class NumerosPrimos {
    
    final static BigInteger CERO = BigInteger.ZERO;
    final static BigInteger UNO = BigInteger.ONE;
    final static BigInteger DOS = new BigInteger("2");
    final static BigInteger TRES = new BigInteger("3");
    
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
        
        if (digitos <= 0)
            throw new NumberFormatException("El numero de digitos debe ser positivo mayor que 0");

        String tmp = "";

        for (int i = 0; i < digitos; i++) {
            tmp += (new Random().nextInt(10)) + "";
        }
        return new BigInteger(tmp).nextProbablePrime();

    }
    /**
     * Comprueva la primalidad del numero ingresado realizando el modulo 
     * con todos los numeros impares de 3 hasta el {@code (supprimo - 1)}.
     * 
     * @param supPrimo el numero a comprovar su primalidad.
     * @return {@code true} si el valor dado es primo o {@code false} 
     *         en caso contrario
     * 
     */ 
    public static boolean esPrimoFuerzaBruta(BigInteger supPrimo) {
        
        if(supPrimo.compareTo(BigInteger.ZERO) < 0)
            throw new NumberFormatException("El parametro SupPrimo debe ser mayor a 0.");
        
        if(supPrimo.compareTo(DOS) == 0)
            return true;
        
        if(!supPrimo.testBit(0)){
            return false;
            
        }
        
        BigInteger x = new BigInteger("3"),
                   SupPrim_MenosUno= supPrimo.subtract(UNO);

        do{
            if (supPrimo.mod(x) == BigInteger.ZERO) {
                return false;
            }
            x = x.add(DOS);
        }while(x.compareTo(SupPrim_MenosUno) <= 0 );
        return true;
    }
    /**
     * Comprueva la primalidad del numero ingresado realizando el modulo 
     * con todos los numeros primos de 2 hasta {@code raiz(supPrimo) }.
     * 
     * @param supPrimo e numero a comprovar su primalidad.
     * @return {@code true} si el valor dado es primo o {@code false} 
     *         en caso contrario
     * 
     */ 
    public static boolean esPrimoRaiz(BigInteger supPrimo) {
        if(supPrimo.compareTo(BigInteger.ZERO) < 0)
            throw new NumberFormatException("El parametro SupPrimo debe ser mayor a 0.");
                
        if(supPrimo.compareTo(DOS) == 0)
            return true;
        
        if(!supPrimo.testBit(0))
            return false;
        
        BigInteger r = Raiz(supPrimo).add(UNO);
        
        if(!r.testBit(0))
            r=r.subtract(UNO);
        do{
            if (supPrimo.mod(r).compareTo(BigInteger.ZERO) == 0) {
                return false;
            }
            r = r.subtract(DOS);
        }while(r.compareTo(TRES) >= 0);
        
        return true;
    }
    /**
     * halla la raiz cuadrada del valor dado con el metodo de resolucion
     * clasico luego loredondea al Entero mas cercano
     * <li> si {@code numero} es menor que sero arroja una exepcion
     * <li> si {@code numero} es 0 el resultado es 0
     * 
     * @param numero el parametro al cual se lehalara la raiz.
     * 
     * @return retorna la raiz cuadrada redondeada de {@code numero}
     */
    public static BigInteger Raiz(BigInteger numero) {
        int diff = numero.compareTo(BigInteger.ZERO);
        Math.sqrt(diff);
        if ( diff < 0)
            throw new ArithmeticException("No existe la raiz cuadrada");
            
        if (diff == 0) {
            return BigInteger.valueOf(0);
        }
        
        BigDecimal n = new BigDecimal(numero);
        
        byte[] barray = new byte[numero.bitLength() / 16 + 1];
                
        barray[0] = (byte) 255;
        BigDecimal dos = new BigDecimal("2");
        
        BigDecimal r = new BigDecimal(new BigInteger(1, barray));
        r = r.subtract(r.multiply(r).subtract(n).divide(r.multiply(dos), BigDecimal.ROUND_UP));
        while (r.multiply(r).compareTo(n) > 0) {
            r = r.subtract(r.multiply(r).subtract(n).divide(r.multiply(dos), BigDecimal.ROUND_UP));
        }
        return r.toBigInteger();
    }
    /**
     * Verifica si un numero es probable primo por medio de primalidad 
     * Fuerte de Miller-Rabin realizando el numero de pruevas especificado 
     * por {@code repeticiones}
     * 
     * @param repeticiones el parametro al cual se lehalara la raiz.
     * 
     * @return retorna {@code true} si el numero es pribable primo o {@code false} en caso contrario
     */
    public static boolean esPrimoMillerRabin(BigInteger supPrime , int repeticiones){
        
        if (repeticiones <= 0)
            throw new ArithmeticException(" el numero de repeticiones debe ser mayor que 0");
            
        if(supPrime.compareTo(DOS) == 0 )
            return true;
        if(!supPrime.testBit(0))
            return false;        
        
        // Encontrar a y m tal que m es impar y  supPrime == 1 + 2**a * m
        BigInteger SupPrimoMenosUno = supPrime.subtract(UNO);
        BigInteger m = SupPrimoMenosUno;
        
        int a = m.getLowestSetBit();
        
        System.out.println(a);
        
        m = m.shiftRight(a);
        
        System.out.println("a = " + a + " y m = " + m);

        Random rnd;  
        rnd = new Random();
        
        for (int i=0; i<repeticiones; i++) {
            // Generar un numero aleatorio
            BigInteger b;
            do {
                b = new BigInteger(supPrime.bitLength(), rnd);
            } while (b.compareTo(UNO) <= 0 || b.compareTo(supPrime) >= 0);

            int j = 0;
            BigInteger z = b.modPow(m, supPrime);
            while(!((j==0 && z.equals(UNO)) || z.equals(SupPrimoMenosUno))) {
                if (j>0 && z.equals(UNO) || ++j==a)
                    return false;
                z = z.modPow(DOS, supPrime);
            }
        }
        return true;
    }
}

