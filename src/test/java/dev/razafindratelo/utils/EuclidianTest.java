package dev.razafindratelo.utils;

import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class EuclidianTest {

    @Test
    void euclidian_division_of_zero_and_zero() {
        Map<String, NaturalNumber> expected = Map.of("a", 0, "b", 0, "q", 0, "r", 0);

        var actual = Euclidian.division(0, 0);

        assertEquals(expected, actual);
    }

    @Test
    void euclidian_division_of_a_non_zero_by_zero() {
        Map<String, NaturalNumber> expected = Map.of("a", 4, "b", 0, "q", 0, "r", 4);

        var actual = Euclidian.division(4, 0);

        assertEquals(expected, actual);
    }

    @Test
    void euclidian_division_of_a_zero_by_non_zero() {
        Map<String, NaturalNumber> expected = Map.of("a", 0, "b", 21, "q", 0, "r", 0);

        var actual = Euclidian.division(0, 21);

        assertEquals(expected, actual);
    }

    @Test
    void euclidian_division_of_non_zero_by_non_zero() {
        Map<String, NaturalNumber> expected_1 = Map.of("a", 54, "b", 23, "q", 2, "r", 8);
        Map<String, NaturalNumber> expected_2 = Map.of("a", 23, "b", 54, "q", 0, "r", 23);

        var actual_1 = Euclidian.division(54, 23);
        var actual_2 = Euclidian.division(23, 54);


        assertEquals(expected_1, actual_1);
        assertEquals(expected_2, actual_2);
    }

    @Test
    void euclidian_division_of_negative_number() {
        Map<String, NaturalNumber> expected = Map.of("a", -23, "b", 14, "q", -2, "r", 5);

        var actual = Euclidian.division(-23, 14);

        assertEquals(expected, actual);
    }

    @Test
    void euclidian_division_of_negative_number_2() {
        Map<String, NaturalNumber> expected = Map.of("a", -23, "b", -14, "q", 2, "r", 5);

        var actual = Euclidian.division(-23, -14);

        assertEquals(expected, actual);
    }

    @Test
    void euclidian_division_of_negative_number_3() {
        Map<String, NaturalNumber> expected = Map.of("a", 23, "b", -14, "q", -1, "r", 9);

        var actual = Euclidian.division(23, -14);

        assertEquals(expected, actual);
    }
}