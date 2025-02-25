package dev.razafindratelo.tools;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ExtractDataTest {

    @Test
    void test_data_extraction_of_square_2_dot_txt() throws IOException {
        String expected1 = "1.4142135623730950488016887";
        String expected2 = "236585352243349189341495373185461775639085063014980593";

        String path = "datas/sqrt_2.txt";
        String actual = ExtractData.extract(path);

        assertTrue(actual.startsWith(expected1));
        assertTrue(actual.endsWith(expected2));
    }

    @Test
    void test_data_extraction_of_square_3_dot_txt() throws IOException {
        String expected1 = "1.732050807568877";
        String expected2 = "49006855340475077042009865211014787724212059";

        String path = "datas/sqrt_3.txt";
        String actual = ExtractData.extract(path);


        assertTrue(actual.startsWith(expected1));
        assertTrue(actual.endsWith(expected2));
    }

    @Test
    void test_data_extraction_of_square_5_dot_txt() throws IOException {
        String expected1 = "2.2360679774997896964091736687312762354406183596115257242";
        String expected2 = "71932060848761609131889486671356633454074592727351884339987590433";

        String path = "datas/sqrt_5.txt";
        String actual = ExtractData.extract(path);

        assertTrue(actual.startsWith(expected1));
        assertTrue(actual.endsWith(expected2));
    }


}