package dev.razafindratelo.utils;

import java.util.Map;

public class Euclidian {
    public static Map<String, Integer> division (int a, int b) {
        int q;
        int r;

        if (a == 0 && b == 0) {
            return Map.of("a", 0, "b", 0, "q", 0, "r", 0);
        }
        if (b == 0) {
            return Map.of("a", a, "b", b, "q", 0, "r", a);
        }

        if (a < 0) {
            q = (a / b) < 0 ? (a / b) - 1 : (a / b) + 1;

        } else {
            q = a / b;
        }

        r = a - b* q;

        return Map.of("a", a, "b", b, "q", q, "r", r);
    }

}
