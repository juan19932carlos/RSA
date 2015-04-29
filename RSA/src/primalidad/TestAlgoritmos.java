package primalidad;

import java.math.BigInteger;

import junit.framework.TestCase;

public class TestAlgoritmos extends TestCase {
	
	public void test_isPrime(){
		boolean res = Algoritmos.isPrime(new BigInteger("2305843009213693951"));
		System.out.println(res);
	}
	public void test_isProbablePrime(){
		boolean res = new BigInteger("2305843009213693951").isProbablePrime(14);
		System.out.println(res);
	}
	
	public static void main(String[] args) {
		junit.textui.TestRunner.run( TestAlgoritmos.class );

	}

}
