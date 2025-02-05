package dev.razafindratelo.utils;

import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class EuclidianTest {

    @Test
    void euclidian_division_of_zero_and_zero() {
        Map<String, Long> expected = Map.of("a", 0L, "b", 0L, "q", 0L, "r", 0L);

        var actual = Euclidian.division(0, 0);

        assertEquals(expected, actual);
    }

    @Test
    void euclidian_division_of_a_non_zero_by_zero() {
        Map<String, Long> expected = Map.of("a", 4L, "b", 0L, "q", 0L, "r", 4L);

        var actual = Euclidian.division(4, 0);

        assertEquals(expected, actual);
    }

    @Test
    void euclidian_division_of_a_zero_by_non_zero() {
        Map<String, Long> expected = Map.of("a", 0L, "b", 21L, "q", 0L, "r", 0L);

        var actual = Euclidian.division(0, 21);

        assertEquals(expected, actual);
    }

    @Test
    void euclidian_division_of_non_zero_by_non_zero() {
        Map<String, Long> expected_1 = Map.of("a", 54L, "b", 23L, "q", 2L, "r", 8L);
        Map<String, Long> expected_2 = Map.of("a", 23L, "b", 54L, "q", 0L, "r", 23L);

        var actual_1 = Euclidian.division(54, 23);
        var actual_2 = Euclidian.division(23, 54);


        assertEquals(expected_1, actual_1);
        assertEquals(expected_2, actual_2);
    }

    @Test
    void euclidian_division_of_negative_number() {
        Map<String, Long> expected = Map.of("a", -23L, "b", 14L, "q", -2L, "r", 5L);

        var actual = Euclidian.division(-23, 14);

        assertEquals(expected, actual);
    }

    @Test
    void euclidian_division_of_negative_number_2() {
        Map<String, Long> expected = Map.of("a", -23L, "b", -14L, "q", 2L, "r", 5L);

        var actual = Euclidian.division(-23, -14);

        assertEquals(expected, actual);
    }

    @Test
    void euclidian_division_of_negative_number_3() {
        Map<String, Long> expected = Map.of("a", 23L, "b", -14L, "q", -1L, "r", 9L);

        var actual = Euclidian.division(23, -14);

        assertEquals(expected, actual);
    }
}