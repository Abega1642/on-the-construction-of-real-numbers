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
		SquareRootSub sqSub = new SquareRootSub(this.getN());
		long perfectSquare = sqSub.getRootValue();

		if (this.getN() == perfectSquare * perfectSquare) {
		    return Fraction.valueOf(perfectSquare);
		}

		if (k == 0) {
		    return Fraction.valueOf(sqSub.getRootValue());
		} else {
		    Fraction val = Fraction.ZERO;

		    for (int i = 1; i <= k; i++) {
		        Fraction sqSub_i = sqSub.kThValue(i);
		        val = val.add(sqSub_i.inverse().opposite());
		    }

		    return val.add(sqSub.getRootValue());
		}
	}

}
