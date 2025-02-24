package dev.razafindratelo.tools;

import dev.razafindratelo.utils.EuclideanUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.Objects;
import java.util.Random;

@Data
@ToString
@EqualsAndHashCode
public class Fraction {
    private BigInteger numerator;
    private BigInteger denominator;
    public static Fraction ZERO = new Fraction(0, 1);
    public static Fraction ONE = new Fraction(1, 1);

    /**
     *
     *  ==========================  FRACTION CONSTRUCTORS ==========================
     *
     */

    public Fraction(long numerator, long denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator must be non-zero");
        }
        this.numerator = BigInteger.valueOf(numerator);
        this.denominator = BigInteger.valueOf(denominator);
    }

    public Fraction(BigInteger numerator, BigInteger denominator) {
        if (Objects.equals(denominator, BigInteger.ZERO)) {
            throw new IllegalArgumentException("Denominator must be non-zero");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction(long n) {
        this.numerator = BigInteger.valueOf(n);
        this.denominator = BigInteger.ONE;
    }

    public static Fraction random(long from, long to) {
        Random random = new Random();

        BigInteger num = BigInteger.valueOf(random.nextLong(from, to + 1 ));

        BigInteger den = BigInteger.valueOf(random.nextLong(from, to + 1));

        while (den.equals(BigInteger.ZERO)) {
            den = BigInteger.valueOf(random.nextLong(from, to + 1));
        }
        return new Fraction(num, den);
    }


    /**
     *
     *  ==========================  FRACTION METHODS ==========================
     *
     */

    public BigDecimal getValue() {
        return new BigDecimal(this.numerator).divide(new BigDecimal(this.denominator), new MathContext(10_002));
    }

    public void normalize() {
        BigInteger ZERO = BigInteger.ZERO;
        BigInteger num = numerator;
        BigInteger den = denominator;

        boolean isDenominatorNegative = den.max(ZERO).equals(ZERO);
        boolean isNumeratorNegative = num.max(ZERO).equals(ZERO);

        if (isNumeratorNegative && isDenominatorNegative) {
            this.numerator = num.abs();
            this.denominator = den.abs();

        } else if (!isNumeratorNegative && isDenominatorNegative) {
            this.numerator = num.multiply(BigInteger.valueOf(-1));
            this.denominator = den.abs();
        }
    }

    public void simplify() {
        BigInteger gcd = numerator.gcd(denominator);

        numerator = numerator.divide(gcd);
        denominator = denominator.divide(gcd);

        this.normalize();
    }

    public Fraction add(Fraction frac) {
        BigInteger denGCM = EuclideanUtils.gcm(denominator, frac.getDenominator());

        BigInteger leftSideMult = denGCM.divide(this.denominator);
        BigInteger rightSideMult = denGCM.divide(frac.getDenominator());

        this.denominator = denominator.multiply(leftSideMult);
        this.numerator = numerator.multiply(leftSideMult);

        frac.setDenominator(frac.getDenominator().multiply(rightSideMult));
        frac.setNumerator(frac.getNumerator().multiply(rightSideMult));

        var added = new Fraction(
                this.numerator.add(frac.getNumerator()),
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

    public Fraction multiply(Fraction f) {
        Fraction product = new Fraction(
                this.numerator.multiply(f.getNumerator()),
                this.denominator.multiply(f.getDenominator())
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

    public Fraction inverse() {
        BigInteger num = this.denominator;
        BigInteger den = this.numerator;

        return new Fraction(num, den);
    }

    public Fraction divide(Fraction f) {
        return this.multiply(f.inverse());
    }

    public Fraction opposite() {
        this.simplify();

        return new Fraction(
                this.numerator.multiply(BigInteger.valueOf(-1)),
                this.denominator
        );
    }

    public Fraction abs() {
        this.normalize();

        Fraction result = new Fraction(
                this.numerator.max(BigInteger.ZERO).equals(BigInteger.ZERO) ?
                        this.numerator.multiply(BigInteger.valueOf(-1)) : this.numerator,
                this.denominator
        );
        result.simplify();

        return result;
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
