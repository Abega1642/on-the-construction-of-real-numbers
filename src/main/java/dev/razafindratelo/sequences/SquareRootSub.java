package dev.razafindratelo.sequences;

import dev.razafindratelo.tools.Fraction;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * This SquareRootSub, as a sub-sequence of the SquareRoot sequence, is my sequence (a_n).
 */
@Data
public class SquareRootSub {
    private long n;
    private List<Fraction> values;
    private long rootValue;

    public SquareRootSub(long n) {
        this.n = n;
        this.values = new ArrayList<>();
        this.rootValue = getTHEPerfectSquareRoot(n);
    }

    /**
     * @param n : n is a positive integer
     * @return the minimum positive square root of the perfect square greater or equal than n.
     */

    private static long getTHEPerfectSquareRoot(long n) {

        long i = 0;

        while (true) {
            if (n <= i*i) {
                return i;
            }
            i++;
        }
    }

    /**
     * @param k : k is range of the square root sequence
     * @return the k-th value of the square root sequence
     */
    public Fraction sqSub_(long k) {
        if (k == 0) {
            return new Fraction(rootValue);
        } else if (k == 1) {
            long num = 2 * rootValue;
            long den = (rootValue * rootValue) - this.n;

            Fraction result = new Fraction(num, den);
            result.simplify();

            return result;

        } else if (k == 2) {
            long num = 4 * rootValue * ((rootValue * rootValue) + this.n );
            long den = ((rootValue * rootValue) - this.n) * ((rootValue * rootValue) - this.n);

            Fraction result = new Fraction(num, den);
            result.simplify();
            return result;

        } else {
            Fraction sq_k_1 = sqSub_(k-1);
            Fraction sq_k_2 = sqSub_(k-2);


            return sq_k_1.multiply(2).multiply(
                    sq_k_1.toThePowerOf(2)
                            .divide(
                                    sq_k_2.toThePowerOf(2).multiply(2)
                            ).add(-1)
            );
        }
    }

}
