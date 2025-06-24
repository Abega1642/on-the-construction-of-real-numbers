package dev.razafindratelo.sequences;

import dev.razafindratelo.ExtractData;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.math.MathContext;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HeronSequenceTest {

    /**
     * Success got, only with k = 21 Duration: 12s 456ms
     */
    @Test
    void test_heron_sequence_with_k_eq_21() throws IOException {
        var subject = HeronSequence.init();

        final int lengthPrecision = 1_000_002;
        MathContext precision = new MathContext(lengthPrecision + 1);

        String expected = ExtractData.extract("data/sqrt_2.txt").substring(0,lengthPrecision);
        String actual = subject.kThValue(21).getValue(precision).toString().substring(0,lengthPrecision);

        assertEquals(expected,actual);
    }

    /**
     * Success got, only with k = 23 duration: 1min 26s
     */
    @Test
    void test_heron_sequence_with_k_eq_23() throws IOException {
        var subject = HeronSequence.init();

        final int lengthPrecision = 6_000_002;
        MathContext precision = new MathContext(lengthPrecision + 4);

        String expected = ExtractData.extract("data/sqrt_2.txt");
        String actual = subject.kThValue(23).getValue(precision).toString().substring(0,lengthPrecision);

        assertEquals(expected,actual);

    }
}