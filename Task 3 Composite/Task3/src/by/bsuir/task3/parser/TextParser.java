package by.bsuir.task3.parser;

import by.bsuir.task3.composite.TextComposite;

public class TextParser {
    public TextComposite parse(String text) {
        TextHandler textHandler = new TextHandler();
        ParagraphHandler paragraphHandler = new ParagraphHandler();
        SentenceHandler sentenceHandler = new SentenceHandler();
        LexemeHandler lexemeHandler = new LexemeHandler();
        WordHandler wordHandler = new WordHandler();
        textHandler.setSuccessor(paragraphHandler);
        paragraphHandler.setSuccessor(sentenceHandler);
        sentenceHandler.setSuccessor(lexemeHandler);
        lexemeHandler.setSuccessor(wordHandler);
        TextComposite textComposite = textHandler.chain(text);
        return textComposite;
    }
}
