package by.bsuir.task3.parser;

import by.bsuir.task3.composite.ComponentType;
import by.bsuir.task3.composite.TextComposite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphHandler extends AbstractHandler {
    private Pattern sentencePattern;
    final static String SENTENCE_REGEX = "(([A-Z0-9]((\\w\\.\\w)|[\\w'\\p{Punct}&&[^.?!]])*)(\\p{Blank}+((\\w\\.\\w)|[\\w'\\p{Punct}&&[^.?!]])*)*[.!?\n]+)";
    public ParagraphHandler() {
        setType(ComponentType.PARAGRAPH);
        sentencePattern = Pattern.compile(SENTENCE_REGEX);
    }

    @Override
    public TextComposite handleRequest(String text) {
        TextComposite textComposite = new TextComposite(getType());
        Matcher elementMatcher = sentencePattern.matcher(text);
        while(elementMatcher.find()) {
            textComposite.add(successor.chain(elementMatcher.group()));
        }
        return textComposite;
    }
}
