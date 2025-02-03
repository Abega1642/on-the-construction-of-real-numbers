package dev.razafindratelo.utils;

public class GCD {
    public static int gcd(int a, int b) {
        var euclidian =  Euclidian.division(a, b);
        if (euclidian.get("r") != 0) {
            return gcd(b, euclidian.get("r"));
        } else {
            return b;
        }
    }
}
