package dev.razafindratelo.sequences;

import dev.razafindratelo.tools.Fraction;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * This SquareRootSub, as a sub-sequence of the SquareRoot sequence, is my sequence (a_n).
 */
@Getter
@EqualsAndHashCode(callSuper = true)
public class SquareRootSub extends Sequence {
    private final long rootValue;

    public SquareRootSub(long n) {
        super(n);
        this.rootValue = getThePerfectSquareRoot(n);
    }

    /**
     * @param n : n is a positive integer
     * @return the minimum positive square root of the perfect square greater or equal than n.
     */

    private static long getThePerfectSquareRoot(long n) {
		if (n < 0) {
		    throw new IllegalArgumentException("Input must be non-negative");
		}

		long lowerBound = 0;
		long upperBound = n;
		long thePerfectSquare = 0;

		while (lowerBound <= upperBound) {
		    long middle = (lowerBound + upperBound) >>> 1;
		    long square = middle * middle;

		    if (square >= n) {
		        thePerfectSquare = middle;
		        upperBound = middle - 1;
		    } else {
		        lowerBound = middle + 1;
		    }
		}

		return thePerfectSquare;
	}

    /**
     * @param k : k is range of the square root sequence
     * @return the k-th value of the square root sequence
     */
    public Fraction sqrtSub(long k) {
        if (this.getN() == rootValue * rootValue) {
            return Fraction.ZERO;

        } else if (k == 0) {
            return Fraction.valueOf(rootValue);

        } else if (k == 1) {
            long num = 2 * rootValue;
            long den = (rootValue * rootValue) - this.getN();

            return Fraction.valueOf(num, den);

        } else if (k == 2) {
            long num = 4 * rootValue * ((rootValue * rootValue) + this.getN() );
            long den = ((rootValue * rootValue) - this.getN()) * ((rootValue * rootValue) - this.getN());

            return Fraction.valueOf(num, den);

        } else {
            Fraction sq_k_1 = sqrtSub(k-1);
            Fraction sq_k_2 = sqrtSub(k-2);

            return sq_k_1.multiply(2).multiply(
                    sq_k_1.toThePowerOf(2)
                            .divide(
                                    sq_k_2.toThePowerOf(2).multiply(2)
                            ).add(-1)
            );
        }
    }

}
