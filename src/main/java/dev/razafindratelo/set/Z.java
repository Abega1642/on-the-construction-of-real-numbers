package dev.razafindratelo.set;

import dev.razafindratelo.utils.Euclidian;

import java.math.BigInteger;

/**
 *  Z stands for the set of negative and positive Integer as in Mathematics
 */
public class Z implements R {

    public static long gcd(long a, long b) {
        var euclidian = Euclidian.division(a, b);
        if (euclidian.get("r") != 0) {
            return gcd(b, euclidian.get("r"));
        } else {
            return b;
        }
    }

    public static long gcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    public static BigInteger gcm(BigInteger a, BigInteger b) {
        return (a.multiply(b)).divide(a.gcd(b));
    }
}
