package by.bsuir.task3.util;

import by.bsuir.task3.exception.FileWriterException;

import java.io.*;
import java.util.List;

public class TextFileWriter {
    public static void write(String text, String path) throws FileWriterException{
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(text);
        } catch (IOException e) {
            throw new FileWriterException("Error writing to file " + path, e);
        }
    }

    public static void write(List<String> components, String path) throws FileWriterException {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (String component: components) {
            writer.write(component);
                writer.newLine();
            }
        }  catch (IOException e) {
            throw new FileWriterException("Error writing to file " + path, e);
        }
    }
}
