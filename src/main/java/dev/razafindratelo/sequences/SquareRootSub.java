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
    private final long rootValueSquared;
    private final long squareDeviation;

    public SquareRootSub(long n) {
        super(n);
        this.rootValue = getThePerfectSquareRoot(n);
        this.rootValueSquared = rootValue * rootValue;
        this.squareDeviation = rootValueSquared - n;
    }

    /**
     * @param n a positive integer
     * @return the minimum positive square root of the perfect square greater or equal than n.
     */
    private static long getThePerfectSquareRoot(long n) {
	if (n < 0) throw new IllegalArgumentException("Input must be non-negative");

	if (n == 1) return n;

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

    @Override
    public Fraction kThValue(long k) {

	if (rootValueSquared == this.getN())
	    return Fraction.ZERO;
	if (k == 0)
	    return Fraction.valueOf(rootValue);
	if (k == 1)
	    return Fraction.valueOf(rootValue << 1, squareDeviation);

	Fraction sq_k_2 = Fraction.valueOf(rootValue << 1,squareDeviation);
	Fraction sq_k_1 = Fraction.valueOf(
			rootValue * (rootValueSquared + this.getN()) << 2,
			squareDeviation * squareDeviation
	);

	Fraction result = sq_k_1;

	for (long i = 3; i <= k; i++) {
	    result = sq_k_1.multiply(sq_k_1.divide(sq_k_2).toThePowerOf(2).add(-2));
	    sq_k_2 = sq_k_1;
	    sq_k_1 = result;
	}

	return result;
    }

}
