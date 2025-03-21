package dev.razafindratelo.sequences;

import dev.razafindratelo.tools.ExtractData;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import static org.junit.jupiter.api.Assertions.*;

/**
 *  Number of test = 8
 *  Number of Success test = 8
 *  Execution time = 2 s 202 ms for all test combined in one run
 */
class SquareRootTest {

    @Test
    void test_square_root_of_1() {
        var subject = new SquareRoot(1);
        String expected = "1";

        MathContext precision = new MathContext(0);
        String actual = subject.kThValue(0).getValue(precision).toString();

        assertEquals(expected, actual);
    }

    @Test
    void test_the_square_root_of_2_with_20_000_decimals_for_k_eq_15() throws IOException {
        var subject = new SquareRoot(2);

        String expected = ExtractData.extract("datas/sqrt_2.txt");

        MathContext precision = new MathContext(20_002);
        String actual = subject.kThValue(15).getValue(precision).toString().substring(0, 20_002);


        assertEquals(expected, actual);

    }

    @Test
    void test_the_square_root_of_3_with_20_000_decimals_for_k_eq_15() throws IOException {
        var subject = new SquareRoot(3);
        String expected = ExtractData.extract("datas/sqrt_3.txt");

        MathContext precision = new MathContext(20_002);
        String actual = subject.kThValue(15).getValue(precision).toString().substring(0, 20_002);

        assertEquals(expected, actual);

    }

    @Test
    void test_the_square_root_of_4() {
        var subject = new SquareRoot(4);
        String expected = "2";

        MathContext precision = new MathContext(0);
        String actual = subject.kThValue(0).getValue(precision).toString();

        assertEquals(expected, actual);
    }

    @Test
    void test_the_square_root_of_5_with_20_001_decimals_for_k_eq_15() throws IOException {
        var subject = new SquareRoot(5);
        String expected = ExtractData.extract("datas/sqrt_5.txt");

        MathContext precision = new MathContext(20_002);
        String actual = subject.kThValue(15).getValue(precision).toString().substring(0,20_002);

        assertEquals(expected, actual);
    }

    @Test
    void test_the_square_root_of_6_with_20_000_decimals_for_k_eq_15() throws IOException {
        var subject = new SquareRoot(6);
        String expected = ExtractData.extract("datas/sqrt_6.txt");

        MathContext precision = new MathContext(20_002);
        String actual = subject.kThValue(15).getValue(precision).toString().substring(0, 20_002);

        assertEquals(expected, actual);
    }

    @Test
    void test_the_square_root_of_7_with_20_000_decimals_for_k_eq_15() throws IOException {
        var sqrt7 = new SquareRoot(7);
        String expected = ExtractData.extract("datas/sqrt_7.txt");

        MathContext precision = new MathContext(20_002);
        String actual = sqrt7.kThValue(15).getValue(precision).toString().substring(0, 20_002);
        assertEquals(expected, actual);
    }

    @Test
    void test_golden_ratio_decimals_with_20_000_decimals_for_k_eq_15() throws IOException {
        var SQRT5 = new SquareRoot(5);
        String expected = ExtractData.extract("datas/golden_ratio.txt");

        MathContext precision = new MathContext(20_002);
        BigDecimal sqrt5 = SQRT5.kThValue(15).getValue(precision);
        String actual = BigDecimal.valueOf(1).add(sqrt5).divide(BigDecimal.valueOf(2), new MathContext(20_002))
                .toString().substring(0, 20_002);

        assertEquals(expected, actual);

    }
}