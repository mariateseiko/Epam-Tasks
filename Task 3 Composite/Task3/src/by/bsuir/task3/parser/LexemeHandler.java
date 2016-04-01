package by.bsuir.task3.parser;

import by.bsuir.task3.composite.CharacterLeaf;
import by.bsuir.task3.composite.ComponentType;
import by.bsuir.task3.composite.TextComposite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class LexemeHandler extends AbstractHandler {
    private Pattern elementPattern;
    final static String WORD_REGEX = "([\\w']+)", PUNCTUATION_REGEX = "(\\p{Punct})";
    public LexemeHandler() {
        elementPattern = Pattern.compile(PUNCTUATION_REGEX + "|" + WORD_REGEX);
        setType(ComponentType.LEXEME);
    }

    @Override
    public TextComposite handleRequest(String text) {
        TextComposite textComposite = new TextComposite(getType());
        Matcher elementMatcher = elementPattern.matcher(text);
        while(elementMatcher.find()) {
            CharacterLeaf leaf = new CharacterLeaf(elementMatcher.group().charAt(0));
            if (elementMatcher.group().matches(WORD_REGEX)) {
                textComposite.add(successor.chain(elementMatcher.group()));
            } else if (elementMatcher.group().matches(PUNCTUATION_REGEX)) {
                leaf.setType(ComponentType.PUNCTUATION);
                textComposite.add(leaf);
            }
        }
        return textComposite;
    }
}
