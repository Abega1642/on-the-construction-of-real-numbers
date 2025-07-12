package dev.razafindratelo.sequences;

import dev.razafindratelo.tools.Fraction;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
public abstract sealed class Sequence permits Approximator, SquareRoot, HeronSequence {
    private final long nat;

    protected Sequence(long nat) {
        this.nat = nat;
    }

    /**
     * @param k:
     *            k is range of the square root sequence
     * @return the k-th value of the square root sequence
     */
    abstract Fraction kThValue(long k);
}
