package by.bsuir.task3.composite;

public abstract class AbstractLeaf implements TextComponent {
    @Override
    public TextComponent getChild(int index) {
        return null;
    }

    @Override
    public int getChildrenCount() {
        return 0;
    }

    @Override
    public boolean add(TextComponent c) {
        return false;
    }

    @Override
    public boolean remove(TextComponent c) {
        return false;
    }
}
