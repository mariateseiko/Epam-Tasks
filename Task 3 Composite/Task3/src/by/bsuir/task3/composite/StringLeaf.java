package by.bsuir.task3.composite;

public class StringLeaf extends AbstractLeaf implements TextComponent {
    private String value;
    private ComponentType type;

    public StringLeaf(String value) {
        this.value = value;
    }

    public StringLeaf(String value, ComponentType type) {
        this(value);
        setType(type);
    }

    @Override
    public ComponentType getType() {
        return type;
    }

    public void setType(ComponentType type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
