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
    private long numerator;
    private long denominator;
    public static Fraction ZERO = new Fraction(0, 1);
    public static Fraction ONE = new Fraction(1, 1);


    public Fraction(long numerator, long denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator must be non-zero");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction(long n) {
        this.numerator = n;
        this.denominator = 1;
    }

    public static Fraction random(long from, long to) {
        Random random = new Random();

        long num = random.nextLong(from, to + 1 );
        long den = random.nextLong(from, to + 1);

        while (den == 0) {
            den = random.nextLong(from, to + 1);
        }
        return new Fraction(num, den);
    }

    public double getValue() {
        return (double) this.numerator / this.denominator;
    }

    public void normalize() {
        long num = numerator;
        long den = denominator;

        if ((numerator < 0 && denominator < 0) || (numerator > 0 && denominator < 0)) {
            this.numerator = -num;
            this.denominator = -den;
        }
    }

    public void simplify() {
        long gcd = Z.gcd(numerator, denominator);

        numerator /= gcd;
        denominator /= gcd;

        this.normalize();
    }

    @Override
    public Fraction add(Fraction frac) {
        long denGCM = Z.gcm(denominator, frac.getDenominator());

        long leftSideMult = denGCM / this.denominator;
        long rightSideMult = denGCM /frac.denominator;


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

    public Fraction add(long n) {
        Fraction frac = new Fraction(n);
        Fraction added = this.add(frac);

        added.simplify();

        return added;
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

    public Fraction multiply(long n) {
        Fraction frac = new Fraction(n);
        Fraction multiplied = this.multiply(frac);

        multiplied.simplify();
        return multiplied;
    }

    @Override
    public Fraction inverse() {
        long num = this.denominator;
        long den = this.numerator;

        return new Fraction(num, den);
    }

    @Override
    public Fraction divide(Fraction f) {
        return this.multiply(f.inverse());
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

        Fraction result = new Fraction(
                this.numerator < 0 ?  - this.numerator : this.numerator,
                this.denominator
        );
        result.simplify();

        return result;
    }

    public Fraction toThePowerOf(long n) {
        this.simplify();

        if (n == 0) {
            return new Fraction(1, 1);

        } else if (n >= 1) {
            Fraction result = this;

            for (long i = 1; i < n; i++) {
                result = result.multiply(this);
            }

            result.simplify();

            return result;

        } else {
            Fraction result = this.inverse();
            for (long i = 1; i < -n; i++) {
                result = result.multiply(this.inverse());
            }
            result.simplify();

            return result;
        }
    }
}
