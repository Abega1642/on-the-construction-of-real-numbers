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
            throw new IllegalArgumentException("denominator must be greater non-zero");
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
        int denGCM = NaturalNumber.gcm(denominator, frac.getDenominator());

        int leftSideMult = denGCM / this.denominator;
        int rightSideMult = denGCM /frac.denominator;


        this.denominator *= leftSideMult;
        this.numerator *= leftSideMult;

        frac.setDenominator(frac.getDenominator() * rightSideMult);
        frac.setNumerator(frac.getNumerator() * rightSideMult);


        var added = new Fraction(
                this.numerator + frac.getNumerator(),
                denGCM
        );
        added.simplify();

        return added;
    }
}
