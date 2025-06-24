package dev.razafindratelo.sequences;

import dev.razafindratelo.tools.Fraction;
import lombok.Getter;

/**
 * SquareRoot sequence: the sequence (x_n)
 */
@Getter
public class SquareRoot extends Sequence {

    private SquareRoot(long n) {
        super(n);
    }

    public static SquareRoot of(long n) {
        if (n <= 0) throw new IllegalArgumentException("n must be greater than 0");
        return new SquareRoot(n);
    }

    @Override
    public Fraction kThValue(long k) {
        if (this.getN() == 1)
            return Fraction.ONE;

        final Approximator sqSub = Approximator.of(this.getN());

        if (this.getN() == sqSub.getRootValueSquared())
            return Fraction.valueOf(sqSub.getRootValue());

        if (k == 0) {
            return Fraction.valueOf(sqSub.getRootValue());
        } else {
            Fraction kThValue = Fraction.ZERO;

            for (int i = 1; i <= k; i++) {
                kThValue = kThValue.add(sqSub.kThValue(i).inverse().opposite());
            }

            return kThValue.add(sqSub.getRootValue());
        }
    }

}
