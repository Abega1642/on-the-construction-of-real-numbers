package dev.razafindratelo.sequences;

import dev.razafindratelo.tools.Fraction;
import lombok.Getter;

/**
 * This SquareRoot sequence is the sequence (x_n)
 */
@Getter
public class SquareRoot extends Sequence {

    public SquareRoot(long n) {
        super(n);
    }

	@Override
    public Fraction kThValue(long k) {
		if (this.getN() == 1) return Fraction.ONE;

		final SquareRootSub sqSub = new SquareRootSub(this.getN());

		if (this.getN() == sqSub.getRootValueSquared()) return Fraction.valueOf(sqSub.getRootValue());

		if (k == 0) {
		    return Fraction.valueOf(sqSub.getRootValue());
		} else {
		    Fraction val = Fraction.ZERO;

		    for (int i = 1; i <= k; i++) {
		        val = val.add(sqSub.kThValue(i).inverse().opposite());
		    }

		    return val.add(sqSub.getRootValue());
		}
	}

}
