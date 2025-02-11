package dev.razafindratelo.sequences;

import dev.razafindratelo.tools.Fraction;
import lombok.Data;

import java.math.BigDecimal;
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

            return result;

        } else if (n == 2) {
            long num = 4 * rootValue * ((rootValue * rootValue) + this.n );
            long den = ((rootValue * rootValue) - this.n) * ((rootValue * rootValue) - this.n);

            Fraction result = new Fraction(num, den);
            result.simplify();
            return result;

        } else {
            Fraction sq_n_1 = sq_(n-1);
            Fraction sq_n_2 = sq_(n-2);


            return sq_n_1.multiply(2).multiply(
                    sq_n_1.toThePowerOf(2)
                            .divide(
                                    sq_n_2.toThePowerOf(2).multiply(2)
                            ).add(-1)
            );
        }
    }

    public static void main(String[] args) {
        var sq = new SquareRoot(2);
        List<Fraction> values = new ArrayList<>();

        for(int i = 1; i < 10; i++) {
            values.add(sq.sq_(i));
        }

        Fraction fraction = Fraction.ZERO;
        for (int i = 0; i < values.size(); i++) {
            fraction = fraction.add(values.get(i).inverse().opposite());
        }

        var res = fraction.add(sq.rootValue);
        BigDecimal val = res.getValue();

        System.out.println("RESULT == "+ val );

        System.out.println("VAL * VAL == " + val.multiply(val));

        List<Fraction> sequences = values.stream().map(Fraction::inverse).toList();
        int i = 1;
        System.out.println("========== FACTIONS OF THE SEQUENCES OF SQRT(2) =========");
        for(Fraction frac : sequences) {
            System.out.println("a_"+ i + " === " +frac);
            i++;
        }

    }

}
