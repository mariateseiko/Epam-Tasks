package by.bsuir.task3.parser;

import by.bsuir.task3.composite.ComponentType;
import by.bsuir.task3.composite.TextComposite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceHandler extends AbstractHandler {
    private Pattern lexemePattern;
    final static String LEXEME_REGEX = "((((\\w\\.\\w)|[\\w\\p{Punct}&&[^.?!]])+)[.!?]*)";
    public SentenceHandler() {
        setType(ComponentType.SENTENCE);
        lexemePattern = Pattern.compile(LEXEME_REGEX);
    }
    @Override
    public TextComposite handleRequest(String text) {
        TextComposite textComposite = new TextComposite(getType());
        Matcher elementMatcher = lexemePattern.matcher(text);
        while(elementMatcher.find()) {
            textComposite.add(successor.chain(elementMatcher.group()));
        }
        return textComposite;
    }
}
