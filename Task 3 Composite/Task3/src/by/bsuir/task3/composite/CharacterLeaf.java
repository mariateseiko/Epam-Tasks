package by.bsuir.task3.composite;

public class CharacterLeaf extends AbstractLeaf {
    private char value;
    private ComponentType type;

    public CharacterLeaf(char value) {
        this.value = value;
    }

    public CharacterLeaf(char value, ComponentType type) {
        this(value);
        this.type = type;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    @Override
    public ComponentType getType() {
        return type;
    }

    public void setType(ComponentType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return Character.toString(value);
    }
}
