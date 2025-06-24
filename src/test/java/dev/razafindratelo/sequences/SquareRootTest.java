package dev.razafindratelo.sequences;

import dev.razafindratelo.ExtractData;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.math.MathContext;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Number of tests: 7 Number of Success test: 7 Execution time: 5 min 20 ms for all test combined in one run (might be
 * less than that according to computer's power)
 */
class SquareRootTest {

    /**
     * Duration: 226 ms
     */
    @Test
    void test_square_root_of_1() {
        var subject = SquareRoot.of(1);
        String expected = "1";

        MathContext precision = new MathContext(0);

        assertEquals(expected,subject.kThValue(0).getValue(precision).toString());
    }

    /**
     * Duration: 4min 02s
     */
    @Test
    void test_the_square_root_of_2_with__6_000_000__decimals_places_for_k_eq_23() throws IOException {
        var subject = SquareRoot.of(2);

        final int lengthPrecision = 6_000_002;
        MathContext precision = new MathContext(lengthPrecision + 4);

        String expected = ExtractData.extract("data/sqrt_2.txt");
        String actual = subject.kThValue(23).getValue(precision).toString().substring(0,lengthPrecision);

        assertEquals(expected,actual);
    }

    /**
     * Duration: 16s 798ms
     */
    @Test
    void test_the_square_root_of_3_with__1_000_000__decimals_places_for_k_eq_20() throws IOException {
        var subject = SquareRoot.of(3);

        final int lengthPrecision = 1_000_002;
        MathContext precision = new MathContext(lengthPrecision);

        String expected = ExtractData.extract("data/sqrt_3.txt");
        String actual = subject.kThValue(20).getValue(precision).toString().substring(0,lengthPrecision);

        assertEquals(expected,actual);
    }

    /**
     * Duration: 1 ms
     */
    @Test
    void test_the_square_root_of_4() {
        var subject = SquareRoot.of(4);
        String expected = "2";

        MathContext precision = new MathContext(0);
        String actual = subject.kThValue(0).getValue(precision).toString();

        assertEquals(expected,actual);
    }

    /**
     * Duration: 28s 640ms
     */
    @Test
    void test_the_square_root_of_5_with__1_000_000__decimals_places_for_k_eq_21() throws IOException {
        var subject = SquareRoot.of(5);

        final int lengthPrecision = 1_000_002;
        MathContext precision = new MathContext(lengthPrecision);

        String expected = ExtractData.extract("data/sqrt_5.txt");
        String actual = subject.kThValue(21).getValue(precision).toString().substring(0,lengthPrecision);

        assertEquals(expected,actual);
    }

    /**
     * Duration: 15s 597ms
     */
    @Test
    void test_the_square_root_of_6_with__1_000_000__decimals_places_for_k_eq_20() throws IOException {
        var subject = SquareRoot.of(6);

        final int lengthPrecision = 1_000_002;
        MathContext precision = new MathContext(lengthPrecision);

        String expected = ExtractData.extract("data/sqrt_6.txt");
        String actual = subject.kThValue(20).getValue(precision).toString().substring(0,lengthPrecision);

        assertEquals(expected,actual);
    }

    /**
     * Duration: 17s 797ms
     */
    @Test
    void test_the_square_root_of_7_with__1_000_000__decimals_places_for_k_eq_20() throws IOException {
        var sqrt7 = SquareRoot.of(7);

        final int lengthPrecision = 1_000_002;
        MathContext precision = new MathContext(lengthPrecision);

        String expected = ExtractData.extract("data/sqrt_7.txt");
        String actual = sqrt7.kThValue(20).getValue(precision).toString().substring(0,lengthPrecision);

        assertEquals(expected,actual);
    }
}
