package dev.razafindratelo.tools;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class FractionTest {

    /**
     *  TEST FRACTION CONSTRUCTOR
     */

    @Test
    void can_not_have_zero_denominator() {
        int numerator = new Random().nextInt();
        int denominator = 0;

        assertThrows(IllegalArgumentException.class, () -> new Fraction(4, denominator));
    }

    /**
     *  TEST SIMPLIFY FRACTION METHOD
     */

    @Test
    void simplify() {
        Fraction fraction = new Fraction(4, 8);

        fraction.simplify();

        assertEquals(new Fraction(1, 2), fraction);
    }

    @Test
    void simplify_2() {
        Fraction fraction = new Fraction(21, 7);

        fraction.simplify();

        assertEquals(new Fraction(3, 1), fraction);
    }

    /**
     *  TEST ADD FRACTION METHOD
     */

    @Test
    void add_1_half_and_3_fourteenth() {
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(3, 14);

        Fraction expected = new Fraction(5, 7);

        Fraction actual = fraction1.add(fraction2);

        assertEquals(expected, actual);
    }

    @Test
    void add_1_half_and_1_seventh() {
        Fraction fraction1 = new Fraction(1, 7);
        Fraction fraction2 = new Fraction(1, 2);

        Fraction expected = new Fraction(9, 14);

        Fraction actual = fraction1.add(fraction2);

        assertEquals(expected, actual);
    }

    @Test
    void add_8_third_and_9_seventh() {
        Fraction fraction1 = new Fraction(8, 3);
        Fraction fraction2 = new Fraction(9, 7);

        Fraction expected = new Fraction(83, 21);

        Fraction actual = fraction1.add(fraction2);

        assertEquals(expected, actual);
    }

    /**
     *  TEST INVERSE FRACTION METHOD
     */

    @Test
    void inverse_1_half() {
        Fraction fraction1 = new Fraction(1, 2);

        Fraction expected = new Fraction(2, 1);

        fraction1.inverse();

        assertEquals(expected, fraction1);
    }

    @Test
    void inverse_3_half() {
        Fraction fraction1 = new Fraction(3, 2);

        Fraction expected = new Fraction(2, 3);

        fraction1.inverse();

        assertEquals(expected, fraction1);
    }

}