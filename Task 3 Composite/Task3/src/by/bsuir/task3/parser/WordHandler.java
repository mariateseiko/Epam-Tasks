package by.bsuir.task3.parser;

import by.bsuir.task3.composite.CharacterLeaf;
import by.bsuir.task3.composite.ComponentType;
import by.bsuir.task3.composite.TextComposite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordHandler extends AbstractHandler {
    private Pattern elementPattern;
    final static String LETTER_REGEX = "([\\w'])";
    public WordHandler() {
        elementPattern = Pattern.compile(LETTER_REGEX);
        setType(ComponentType.WORD);
    }

    @Override
    public TextComposite handleRequest(String text) {
        TextComposite textComposite = new TextComposite(getType());
        Matcher elementMatcher = elementPattern.matcher(text);
        while(elementMatcher.find()) {
            CharacterLeaf leaf = new CharacterLeaf(elementMatcher.group().charAt(0), ComponentType.LETTER);
            textComposite.add(leaf);
        }
        return textComposite;
    }
}
