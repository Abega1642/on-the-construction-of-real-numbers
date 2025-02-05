package dev.razafindratelo.sequences;

import dev.razafindratelo.tools.Fraction;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class SquareRoot {
    private long n;
    private List<Fraction> values;
    private long rootValue;

    public SquareRoot(long n) {
        this.n = n;
        this.values = new ArrayList<>();
        this.rootValue = getTHEPerfectSquareRoot(n);
    }

    private static long getTHEPerfectSquareRoot(long n) {

        long i = 0;

        while (true) {
            if (n <= i*i) {
                return i;
            }
            i++;
        }
    }

    public Fraction sq_(long n) {
        if (n == 0) {
            return new Fraction(rootValue);
        } else if (n == 1) {
            long num = 2 * rootValue;
            long den = (rootValue * rootValue) - this.n;

            Fraction result = new Fraction(num, den);
            result.simplify();

            return result.inverse();

        } else if (n == 2) {
            long num = 4 * rootValue * ((rootValue * rootValue) + this.n );
            long den = ((rootValue * rootValue) - this.n) * ((rootValue * rootValue) - this.n);

            Fraction result = new Fraction(num, den);
            result.simplify();
            return result.inverse();

        } else {
            Fraction sq_n = sq_(n);
            Fraction sq_n_1 = sq_(n-1);

            System.out.println("SQ_n = " + sq_n);
            System.out.println("SQ_n_1 = " + sq_n_1);

            Fraction left = sq_n.multiply(2);

            Fraction right = sq_n.toThePowerOf(2)
                    .divide(
                            sq_n_1.toThePowerOf(2).multiply(2)
                    ).add(-1);

            return sq_n.multiply(2).multiply(right);
        }
    }
}
