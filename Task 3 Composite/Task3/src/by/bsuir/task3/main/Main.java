package by.bsuir.task3.main;

import by.bsuir.task3.action.WordRemover;
import by.bsuir.task3.action.WordSorter;
import by.bsuir.task3.composite.TextComposite;
import by.bsuir.task3.parser.TextParser;
import by.bsuir.task3.util.TextFileReader;
import by.bsuir.task3.util.TextFileWriter;
import by.bsuir.task3.exception.FileWriterException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Main {
    static {
        new DOMConfigurator().doConfigure("log4j.xml", LogManager.getLoggerRepository());
    }
    static final Logger LOG = Logger.getLogger(Main.class);
    static final String READ_PATH = "resources\\text.txt";
    static final String WRITE_PATH = "resources\\out.txt";
    static final String WRITE_TASK1_PATH = "resources\\task1.txt";
    static final String WRITE_TASK2_PATH = "resources\\task2.txt";
    public static void main(String[] args) {
        String text = TextFileReader.read(READ_PATH);
        TextParser parser = new TextParser();
        TextComposite composite = parser.parse(text);
        try {
            TextFileWriter.write(composite.toString(), WRITE_PATH);
            TextFileWriter.write(WordRemover.removeFixedLengthConsonantWords(composite, 5).toString(), WRITE_TASK1_PATH);
            TextFileWriter.write(WordSorter.sortVowelWordsByFirstConsonant(composite, 'a'), WRITE_TASK2_PATH);
        } catch (FileWriterException e) {
            LOG.error(e.getMessage());
        }
    }
}
