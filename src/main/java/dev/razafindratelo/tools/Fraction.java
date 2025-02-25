package dev.razafindratelo.tools;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.Random;

@Data
@ToString
@EqualsAndHashCode
public class Fraction {
    public static Fraction ZERO = Fraction.valueOf(0, 1);
    public static Fraction ONE = Fraction.valueOf(1, 1);

    private BigInteger numerator;
    private BigInteger denominator;


    public Fraction(BigInteger numerator, BigInteger denominator) {
        if (denominator.equals(BigInteger.ZERO)) {
            throw new IllegalArgumentException("Denominator must be non-zero");
        }

        BigInteger gcd = numerator.gcd(denominator);
        numerator = numerator.divide(gcd);
        denominator = denominator.divide(gcd);

        if (denominator.signum() < 0) {
            numerator = numerator.negate();
            denominator = denominator.negate();
        }

        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     *
     *  ==========================  FRACTION STATIC FACTORY ==========================
     *
     */

    public static Fraction valueOf(long numerator, long denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator must be non-zero");
        }
        BigInteger num = BigInteger.valueOf(numerator);
        BigInteger den = BigInteger.valueOf(denominator);
        return new Fraction(num, den);
    }

    public static Fraction valueOf(long n) {
        BigInteger num = BigInteger.valueOf(n);
        BigInteger den = BigInteger.ONE;

        return new Fraction(num, den);
    }

    public static Fraction getRandom(long from, long to) {
        Random random = new Random();

        BigInteger num = BigInteger.valueOf(random.nextLong(from, to + 1 ));

        BigInteger den = BigInteger.valueOf(random.nextLong(from, to + 1));

        if (den.equals(BigInteger.ZERO)) {
            den = den.add(BigInteger.ONE);
        }
        return new Fraction(num, den);
    }

    /**
     *
     *  ==========================  FRACTION METHODS  ==========================
     *
     */

    public BigDecimal getValue() {
        return new BigDecimal(this.numerator)
                .divide(new BigDecimal(this.denominator), new MathContext(20_002));
    }

    public void simplify() {
        BigInteger gcd = numerator.gcd(denominator);

        numerator = numerator.divide(gcd);
        denominator = denominator.divide(gcd);
    }

    public Fraction add(Fraction f) {
        BigInteger newNumerator = this.numerator.multiply(f.denominator)
                .add(f.numerator.multiply(this.denominator));
        BigInteger newDenominator = this.denominator.multiply(f.denominator);
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction add(long n) {
        Fraction frac = Fraction.valueOf(n);
        Fraction added = this.add(frac);

        added.simplify();
        return added;
    }

    public Fraction multiply(Fraction f) {
        return new Fraction(
                this.numerator.multiply(f.numerator),
                this.denominator.multiply(f.denominator)
        );
    }

    public Fraction multiply(long n) {
        Fraction frac = Fraction.valueOf(n);
        Fraction multiplied = this.multiply(frac);

        multiplied.simplify();
        return multiplied;
    }

    public Fraction inverse() {
        return new Fraction(denominator, numerator);
    }

    public Fraction divide(Fraction f) {
        return this.multiply(f.inverse());
    }

    public Fraction opposite() {
        return new Fraction(numerator.negate(), denominator);
    }

    public Fraction abs() {
        return new Fraction(numerator.abs(), denominator);
    }

    public Fraction toThePowerOf(long n) {
        if (n == 0) {
            return Fraction.ONE;
        }
        
        long absValueOfN = Math.abs(n);
        Fraction base = (n < 0) ? this.inverse() : this;
        Fraction result = Fraction.ONE;

        while (absValueOfN > 0) {
            if (absValueOfN % 2 == 1) {
                result = result.multiply(base);
            }
            base = base.multiply(base);
            absValueOfN /= 2;
        }

        result.simplify();
        return result;
    }
}
