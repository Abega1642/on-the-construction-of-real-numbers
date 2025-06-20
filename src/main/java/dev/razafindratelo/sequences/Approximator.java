package dev.razafindratelo.sequences;

import dev.razafindratelo.tools.Fraction;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Approximator, as a subsequence of the SquareRoot sequence, is my sequence (a_n).
 */
@Getter
@EqualsAndHashCode(callSuper = true)
public class Approximator extends Sequence {
    private final long rootValue;
    private final long rootValueSquared;
    private final long squareDeviation;

    public Approximator(long n) {
        super(n);
        this.rootValue = (int) Math.ceil(Math.sqrt(n));
        this.rootValueSquared = rootValue * rootValue;
        this.squareDeviation = rootValueSquared - n;
    }

    @Override
    public Fraction kThValue(long k) {

        if (rootValueSquared == this.getN())
            return Fraction.ZERO;
        if (k == 0)
            return Fraction.valueOf(rootValue);
        if (k == 1)
            return Fraction.valueOf(rootValue << 1,squareDeviation);

        Fraction sqK2 = Fraction.valueOf(rootValue << 1,squareDeviation);
        Fraction sqK1 = Fraction.valueOf(rootValue * (rootValueSquared + this.getN()) << 2,
                squareDeviation * squareDeviation);

        Fraction kThValue = sqK1;

        for (long i = 3; i <= k; i++) {
            kThValue = sqK1.multiply(sqK1.divide(sqK2).toThePowerOf(2).add(-2));
            sqK2 = sqK1;
            sqK1 = kThValue;
        }

        return kThValue;
    }

}
