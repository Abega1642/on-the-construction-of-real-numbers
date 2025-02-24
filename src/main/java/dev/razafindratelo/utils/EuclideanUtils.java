package dev.razafindratelo.utils;

import java.math.BigInteger;

public class EuclideanUtils {

    public static long gcd(long a, long b) {
        EuclideanDivision euclideanDivision = new EuclideanDivision(a, b);
        if (euclideanDivision.getReminder() != 0) {
            return gcd(b, euclideanDivision.getReminder());
        } else {
            return b;
        }
    }

    public static long gcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    public static BigInteger gcm(BigInteger a, BigInteger b) {
        return (a.multiply(b))
                .divide(a.gcd(b));
    }
}
