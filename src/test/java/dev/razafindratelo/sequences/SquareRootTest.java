package dev.razafindratelo.sequences;

import dev.razafindratelo.tools.ExtractData;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.math.MathContext;
import static org.junit.jupiter.api.Assertions.*;

/**
 *  Number of test: 7
 *  Number of Success test: 7
 *  All tests has exactly 1×10⁶ (One million) decimal places
 *  Execution time: 1 min 43 ms for all test combined in one run (might be less than that according to computer's power)
 */
class SquareRootTest {

    @Test
    public void hello() {

    }

    /**
     * Duration: 256 ms
     */
    @Test
    void test_square_root_of_1() {
        var subject = new SquareRoot(1);
        String expected = "1";

        MathContext precision = new MathContext(0);
        String actual = subject.kThValue(0).getValue(precision).toString();

        assertEquals(expected, actual);
    }

    /**
     * Duration: 4min 40ms
     */
    @Test
    void test_the_square_root_of_2_with__1_00_000__decimals_places_for_k_eq_21() throws IOException {
        var subject = new SquareRoot(2);

        String expected = ExtractData.extract("datas/sqrt_2.txt");

        MathContext precision = new MathContext(6_000_006);
        String actual = subject.kThValue(23).getValue(precision).toString().substring(0, 6_000_002);

        assertEquals(expected, actual);
    }

    /**
     * Duration: 16s 798ms
     */
    @Test
    void test_the_square_root_of_3_with__1_00_000__decimals_places_for_k_eq_20() throws IOException {
        var subject = new SquareRoot(3);
        String expected = ExtractData.extract("datas/sqrt_3.txt");

        MathContext precision = new MathContext(1_000_002);
        String actual = subject.kThValue(20).getValue(precision).toString().substring(0, 1_000_002);

        assertEquals(expected, actual);

    }

    /**
     * Duration: 1 ms
     */
    @Test
    void test_the_square_root_of_4() {
        var subject = new SquareRoot(4);
        String expected = "2";

        MathContext precision = new MathContext(0);
        String actual = subject.kThValue(0).getValue(precision).toString();

        assertEquals(expected, actual);
    }

    /**
     * Duration: 28s 640ms
     */
    @Test
    void test_the_square_root_of_5_with__1_00_000__decimals_places_for_k_eq_21() throws IOException {
        var subject = new SquareRoot(5);
        String expected = ExtractData.extract("datas/sqrt_5.txt");

        MathContext precision = new MathContext(1_000_002);
        String actual = subject.kThValue(21).getValue(precision).toString().substring(0, 1_000_002);

        assertEquals(expected, actual);
    }

    /**
     * Duration: 15s 597ms
     */
    @Test
    void test_the_square_root_of_6_with__1_00_000__decimals_places_for_k_eq_20() throws IOException {
        var subject = new SquareRoot(6);
        String expected = ExtractData.extract("datas/sqrt_6.txt");

        MathContext precision = new MathContext(1_000_002);
        String actual = subject.kThValue(20).getValue(precision).toString().substring(0, 1_000_002);

        assertEquals(expected, actual);
    }

    /**
     * Duration: 17s 797ms
     */
    @Test
    void test_the_square_root_of_7_with__1_00_000__decimals_places_for_k_eq_20() throws IOException {
        var sqrt7 = new SquareRoot(7);
        String expected = ExtractData.extract("datas/sqrt_7.txt");

        MathContext precision = new MathContext(1_000_002);
        String actual = sqrt7.kThValue(20).getValue(precision).toString().substring(0, 1_000_002);
        assertEquals(expected, actual);
    }
}