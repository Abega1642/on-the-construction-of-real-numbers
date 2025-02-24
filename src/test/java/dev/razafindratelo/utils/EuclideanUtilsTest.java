package dev.razafindratelo.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EuclideanUtilsTest {

    @Test
    void gcd_of_positive_integer_and_1() {
        long gcd = 1;

        long actual_1 = EuclideanUtils.gcd(125, 1);
        long actual_2 = EuclideanUtils.gcd(1, 125);

        assertEquals(gcd, actual_1);
        assertEquals(gcd, actual_2);
    }

    @Test
    void gcd_of_negative_integer_and_1() {
        long gcd = 1;

        long actual_1 = EuclideanUtils.gcd(-11, 1);
        long actual_2 = EuclideanUtils.gcd(1, -11);

        assertEquals(gcd, actual_1);
        assertEquals(gcd, actual_2);
    }

    @Test
    void gcd_of_a_multiple_of_a_positive_integer() {
        long gcd = 5;

        long actual_1 = EuclideanUtils.gcd(5, 125);
        long actual_2 = EuclideanUtils.gcd(125, 5);

        assertEquals(gcd, actual_1);
        assertEquals(gcd, actual_2);
    }

    @Test
    void gcd_of_some_random_numbers() {
        long gcd_1 = 7;
        long gcd_2 = 8;
        long gcd_3 = 1;

        long actual_1_1 = EuclideanUtils.gcd(49, 14);
        long actual_1_2 = EuclideanUtils.gcd(14, 49);

        long actual_2_1 = EuclideanUtils.gcd(16, 24);
        long actual_2_2 = EuclideanUtils.gcd(24, 16);

        long actual_3_1 = EuclideanUtils.gcd(31, 32);
        long actual_3_2 = EuclideanUtils.gcd(32, 1);

        long actual_4_1 = EuclideanUtils.gcd(41, 11);
        long actual_4_2 = EuclideanUtils.gcd(41, 11);

        long actual_5_1 = EuclideanUtils.gcd(39, 2);
        long actual_5_2 = EuclideanUtils.gcd(2, 39);


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

    @Test
    void gcm_of_8_and_4() {
        long gcm = 8;

        long actual = EuclideanUtils.gcm(8, 4);
        long actual2 = EuclideanUtils.gcm(4, 8);

        assertEquals(gcm, actual);
        assertEquals(gcm, actual2);
    }

    @Test
    void gcm_of_124_and_1() {
        long gcm = 124;

        long actual = EuclideanUtils.gcm(124, 1);
        long actual2 = EuclideanUtils.gcm(1, 124);

        assertEquals(gcm, actual);
        assertEquals(gcm, actual2);
    }

    @Test
    void gcm_of_14_26() {
        long gcm = 2 * 7 * 13;

        long actual = EuclideanUtils.gcm(14, 26);
        long actual2 = EuclideanUtils.gcm(26, 14);

        assertEquals(gcm, actual);
        assertEquals(gcm, actual2);
    }

    @Test
    void gcm_of_28_26() {
        long gcm = 4 * 7 * 13;

        long actual = EuclideanUtils.gcm(28, 26);
        long actual2 = EuclideanUtils.gcm(26, 28);

        assertEquals(gcm, actual);
        assertEquals(gcm, actual2);
    }
}