package dev.razafindratelo.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NaturalNumberTest {

    @Test
    void gcd_of_positive_integer_and_1() {
        int gcd = 1;

        int actual_1 = NaturalNumber.gcd(125, 1);
        int actual_2 = NaturalNumber.gcd(1, 125);

        assertEquals(gcd, actual_1);
        assertEquals(gcd, actual_2);
    }

    @Test
    void gcd_of_negative_integer_and_1() {
        int gcd = 1;

        int actual_1 = NaturalNumber.gcd(-11, 1);
        int actual_2 = NaturalNumber.gcd(1, -11);

        assertEquals(gcd, actual_1);
        assertEquals(gcd, actual_2);
    }

    @Test
    void gcd_of_a_multiple_of_a_positive_integer() {
        int gcd = 5;

        int actual_1 = NaturalNumber.gcd(5, 125);
        int actual_2 = NaturalNumber.gcd(125, 5);

        assertEquals(gcd, actual_1);
        assertEquals(gcd, actual_2);
    }

    @Test
    void gcd_of_some_random_numbers() {
        int gcd_1 = 7;
        int gcd_2 = 8;
        int gcd_3 = 1;

        int actual_1_1 = NaturalNumber.gcd(49, 14);
        int actual_1_2 = NaturalNumber.gcd(14, 49);

        int actual_2_1 = NaturalNumber.gcd(16, 24);
        int actual_2_2 = NaturalNumber.gcd(24, 16);

        int actual_3_1 = NaturalNumber.gcd(31, 32);
        int actual_3_2 = NaturalNumber.gcd(32, 1);

        int actual_4_1 = NaturalNumber.gcd(41, 11);
        int actual_4_2 = NaturalNumber.gcd(41, 11);

        int actual_5_1 = NaturalNumber.gcd(39, 2);
        int actual_5_2 = NaturalNumber.gcd(2, 39);


        assertEquals(gcd_1, actual_1_1);
        assertEquals(gcd_1, actual_1_2);

        assertEquals(gcd_2, actual_2_1);
        assertEquals(gcd_2, actual_2_2);

        assertEquals(gcd_3, actual_3_1);
        assertEquals(gcd_3, actual_3_2);

        assertEquals(gcd_3, actual_4_1);
        assertEquals(gcd_3, actual_4_2);

        assertEquals(gcd_3, actual_5_1);
        assertEquals(gcd_3, actual_5_2);
    }
}