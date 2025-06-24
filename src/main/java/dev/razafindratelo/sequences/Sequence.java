package dev.razafindratelo.sequences;

import dev.razafindratelo.tools.Fraction;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
public sealed abstract class Sequence permits Approximator, SquareRoot, HeronSequence {
    private final long n;

    protected Sequence(long n) {
        this.n = n;
    }

    /**
     * @param k:
     *            k is range of the square root sequence
     * @return the k-th value of the square root sequence
     */
    abstract Fraction kThValue(long k);
}
