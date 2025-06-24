package dev.razafindratelo.sequences;

import dev.razafindratelo.tools.Fraction;
import lombok.Getter;

@Getter
public final class HeronSequence extends Sequence {

    private static final Fraction TWO = Fraction.valueOf(2);
    private static final Fraction ONE_HALF = TWO.inverse();

    private HeronSequence(long n) {
        super(n);
    }

    public static HeronSequence init() {
        return new HeronSequence(2);
    }

    @Override
    Fraction kThValue(long k) {
        if (k < 0)
            throw new IllegalArgumentException("k must be greater than zero");

        if (k == 0)
            return Fraction.valueOf(2);

        Fraction previous = kThValue(k - 1);

        return ONE_HALF.multiply(previous.add(TWO.divide(previous)));
    }
}
