package dev.razafindratelo.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *  NOTE : This ExtractData class is only used in SquareRootTest class for now, but it will be used
 *          in more different context in the future.
 */
public class ExtractData {
    public static String extract(String path) throws IOException {
        StringBuilder content = new StringBuilder();
        File file = new File(path);

        BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath())); {
            String line;

            while ((line = br.readLine()) != null) {
                content.append(line);
            }

            return content.toString();
        }
    }
}
