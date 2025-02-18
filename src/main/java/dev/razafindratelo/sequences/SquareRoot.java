package dev.razafindratelo.sequences;

import dev.razafindratelo.tools.Fraction;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * This SquareRoot sequence is the sequence (x_n)
 */
@Getter
@AllArgsConstructor
public class SquareRoot {
    private long n;
    private List<Fraction> values;

    public SquareRoot(long n) {
        this.n = n;
        this.values = new ArrayList<>();
    }

    public Fraction sq_(long k) {
        SquareRootSub sqSub = new SquareRootSub(n);

        long perfectSquare = sqSub.getRootValue();

        if (this.n ==  perfectSquare * perfectSquare) {
            return new Fraction(perfectSquare);
        }
        if (k == 0) {
            return new Fraction(sqSub.getRootValue());
        } else {
            Fraction val = Fraction.ZERO;
            List<Fraction> values = new ArrayList<>();

            for (int i = 1; i <= k; i++) {
                Fraction sqSub_i = sqSub.sqSub_(i);
                values.add(sqSub_i);
            }
            for (Fraction value : values) {
                val = val.add(value.inverse().opposite());
            }

            return val.add(sqSub.getRootValue());
        }
    }
}
