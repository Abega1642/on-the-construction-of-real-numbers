package dev.razafindratelo.utils;

/**
 *  Z stands for the set of negative or positive integer as in Mathematics
 */
public class Z {

    public static int gcd(int a, int b) {
        var euclidian =  Euclidian.division(a, b);
        if (euclidian.get("r") != 0) {
            return gcd(b, euclidian.get("r"));
        } else {
            return b;
        }
    }

    public static int gcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}
