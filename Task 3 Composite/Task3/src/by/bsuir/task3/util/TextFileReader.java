package by.bsuir.task3.util;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextFileReader {
    static final Logger LOG = Logger.getLogger(TextFileReader.class);
    public static String read(String path) {
        StringBuilder sb = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String temp;
            while ((temp = reader.readLine()) != null) {
                sb.append(temp).append(" ");
            }
        } catch (FileNotFoundException e) {
            LOG.fatal("File " + path + " not found");
            throw new RuntimeException();
        } catch (IOException e) {
            LOG.fatal("Error reading file " + path);
            throw new RuntimeException();
        }
        return sb.toString();
    }
}
