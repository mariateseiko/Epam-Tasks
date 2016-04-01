package by.bsuir.task3.composite;

public interface TextComponent {
    TextComponent getChild(int index);
    int getChildrenCount();
    boolean add(TextComponent c);
    boolean remove(TextComponent c);
    ComponentType getType();
}
