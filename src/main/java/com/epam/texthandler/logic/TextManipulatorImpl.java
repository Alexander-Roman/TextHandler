package com.epam.texthandler.logic;

import com.epam.texthandler.composite.Component;
import com.epam.texthandler.composite.Composite;
import com.epam.texthandler.composite.Leaf;
import com.epam.texthandler.composite.Type;
import com.epam.texthandler.interpreter.MathInterpreter;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TextManipulatorImpl implements TextManipulator {

    private static final String SEPARATOR = " ";

    @Override /* Recursive */
    public Component resolveMathExpressions(Component component) {
        List<Component> children = component.getChildren();
        if (children.isEmpty()) { // end of recursion condition
            Leaf leaf = (Leaf) component;
            return resolveLeaf(leaf); // private call
        }
        List<Component> resolved = children
                .stream()
                .map(this::resolveMathExpressions) // recursive call
                .collect(Collectors.toList());
        return new Composite(resolved);
    }

    private Leaf resolveLeaf(Leaf leaf) {
        Type type = leaf.getType();
        if (type != Type.MATH) {
            return leaf;
        }
        String value = leaf.getValue();
        MathInterpreter interpreter = new MathInterpreter();
        int result = interpreter.calculate(value);
        String lexeme = Integer.toString(result);
        return Leaf.wordFrom(lexeme);
    }

    @Override
    public String restoreText(Component text) {
        String separator = System.lineSeparator();
        List<Component> paragraphs = text.getChildren();
        return paragraphs
                .stream()
                .map(this::restoreParagraph) // private call
                .collect(Collectors.joining(separator));
    }

    private String restoreParagraph(Component paragraph) {
        List<Component> sentences = paragraph.getChildren();
        return sentences
                .stream()
                .map(this::restoreSentence) // private call
                .collect(Collectors.joining(SEPARATOR));
    }

    private String restoreSentence(Component sentence) {
        List<Component> lexemes = sentence.getChildren();
        return lexemes
                .stream()
                .map(component -> (Leaf) component)
                .map(Leaf::getValue)
                .collect(Collectors.joining(SEPARATOR));
    }

    @Override
    public Component sortParagraphs(Component text) {
        List<Component> children = text.getChildren();
        Comparator<Component> comparator = Comparator.comparing(component -> component.getChildren().size());
        List<Component> sorted = children
                .stream()
                .sorted(comparator)
                .collect(Collectors.toList());
        return new Composite(sorted);
    }

    @Override
    public Component sortWordsInAllSentences(Component text) {
        List<Component> paragraphs = text.getChildren();
        List<Component> sorted = paragraphs
                .stream()
                .map(this::sortWordsInParagraph) // private call
                .collect(Collectors.toList());
        return new Composite(sorted);
    }

    private Component sortWordsInParagraph(Component paragraph) {
        List<Component> sentences = paragraph.getChildren();
        List<Component> sorted = sentences
                .stream()
                .map(this::sortWordsInSentence) // private call
                .collect(Collectors.toList());
        return new Composite(sorted);
    }

    private Component sortWordsInSentence(Component sentence) {
        List<Component> leafs = sentence.getChildren();
        Comparator<Leaf> comparator = Comparator.comparing(leaf -> leaf.getValue().length());
        List<Component> sorted = leafs
                .stream()
                .map(component -> (Leaf) component)
                .sorted(comparator)
                .collect(Collectors.toList());
        return new Composite(sorted);
    }

}
