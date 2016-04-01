package by.bsuir.task3.action;

import by.bsuir.task3.composite.AbstractLeaf;
import by.bsuir.task3.composite.ComponentType;
import by.bsuir.task3.composite.TextComponent;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class WordSorter {
    public static List<String> sortVowelWordsByFirstConsonant(TextComponent component, char symbol) {
        List<String> words = new LinkedList<>();
        for (int i = 0; i < component.getChildrenCount(); i++) {
            TextComponent element = component.getChild(i);
            if (ComponentType.WORD == element.getType()) {
                words.add(element.toString());
            } else if (!( element instanceof AbstractLeaf)) {
                words.addAll(sortVowelWordsByFirstConsonant(element, symbol));
            }
        }
        Comparator<String> comp = Comparator.<String>comparingInt(word -> countOccurrences(word, symbol)).reversed()
                .thenComparing(String.CASE_INSENSITIVE_ORDER);
        words.sort(comp);
        return words;
    }

    public static int countOccurrences(String word, char c) {
        return word.length() - word.replace(Character.toString(c), "").length();
    }

}
