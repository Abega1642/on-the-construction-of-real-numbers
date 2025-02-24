package dev.razafindratelo.utils;

import java.math.BigInteger;

public class EuclideanUtils {

    public static long gcd(long a, long b) {
		a = Math.abs(a);
		b = Math.abs(b);

		while (b != 0) {
		    long temp = b;
		    b = a % b;
		    a = temp;
		}

		return a;
	}

    public static long gcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    public static BigInteger gcm(BigInteger a, BigInteger b) {
        return (a.multiply(b))
                .divide(a.gcd(b));
    }
}
