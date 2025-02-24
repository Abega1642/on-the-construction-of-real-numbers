package dev.razafindratelo.sequences;

import dev.razafindratelo.tools.Fraction;
import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

/**
 * This SquareRoot sequence is the sequence (x_n)
 */
@Getter
public class SquareRoot extends Sequence {

    public SquareRoot(long n) {
        super(n);
    }

    public Fraction sqrt(long k) {
        SquareRootSub sqSub = new SquareRootSub(this.getN());

        long perfectSquare = sqSub.getRootValue();

        if (this.getN() ==  perfectSquare * perfectSquare) {
            return Fraction.valueOf(perfectSquare);
        }
        if (k == 0) {
            return Fraction.valueOf(sqSub.getRootValue());
        } else {
            Fraction val = Fraction.ZERO;
            List<Fraction> values = new ArrayList<>();

            for (int i = 1; i <= k; i++) {
                Fraction sqSub_i = sqSub.sqrtSub(i);
                values.add(sqSub_i);
            }
            for (Fraction value : values) {
                val = val.add(value.inverse().opposite());
            }

            return val.add(sqSub.getRootValue());
        }
    }
}
