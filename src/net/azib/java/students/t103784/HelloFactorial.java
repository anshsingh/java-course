package net.azib.java.students.t103784;

import java.math.BigInteger;

/**
 * Created by IntelliJ IDEA.
 * User: Ott Madis Ozolit
 * Date: 16.02.11
 * Time: 23:23
 * To change this template use File | Settings | File Templates.
 */
public class HelloFactorial {
	public static void main(String[] args) {
		thingamajig(100);
	}

	public static BigInteger thingamajig(int a) {

		BigInteger fNum = new BigInteger("1");
		for (int i = 1; i <= a; i++) {
			fNum = fNum.multiply(BigInteger.valueOf(i));
		}
		//System.out.println("Ossaraks: " + fNum);
		return fNum;
	}
}
