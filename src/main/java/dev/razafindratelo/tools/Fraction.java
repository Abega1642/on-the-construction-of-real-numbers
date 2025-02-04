package dev.razafindratelo.tools;

import dev.razafindratelo.set.Q;
import dev.razafindratelo.set.Z;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Random;

@Data
@ToString
@EqualsAndHashCode
public class Fraction implements Tool, Q {
    private int numerator;
    private int denominator;


    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("denominator must be non-zero");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public static Fraction random() {
        Random random = new Random();

        int num = random.nextInt();
        int den = random.nextInt();

        while (den == 0) {
            den = random.nextInt();
        }
        return new Fraction(num, den);
    }

    public void simplify() {
        int gcd = Z.gcd(numerator, denominator);

        numerator /= gcd;
        denominator /= gcd;

        this.normalize();
    }

    public void normalize() {
        int num = numerator;
        int den = denominator;

        if ((numerator < 0 && denominator < 0) || (numerator > 0 && denominator < 0)) {
            this.numerator = -num;
            this.denominator = -den;
        }
    }

    @Override
    public Fraction add(Fraction frac) {
        int denGCM = Z.gcm(denominator, frac.getDenominator());

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

    @Override
    public Fraction inverse() {
        int num = this.denominator;
        int den = this.numerator;

        return new Fraction(num, den);
    }

    @Override
    public Fraction multiply(Fraction f) {
        Fraction product = new Fraction(
                this.numerator * f.getNumerator(),
                this.denominator * f.getDenominator()
        );

        product.simplify();

        return product;
    }

    @Override
    public Fraction opposite() {
        this.simplify();

        return new Fraction(
                -this.numerator,
                this.denominator
        );
    }

    @Override
    public Fraction abs() {
        this.normalize();

        return new Fraction(
                this.numerator < 0 ?  - this.numerator : this.numerator,
                this.denominator
        );

    }

    @Override
    public Fraction divide(Fraction f) {
        return this.multiply(f.inverse());
    }
}
