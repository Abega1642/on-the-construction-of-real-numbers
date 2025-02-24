package dev.razafindratelo.utils;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Euclidian {
    private final long quotient;
    private final long reminder;

    public Euclidian (long a, long b) {

        if (b == 0) {
            this.quotient = 0;
            this.reminder = a;

        } else {
            this.quotient= (b > 0) ?
                    (long) Math.floor((double) a / b) : (long) Math.ceil((double) a / b);

            this.reminder = a - (b * quotient);
        }
    }
}
