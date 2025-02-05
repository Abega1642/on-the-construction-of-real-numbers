package dev.razafindratelo.utils;

import java.util.Map;

public class Euclidian {
    public static Map<String, Long> division (long a, long b) {
        long q;
        long r;

        if (a == 0 && b == 0) {
            return Map.of("a", 0L, "b", 0L, "q", 0L, "r", 0L);
        }
        if (b == 0) {
            return Map.of("a", a, "b", b, "q", 0L, "r", a);
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
