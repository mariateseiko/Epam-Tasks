package by.bsuir.task3.composite;

import java.util.ArrayList;

public class TextComposite implements TextComponent{
    private ComponentType type;
    private ArrayList<TextComponent> components = new ArrayList<>();
    public TextComposite(ComponentType type) {
        this.type = type;
    }

    public TextComposite() {}

    @Override
    public ComponentType getType() {
        return type;
    }

    public void setType(ComponentType type) {
        this.type = type;
    }

    @Override
    public TextComponent getChild(int index) {
        return components.get(index);
    }

    @Override
    public boolean add(TextComponent c) {
        return components.add(c);
    }

    @Override
    public boolean remove(TextComponent c) {
        return components.remove(c);
    }

    @Override
    public int getChildrenCount() {
        return components.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
            for(TextComponent textComponent: components) {
                sb.append(textComponent);
                if (ComponentType.LEXEME == textComponent.getType()) {
                    sb.append(" ");
                }
            }
        return sb.toString();
    }
}
