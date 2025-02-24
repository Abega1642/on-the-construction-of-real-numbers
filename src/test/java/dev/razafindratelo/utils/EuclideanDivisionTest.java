package dev.razafindratelo.utils;

import org.junit.jupiter.api.Test;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

class EuclidianTest {

    @Test
    void euclidian_division_of_zero_and_zero() {
        long expectedQuotient = 0;
        long expectedReminder = 0;

        Euclidian subject = new Euclidian(0, 0);
        long actualQuotient = subject.getQuotient();
        long actualReminder = subject.getReminder();

        assertEquals(expectedQuotient, actualQuotient);
        assertEquals(expectedReminder, actualReminder);
    }

    @Test
    void euclidian_division_of_a_non_zero_by_zero() {
        long expectedQuotient = 0;
        long expectedReminder = new Random().nextLong();

        Euclidian subject = new Euclidian(expectedReminder, 0);
        long actualQuotient = subject.getQuotient();
        long actualReminder = subject.getReminder();

        assertEquals(expectedQuotient, actualQuotient);
        assertEquals(expectedReminder, actualReminder);
    }

    @Test
    void euclidian_division_of_a_zero_by_random_integer() {
        long expectedQuotient = 0;
        long expectedReminder = 0;

        long randomValueForB = new Random().nextLong();
        Euclidian subject = new Euclidian(0, randomValueForB);
        long actualQuotient = subject.getQuotient();
        long actualReminder = subject.getReminder();

        assertEquals(expectedQuotient, actualQuotient);
        assertEquals(expectedReminder, actualReminder);
    }

    @Test
    void euclidian_division_of_54_by_23() {
        long expectedQuotient = 2;
        long expectedReminder = 8;


        Euclidian subject = new Euclidian(54, 23);
        long actualQuotient = subject.getQuotient();
        long actualReminder = subject.getReminder();


        assertEquals(expectedQuotient, actualQuotient);
        assertEquals(expectedReminder, actualReminder);

    }

    @Test
    void euclidian_division_of_23_by_54() {
        long expectedQuotient = 0;
        long expectedReminder = 23;

        Euclidian subject = new Euclidian(23, 54);
        long actualQuotient = subject.getQuotient();
        long actualReminder = subject.getReminder();

        assertEquals(expectedQuotient, actualQuotient);
        assertEquals(expectedReminder, actualReminder);

    }

    @Test
    void euclidian_division_of_minus23_by_14() {
        long expectedQuotient = -2;
        long expectedReminder = 5;

        Euclidian subject = new Euclidian(-23, 14);
        long actualQuotient = subject.getQuotient();
        long actualReminder = subject.getReminder();

        assertEquals(expectedQuotient, actualQuotient);
        assertEquals(expectedReminder, actualReminder);
    }

    @Test
    void euclidian_division_of_minus54_by_23() {
        long expectedQuotient = -2;
        long expectedReminder = 8;

        Euclidian subject = new Euclidian(54, -23);
        long actualQuotient = subject.getQuotient();
        long actualReminder = subject.getReminder();

        assertEquals(expectedQuotient, actualQuotient);
        assertEquals(expectedReminder, actualReminder);
    }

    @Test
    void euclidian_division_of_minus23_and_minus14() {
        long expectedQuotient = 2;
        long expectedReminder = 5;

        Euclidian subject = new Euclidian(-23, -14);
        long actualQuotient = subject.getQuotient();
        long actualReminder = subject.getReminder();

        assertEquals(expectedQuotient, actualQuotient);
        assertEquals(expectedReminder, actualReminder);
    }

    @Test
    void euclidian_division_of_23_and_minus14() {
        long expectedQuotient = -1;
        long expectedReminder = 9;

        Euclidian subject = new Euclidian(23, -14);
        long actualQuotient = subject.getQuotient();
        long actualReminder = subject.getReminder();

        assertEquals(expectedQuotient, actualQuotient);
        assertEquals(expectedReminder, actualReminder);
    }

    @Test
    void euclidian_division_of_minus11_by_2() {
        long expectedQuotient = -6;
        long expectedReminder = 1;

        Euclidian subject = new Euclidian(-11, 2);
        long actualQuotient = subject.getQuotient();
        long actualReminder = subject.getReminder();

        assertEquals(expectedQuotient, actualQuotient);
        assertEquals(expectedReminder, actualReminder);
    }

    @Test
    void euclidian_division_of_minus11_by_minus2() {
        long expectedQuotient = 6;
        long expectedReminder = 1;

        Euclidian subject = new Euclidian(-11, -2);
        long actualQuotient = subject.getQuotient();
        long actualReminder = subject.getReminder();

        assertEquals(expectedQuotient, actualQuotient);
        assertEquals(expectedReminder, actualReminder);
    }

    @Test
    void euclidian_division_of_11_by_minus2() {
        long expectedQuotient = -5;
        long expectedReminder = 1;

        Euclidian subject = new Euclidian(11, -2);
        long actualQuotient = subject.getQuotient();
        long actualReminder = subject.getReminder();

        assertEquals(expectedQuotient, actualQuotient);
        assertEquals(expectedReminder, actualReminder);
    }
}