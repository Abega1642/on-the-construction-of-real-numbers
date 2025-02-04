package dev.razafindratelo.tools;

import dev.razafindratelo.utils.NaturalNumber;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
public class Fraction implements Tool {
    private int numerator;
    private int denominator;


    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("denominator must be greater than zero");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public void simplify() {
        int gcd = NaturalNumber.gcd(numerator, denominator);

        numerator /= gcd;
        denominator /= gcd;
    }

    public Fraction add(Fraction frac) {
        return null;
    }
}
