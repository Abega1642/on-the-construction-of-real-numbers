package dev.razafindratelo.sequences;

import dev.razafindratelo.tools.ExtractData;
import dev.razafindratelo.tools.Fraction;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class SquareRootTest {

    @Test
    void test_square_root_of_1() {
        var SQ_1 = new SquareRoot(1);
        String expected = "1";
        String actual = SQ_1.sq_(1).getValue().toString();

        assertEquals(expected, actual);
    }

    @Test
    void test_the_square_root_of_2_with_10_001_decimals_for_k_eq_19() throws IOException {
        var SQ_2 = new SquareRoot(2);
        String expected = ExtractData.extract("datas/sqrt_2.txt");

        String actual = SQ_2.sq_(20).getValue().toString();

        assertEquals(expected, actual);

    }

    @Test
    void test_the_square_root_of_3_with_20_000_decimals_for_k_eq_20() throws IOException {
        var SQ_3 = new SquareRoot(3);
        String expected = ExtractData.extract("datas/sqrt_3.txt").substring(0, 20_000);

        String actual = SQ_3.sq_(20).getValue().toString().substring(0, 20_000);

        System.out.println(actual);
        assertEquals(expected, actual);

    }

    @Test
    void test_the_square_root_of_4() {
        var SQ_4 = new SquareRoot(4);
        String expected = "2";

        String actual = SQ_4.sq_(2).getValue().toString();

        assertEquals(expected, actual);
    }

    @Test
    void test_the_square_root_of_5_with_20_001_decimals_for_k_eq_20() throws IOException {
        var SQ_5 = new SquareRoot(5);
        String expected = ExtractData.extract("datas/sqrt_5.txt");

        String actual = SQ_5.sq_(20).getValue().toString();

        assertEquals(expected, actual);
    }

    @Test
    void test_the_square_root_of_6_with_20_000_decimals_for_k_eq_20() throws IOException {
        var SQ_6 = new SquareRoot(6);
        String expected = ExtractData.extract("datas/sqrt_6.txt");

        String actual = SQ_6.sq_(20).getValue().toString().substring(0, 20_000);
        assertEquals(expected, actual);
    }

    @Test
    void test_the_square_root_of_7_with_20_000_decimals_for_k_eq_20() throws IOException {
        var SQ_7 = new SquareRoot(7);
        String expected = ExtractData.extract("datas/sqrt_7.txt").substring(0, 20_000);

        String actual = SQ_7.sq_(20).getValue().toString().substring(0, 20_000);
        assertEquals(expected, actual);
    }

    @Test
    void test_golden_ratio_decimals_with_20_000_decimals_for_k_eq_20() throws IOException {
        var SQ_5 = new SquareRoot(5);
        String expected = ExtractData.extract("datas/golden_ratio.txt").substring(0, 20_000);

        BigDecimal sq_5 = SQ_5.sq_(20).getValue();
        String actual = BigDecimal.valueOf(1).add(sq_5).divide(BigDecimal.valueOf(2)).toString().substring(0, 20_000);

        assertEquals(expected, actual);

    }
}