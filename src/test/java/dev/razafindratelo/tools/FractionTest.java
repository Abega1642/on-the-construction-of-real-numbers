package dev.razafindratelo.tools;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class FractionTest {

    @Test
    void can_not_have_zero_denominator() {
        int numerator = new Random().nextInt();
        int denominator = 0;

        assertThrows(IllegalArgumentException.class, () -> new Fraction(4, denominator));
    }

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
}