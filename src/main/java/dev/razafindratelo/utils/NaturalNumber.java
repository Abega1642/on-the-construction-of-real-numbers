package dev.razafindratelo.utils;

public class NaturalNumber {

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
