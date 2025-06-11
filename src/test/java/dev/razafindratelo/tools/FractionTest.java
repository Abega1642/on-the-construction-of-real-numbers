package dev.razafindratelo.tools;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Total number of test : 1,834 Number of success test : 1,834 Number of failed
 * test : 0 Execution time of all test : 1,214 s
 */
class FractionTest {

	/**
	 * TEST FRACTION CONSTRUCTOR
	 */

	@Test
	void can_not_have_zero_denominator() {
		long numerator = new Random().nextLong();
		long denominator = 0;

		assertThrows(IllegalArgumentException.class, () -> Fraction.valueOf(numerator, denominator));
	}

	/**
	 * TEST RANDOM FRACTION CONSTRUCTOR
	 */
	@RepeatedTest(1_000)
	void do_1_000_test_about_get_a_getRandom_valid_fraction() {
		Fraction actual = Fraction.getRandom(-99999, 999999);
		assertNotEquals(BigInteger.ZERO, actual.getDenominator());
	}

	/**
	 * TEST GET VALUE FRACTION METHOD
	 */

	@Test
	void get_value_of_one_half_() {
		Fraction subject = Fraction.valueOf(1, 2);

		BigDecimal expected = BigDecimal.valueOf(0.5);

		MathContext precision = new MathContext(2);
		BigDecimal actual = subject.getValue(precision);

		assertEquals(expected, actual);
	}

	@Test
	void get_value_of_one_fourth_() {
		Fraction subject = Fraction.valueOf(1, 4);

		BigDecimal expected = BigDecimal.valueOf(0.25);

		MathContext precision = new MathContext(2);
		BigDecimal actual = subject.getValue(precision);

		assertEquals(expected, actual);
	}

	/**
	 * TEST ADD FRACTION METHOD
	 */

	@Test
	void add_123456_over_654321_and_25852_over_85258() {
		Fraction subject1 = Fraction.valueOf(123456, 654321);
		Fraction subject2 = Fraction.valueOf(25852, 85258);

		Fraction actual = subject1.add(subject2);

		Fraction expected = Fraction.valueOf(4573519690L, 9297683303L);

		assertEquals(expected, actual);
	}

	@Test
	void add_987654321_over_123456789_and_321456987_over_789654123() {
		Fraction subject1 = Fraction.valueOf(987654321L, 123456789L);
		Fraction subject2 = Fraction.valueOf(321456987, 789654123);

		Fraction actual = subject1.add(subject2);

		Fraction expected = Fraction.valueOf(10118411778926546L, 1203557561064087L);
	}

	@Test
	void add_1_half_and_3_fourteenth() {
		Fraction expected = Fraction.valueOf(5, 7);

		Fraction subject1 = Fraction.valueOf(1, 2);
		Fraction subject2 = Fraction.valueOf(3, 14);

		Fraction actual = subject1.add(subject2);

		assertEquals(expected, actual);
	}

	@Test
	void add_1_half_and_1_seventh() {
		Fraction subject1 = Fraction.valueOf(1, 7);
		Fraction subject2 = Fraction.valueOf(1, 2);

		Fraction expected = Fraction.valueOf(9, 14);

		Fraction actual = subject1.add(subject2);

		assertEquals(expected, actual);
	}

	@Test
	void add_8_third_and_9_seventh() {
		Fraction subject1 = Fraction.valueOf(8, 3);
		Fraction subject2 = Fraction.valueOf(9, 7);

		Fraction expected = Fraction.valueOf(83, 21);

		Fraction actual = subject1.add(subject2);

		assertEquals(expected, actual);
	}

	/**
	 * TEST ADD TO A INTEGER FRACTION METHOD
	 */

	@Test
	void add_one_half_with_a_two() {
		Fraction expected = Fraction.valueOf(5, 2);

		long num = 2L;
		Fraction subject = Fraction.valueOf(1, 2);

		Fraction actual = subject.add(num);

		assertEquals(expected, actual);
	}

	@Test
	void add_seven_half_with_a_eight() {
		Fraction expected = Fraction.valueOf(23, 2);

		long num = 8L;
		Fraction subject = Fraction.valueOf(7, 2);

		Fraction actual = subject.add(num);

		assertEquals(expected, actual);
	}

	@RepeatedTest(50)
	void add_getRandom_fraction_by_zero() {
		Fraction subject = Fraction.getRandom(-200, 200);

		Fraction actual = subject.add(0L);

		assertEquals(subject, actual);
	}

	/**
	 * TEST INVERSE FRACTION METHOD
	 */

	@Test
	void inverse_1_half() {
		Fraction subject = Fraction.valueOf(1, 2);

		Fraction expected = Fraction.valueOf(2, 1);

		Fraction actual = subject.inverse();

		assertEquals(expected, actual);
	}

	@Test
	void inverse_3_half() {
		Fraction fraction1 = Fraction.valueOf(3, 2);

		Fraction expected = Fraction.valueOf(2, 3);

		Fraction actual = fraction1.inverse();

		assertEquals(expected, actual);
	}

	@Test
	void can_not_inverse_zero_over_any_denominator() {
		Fraction fraction = Fraction.valueOf(0, new Random().nextLong());

		assertThrows(IllegalArgumentException.class, fraction::inverse);

	}

	/**
	 * TEST MULTIPLY FRACTION METHOD
	 */
	@Test
	void multiply_1_half_by_1_half() {
		Fraction fraction1 = Fraction.valueOf(1, 2);

		Fraction expected = Fraction.valueOf(1, 4);

		Fraction actual = fraction1.multiply(fraction1);

		assertEquals(expected, actual);
	}

	@Test
	void multiply_1_half_by_1_seventh() {
		Fraction fraction1 = Fraction.valueOf(1, 7);
		Fraction fraction2 = Fraction.valueOf(1, 2);

		Fraction expected = Fraction.valueOf(1, 14);

		Fraction actual = fraction1.multiply(fraction2);
		Fraction actual2 = fraction2.multiply(fraction1);

		assertEquals(expected, actual);
		assertEquals(expected, actual2);
	}

	@Test
	void multiply_2_third_its_inverse() {
		Fraction fraction1 = Fraction.valueOf(2, 3);
		Fraction fraction2 = Fraction.valueOf(3, 2);

		Fraction expected = Fraction.ONE;

		Fraction actual = fraction1.multiply(fraction2);
		Fraction actual2 = fraction2.multiply(fraction1);

		assertEquals(expected, actual);
		assertEquals(expected, actual2);
	}

	@RepeatedTest(50)
	void multiply_getRandom_fraction_by_zero_fraction() {
		Fraction subject = Fraction.getRandom(-200, 200);
		Fraction fraction = Fraction.valueOf(0, new Random().nextLong(-200, 200));

		Fraction actual = subject.multiply(fraction);

		Fraction expected = Fraction.ZERO;

		assertEquals(expected, actual);

	}

	/**
	 * TEST MULTIPLY TO INTEGER FRACTION METHOD
	 */

	@Test
	void multiply_one_half_by_two() {
		Fraction frac = Fraction.valueOf(1, 2);

		Fraction expected = Fraction.ONE;

		Fraction actual = frac.multiply(2);

		assertEquals(expected, actual);
	}

	@RepeatedTest(50)
	void multiply_getRandom_fraction_by_zero() {
		Fraction subject = Fraction.getRandom(-200, 200);

		Fraction expected = Fraction.ZERO;

		Fraction actual = subject.multiply(0);

		assertEquals(expected, actual);
	}

	/**
	 * TEST DIVIDE FRACTION METHOD
	 */

	@Test
	void divide_any_fraction_by_itself() {

		Fraction fraction1 = Fraction.getRandom(-999999, 999999);

		Fraction expected = Fraction.ONE;

		assertEquals(expected, fraction1.divide(fraction1));
	}

	@Test
	void divide_1_seventh_by_8_seventh() {
		Fraction fraction1 = Fraction.valueOf(1, 7);
		Fraction fraction2 = Fraction.valueOf(8, 7);

		Fraction expected = Fraction.valueOf(1, 8);

		assertEquals(expected, fraction1.divide(fraction2));
	}

	@Test
	void divide_20_fourth_by_3_twelveth() {

		Fraction fraction1 = Fraction.valueOf(20, 4);
		Fraction fraction2 = Fraction.valueOf(3, 12);

		Fraction expected = Fraction.valueOf(20, 1);

		assertEquals(expected, fraction1.divide(fraction2));
	}

	@Test
	void can_not_divide_any_fraction_by_a_zero_numerator_fraction() {
		Fraction any = Fraction.getRandom(-99999, 99999);
		Fraction zero_num_frac = Fraction.valueOf(0, 142);

		assertThrows(IllegalArgumentException.class, () -> any.divide(zero_num_frac));
	}

	/**
	 * TEST OPPOSITE FRACTION METHOD
	 */
	@Test
	void opposite_of_minus_one_half() {
		Fraction subject = Fraction.valueOf(1, 2);

		Fraction expected = Fraction.valueOf(-1, 2);

		Fraction actual = subject.opposite();

		assertEquals(expected, actual);
	}

	@Test
	void opposite_of_two_over_minus_four() {
		Fraction subject = Fraction.valueOf(2, -4);

		Fraction expected = Fraction.valueOf(1, 2);

		Fraction actual = subject.opposite();

		assertEquals(expected, actual);
	}

	@Test
	void opposite_of_minus_three_over_minus_four() {
		Fraction subject = Fraction.valueOf(-3, -4);

		Fraction expected = Fraction.valueOf(-3, 4);

		Fraction actual = subject.opposite();

		assertEquals(expected, actual);
	}

	/**
	 * TEST ABS FRACTION METHOD
	 */

	@Test
	void get_absolute_value_of_one_over_minus_four() {
		Fraction subject = Fraction.valueOf(1, -4);

		Fraction expected = Fraction.valueOf(1, 4);

		Fraction actual = subject.abs();

		assertEquals(expected, actual);
	}

	@Test
	void get_absolute_value_of_minus_four_over_minus_five() {
		Fraction subject = Fraction.valueOf(-4, -5);

		Fraction expected = Fraction.valueOf(4, 5);

		Fraction actual = subject.abs();

		assertEquals(expected, actual);
	}

	@RepeatedTest(50)
	void do_50_test_about_get_absolute_value_of_positive_fraction() {
		Fraction subject = Fraction.getRandom(0, 99999);

		Fraction actual = subject.abs();

		assertEquals(subject, actual);
	}

	/**
	 * TEST TO_THE_POWER_OF FRACTION METHOD
	 */

	@RepeatedTest(100)
	void do_100_test_about_get_getRandom_fraction_to_the_power_of_zero() {
		Fraction subject = Fraction.getRandom(-9999, 9999);

		Fraction expected = Fraction.ONE;

		Fraction actual = subject.toThePowerOf(0);

		assertEquals(expected, actual);

	}

	@RepeatedTest(500)
	void do_500_test_about_get_getRandom_fraction_to_the_power_of_ONE() {
		Fraction subject = Fraction.getRandom(-9999, 9999);

		Fraction actual = subject.toThePowerOf(1);

		assertEquals(subject, actual);
	}

	@Test
	void get_one_half_to_the_power_of_4() {
		Fraction subject = Fraction.valueOf(1, 2);

		Fraction expected = Fraction.valueOf(1, 16);

		Fraction actual = subject.toThePowerOf(4);

		assertEquals(expected, actual);
	}
	@Test
	void get_two_eighth_to_the_power_of_2() {
		Fraction subject = Fraction.valueOf(2, 4);

		Fraction expected = Fraction.valueOf(1, 4);

		Fraction actual = subject.toThePowerOf(2);

		assertEquals(expected, actual);
	}

	@Test
	void get_one_half_to_the_power_of_minus_one() {
		Fraction subject = Fraction.valueOf(1, 2);

		Fraction expected = subject.inverse();

		Fraction actual = subject.toThePowerOf(-1);

		assertEquals(expected, actual);
	}

	@Test
	void get_two_eighth_to_the_power_of_minus_two() {
		Fraction subject = Fraction.valueOf(6, 24);

		Fraction expected = Fraction.valueOf(16, 1);

		Fraction actual = subject.toThePowerOf(-2);

		assertEquals(expected, actual);
	}

	@Test
	void get_random_positive_power_of_a_getRandom_fraction() {
		Fraction subject = Fraction.getRandom(1, 20);

		int pow = new Random().nextInt(0, 10);

		BigInteger num = subject.getNumerator().pow(pow);
		BigInteger den = subject.getDenominator().pow(pow);

		Fraction expected = new Fraction(num, den);

		Fraction actual = subject.toThePowerOf(pow);

		assertEquals(expected, actual);
	}

	@Test
	void get_two_seventh_to_the_power_of_10() {
		Fraction expected = Fraction.valueOf(1024, 282_475_249);

		Fraction subject = Fraction.valueOf(2, 7);
		Fraction actual = subject.toThePowerOf(10);

		assertEquals(expected, actual);
	}

	@Test
	void get_three_fourth_to_the_power_of_minus7() {
		Fraction expected = Fraction.valueOf(16_384, 2_187);

		Fraction subject = Fraction.valueOf(3, 4);
		Fraction actual = subject.toThePowerOf(-7);

		assertEquals(expected, actual);
	}

	@Test
	void get_eleven_over_twelve_to_the_power_of_10() {

		BigInteger expectedNumerator = BigInteger.valueOf(25_937_424_601L);
		BigInteger expectedDenominator = BigInteger.valueOf(61_917_364_224L);
		Fraction expected = new Fraction(expectedNumerator, expectedDenominator);

		Fraction subject = Fraction.valueOf(11, 12);
		Fraction actual = subject.toThePowerOf(10);

		assertEquals(expected, actual);
	}

}