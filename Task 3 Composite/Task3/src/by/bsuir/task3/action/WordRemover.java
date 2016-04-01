package by.bsuir.task3.action;

import by.bsuir.task3.composite.AbstractLeaf;
import by.bsuir.task3.composite.ComponentType;
import by.bsuir.task3.composite.TextComponent;
import by.bsuir.task3.composite.TextComposite;

public class WordRemover {
    public static boolean isFixedLength(String text, int length) {
        return text.length() == length;
    }

    public static boolean isConsonant(String text) {
        return !"aeiouAEIOU".contains(String.valueOf(text.charAt(0)));
    }

    public static TextComponent removeFixedLengthConsonantWords(TextComponent component, int length){
        TextComposite composite = new TextComposite(component.getType());
        for (int i = 0; i < component.getChildrenCount(); i++) {
            TextComponent element = component.getChild(i);
            if (element instanceof AbstractLeaf) {
                composite.add(element);
            } else if (ComponentType.WORD != element.getType()) {
                TextComponent modifiedComponent = removeFixedLengthConsonantWords(element, length);
                if (modifiedComponent.getChildrenCount() != 0) {
                    composite.add(modifiedComponent);
                }
            } else if (!(isFixedLength(element.toString(), length) && isConsonant(element.toString())))  {
                composite.add(element);
            }
        }
        return composite;
    }
}
