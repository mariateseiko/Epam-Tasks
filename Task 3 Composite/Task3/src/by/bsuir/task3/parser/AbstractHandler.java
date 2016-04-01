package by.bsuir.task3.parser;

import by.bsuir.task3.composite.ComponentType;
import by.bsuir.task3.composite.TextComposite;

public abstract class AbstractHandler {
    private ComponentType type;
    protected AbstractHandler successor = DefaultHandleRequest.getHandleRequest();

    public AbstractHandler(AbstractHandler successor) {
        this.successor = successor;
    }

    public AbstractHandler() {}
    public void setSuccessor(AbstractHandler successor) {
        this.successor = successor;
    }

    public ComponentType getType() {
        return type;
    }

    public void setType(ComponentType type) {
        this.type = type;
    }

    abstract public TextComposite handleRequest(String text);

    public TextComposite chain(String text) {
        TextComposite textComposite = handleRequest(text);
        textComposite.setType(type);
        return textComposite;
    }
    private static class DefaultHandleRequest extends AbstractHandler {
        private static DefaultHandleRequest handler = new DefaultHandleRequest();
        private DefaultHandleRequest() { }
        public static DefaultHandleRequest getHandleRequest() {
            return handler;
        }

        @Override
        public TextComposite chain(String text) {
            return null;
        }

        @Override
        public TextComposite handleRequest(String text) {
            return null;
        }
    }
}
