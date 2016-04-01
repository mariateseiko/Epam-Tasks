package by.bsuir.task3.parser;

import by.bsuir.task3.composite.ComponentType;
import by.bsuir.task3.composite.TextComponent;
import by.bsuir.task3.composite.TextComposite;
import by.bsuir.task3.composite.StringLeaf;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextHandler extends AbstractHandler {
    private Pattern  elementPattern;
    final static String LISTING_REGEX = "(//:.*///:~)",
            PARAGRAPH_REGEX = "(\\p{Blank}){4}(([A-Z0-9]((\\w\\.\\w)|[\\w'\\p{Punct}&&[^.?!]])*)(\\p{Blank}+((\\w\\.\\w)|[\\w'\\p{Punct}&&[^.?!]])*)*[.!?\\n]+(\\p{Blank})*)+";
    public TextHandler() {
        elementPattern = Pattern.compile(LISTING_REGEX + "|" + PARAGRAPH_REGEX );
    }

    @Override
    public TextComposite handleRequest(String text) {
        TextComposite textComposite = new TextComposite();
        Matcher elementMatcher = elementPattern.matcher(text);
        while(elementMatcher.find()) {
            if (elementMatcher.group().matches(LISTING_REGEX)) {
                TextComponent listingLeaf = new StringLeaf(elementMatcher.group(), ComponentType.LISTING);
                textComposite.add(listingLeaf);
            } else if (elementMatcher.group().matches(PARAGRAPH_REGEX)) {
                textComposite.add(successor.chain(elementMatcher.group()));
            }
        }
        return textComposite;
    }
}
