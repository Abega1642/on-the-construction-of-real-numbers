package dev.razafindratelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * ExtractData: used in SquareRootTest to retrieve comparative data from NASA (/datas)
 */
public class ExtractData {
    public static String extract(String path) throws IOException {
        StringBuilder content = new StringBuilder();
        File file = new File(path);

        BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()));
        {
            String line;

            while ((line = br.readLine()) != null) {
                content.append(line);
            }

            return content.toString();
        }
    }
}
