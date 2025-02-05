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
        long numerator = new Random().nextLong();
        long denominator = 0;

        assertThrows(IllegalArgumentException.class, () -> new Fraction(numerator, denominator));
    }

    /**
     *  TEST RANDOM FRACTION
     */
    @Test
    void get_a_random_valid_fraction() {
        long i = 0;

        while(i < 1_000_000) {
            Fraction frac = Fraction.random(-99999, 999999);
            assertNotEquals(0, frac.getDenominator());
            i++;
        }
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

    @Test
    void simplify_AND_normalize() {
        Fraction frac = new Fraction(-5, -15);

        frac.simplify();

        assertEquals(new Fraction(1, 3), frac);
    }

    /**
     *  TEST NORMALIZE FRACTION METHOD
     */

    @Test
    void normalize_minus_1_over_minus_5() {
        Fraction fraction = new Fraction(-1, -5);

        Fraction expected = new Fraction(1, 5);

        fraction.normalize();

        assertEquals(expected, fraction);
    }

    @Test
    void normalize_1_over_minus_5() {
        Fraction fraction = new Fraction(1, -5);

        Fraction expected = new Fraction(-1, 5);

        fraction.normalize();

        assertEquals(expected, fraction);
    }

    @Test
    void normalize_a_normalized_fraction() {
        Fraction frac = new Fraction(1, 2);

        frac.normalize();

        assertEquals(new Fraction(1, 2), frac);
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

        Fraction actual = fraction1.inverse();

        assertEquals(expected, actual);
    }

    @Test
    void inverse_3_half() {
        Fraction fraction1 = new Fraction(3, 2);

        Fraction expected = new Fraction(2, 3);

        Fraction actual = fraction1.inverse();

        assertEquals(expected, actual);
    }

    @Test
    void can_not_inverse_zero_over_any_denominator() {
        Fraction fraction = new Fraction(0, new Random().nextLong());

        assertThrows(IllegalArgumentException.class, fraction::inverse);

    }

    /**
     *  TEST MULTIPLICATION FRACTION METHOD
     */
    @Test
    void multiply_1_half_by_1_half() {
        Fraction fraction1 = new Fraction(1, 2);

        Fraction expected = new Fraction(1, 4);

        Fraction actual = fraction1.multiply(fraction1);

        assertEquals(expected, actual);
    }

    @Test
    void multiply_1_half_by_1_seventh() {
        Fraction fraction1 = new Fraction(1, 7);
        Fraction fraction2 = new Fraction(1, 2);

        Fraction expected = new Fraction(1, 14);

        Fraction actual = fraction1.multiply(fraction2);
        Fraction actual2 = fraction2.multiply(fraction1);

        assertEquals(expected, actual);
        assertEquals(expected, actual2);
    }

    @Test
    void multiply_2_third_its_inverse() {
        Fraction fraction1 = new Fraction(2, 3);
        Fraction fraction2 = new Fraction(3, 2);


        Fraction expected = new Fraction(1, 1);

        Fraction actual = fraction1.multiply(fraction2);
        Fraction actual2 = fraction2.multiply(fraction1);

        assertEquals(expected, actual);
        assertEquals(expected, actual2);
    }

    /**
     *  TEST DIVIDE FRACTION METHOD
     */

    @Test
    void divide_any_fraction_by_itself() {

        Fraction fraction1 = Fraction.random(-999999, 999999);

        Fraction expected = new Fraction(1, 1);

        assertEquals(expected, fraction1.divide(fraction1));
    }

    @Test
    void divide_1_seventh_by_8_seventh() {
        Fraction fraction1 = new Fraction(1, 7);
        Fraction fraction2 = new Fraction(8, 7);

        Fraction expected = new Fraction(1, 8);

        assertEquals(expected, fraction1.divide(fraction2));
    }

    @Test
    void divide_20_fourth_by_3_twelveth() {

        Fraction fraction1 = new Fraction(20, 4);
        Fraction fraction2 = new Fraction(3, 12);

        Fraction expected = new Fraction(20, 1);

        assertEquals(expected, fraction1.divide(fraction2));
    }

    @Test
    void can_not_divide_any_fraction_by_a_zero_numerator_fraction() {
        Fraction any = Fraction.random(-99999, 99999);
        Fraction zero_num_frac = new Fraction (0, 142);

        assertThrows(IllegalArgumentException.class, () -> any.divide(zero_num_frac));
    }

    /**
     *  TEST OPPOSITE FRACTION METHOD
     */
    @Test
    void opposite_of_minus_one_half() {
        Fraction frac = new Fraction(1, 2);

        Fraction expected = new Fraction(-1, 2);

        Fraction actual = frac.opposite();

        assertEquals(expected, actual);
    }

    @Test
    void opposite_of_two_over_minus_four() {
        Fraction frac = new Fraction(2, -4);

        Fraction expected = new Fraction(1, 2);

        Fraction actual = frac.opposite();

        assertEquals(expected, actual);
    }

    @Test
    void opposite_of_minus_three_over_minus_four() {
        Fraction frac = new Fraction(-3, -4);

        Fraction expected = new Fraction(-3, 4);

        Fraction actual = frac.opposite();

        assertEquals(expected, actual);
    }

    /**
     *  TEST ABS FRACTION METHOD
     */

    @Test
    void get_absolute_value_of_one_over_minus_four() {
        Fraction frac = new Fraction(1, -4);
        
        Fraction expected = new Fraction(1, 4);

        Fraction actual = frac.abs();

        assertEquals(expected, actual);
    }

    @Test
    void get_absolute_value_of_minus_four_over_minus_five() {
        Fraction frac = new Fraction(-4, -5);

        Fraction expected = new Fraction(4, 5);

        Fraction actual = frac.abs();

        assertEquals(expected, actual);
    }

    @Test
    void get_absolute_value_of_positive_fraction() {
        Fraction frac = new Fraction(14263, 845164956);

        Fraction actual = frac.abs();

        assertEquals(frac, actual);
    }

    /**
     *  TEST TO_THE_POWER_OF FRACTION METHOD
     */

    @Test
    void get_random_fraction_to_the_power_of_zero() {
        Fraction frac = Fraction.random(-999999, 999999);

        Fraction expected = new Fraction(1, 1);

        Fraction actual = frac.toThePowerOf(0);

        assertEquals(expected, actual);
    }

    @Test
    void get_random_fraction_to_the_power_of_ONE() {
        Fraction frac = Fraction.random(-9999, 9999999);

        Fraction actual = frac.toThePowerOf(1);

        assertEquals(frac, actual);
    }

    @Test
    void get_one_half_to_the_power_of_4() {
        Fraction frac = new Fraction(1, 2);

        Fraction expected = new Fraction(1, 16);

        Fraction actual = frac.toThePowerOf(4);

        assertEquals(expected, actual);
    }

    @Test
    void get_two_eighth_to_the_power_of_2() {
        Fraction frac = new Fraction(2, 4);

        Fraction expected = new Fraction(1, 4);

        Fraction actual = frac.toThePowerOf(2);

        assertEquals(expected, actual);
    }
    @Test
    void get_one_half_to_the_power_of_minus_one() {
        Fraction frac = new Fraction(1, 2);

        Fraction expected = frac.inverse();

        Fraction actual = frac.toThePowerOf(-1);

        assertEquals(expected, actual);
    }

    @Test
    void get_two_eighth_to_the_power_of_minus_two() {
        Fraction frac = new Fraction(6, 24);

        Fraction expected = new Fraction(16, 1);

        Fraction actual = frac.toThePowerOf(-2);

        assertEquals(expected, actual);
    }

    @Test
    void get_random_positive_power_of_a_random_fraction() {
        Fraction frac = Fraction.random(1, 20);

        long pow = new Random().nextLong(0, 10);

        long num = (long) Math.pow(frac.getNumerator(), pow);
        long den = (long) Math.pow(frac.getDenominator(), pow);

        Fraction expected = new Fraction(num, den);

        Fraction actual = frac.toThePowerOf(pow);

        assertEquals(expected, actual);

    }

}