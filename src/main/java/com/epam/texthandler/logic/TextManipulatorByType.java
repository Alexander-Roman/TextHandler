package com.epam.texthandler.logic;

import com.epam.texthandler.composite.Component;
import com.epam.texthandler.composite.Composite;
import com.epam.texthandler.composite.Leaf;
import com.epam.texthandler.composite.Type;
import com.epam.texthandler.interpreter.MathInterpreter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TextManipulatorByType {

    private static final String SEPARATOR = " ";

    /* Recursive */
    public Component resolveMathBySentences(Component component) {
        Type type = component.getType();
        switch (type) {
            case TEXT:
            case PARAGRAPH:
                return applyChildren(component, this::resolveMathBySentences); // recursive call
            case SENTENCE:
                Composite composite = (Composite) component;
                List<Component> children = composite.getChildren();
                List<Component> resolved = resolveMath(children); // private call
                return new Composite(type, resolved);
            default:
                throw new IllegalArgumentException(type + " is not defined Type for this method!");
        }
    }

    /* Recursive */
    public Component sortSentences(Component component) {
        Type type = component.getType();
        switch (type) {
            case TEXT:
            case PARAGRAPH:
                return applyChildren(component, this::sortSentences); // recursive call
            case SENTENCE:
                Composite composite = (Composite) component;
                List<Component> children = composite.getChildren();
                Comparator<Component> comparator = Comparator.comparing(c -> ((Leaf) c).getValue().length());
                List<Component> sorted = children
                        .stream()
                        .sorted(comparator)
                        .collect(Collectors.toList());
                return new Composite(type, sorted);
            default:
                throw new IllegalArgumentException(type + " is not defined Type for this method!");
        }
    }

    /* Recursive */
    public String restoreText(Component component) {
        StringBuilder stringBuilder = new StringBuilder();
        String separator = SEPARATOR;
        int size;
        Type type = component.getType();
        switch (type) {
            case TEXT:
                separator = System.lineSeparator();
            case PARAGRAPH:
            case SENTENCE:
                Composite composite = (Composite) component;
                List<Component> children = composite.getChildren();
                size = children.size();
                for (int i = 0; i < size; i++) {
                    Component child = children.get(i);
                    stringBuilder.append(restoreText(child)); // recursive call
                    if (i < size - 1) {
                        stringBuilder.append(separator);
                    }
                }
                return stringBuilder.toString();
            case WORD:
            case MATH:
                return ((Leaf) component).getValue();
            default:
                throw new IllegalArgumentException(type + " is not defined Type for this method!");
        }
    }

    private Component applyChildren(Component component, Function<Component, Component> function) {
        Type type = component.getType();
        switch (type) {
            case TEXT:
            case PARAGRAPH:
            case SENTENCE:
                Composite composite = (Composite) component;
                List<Component> children = composite.getChildren();
                List<Component> resolved = children
                        .stream()
                        .map(function)
                        .collect(Collectors.toList());
                return new Composite(type, resolved);
            default:
                throw new IllegalArgumentException(type + " is not defined Type for this method!");
        }
    }

    private List<Component> resolveMath(List<Component> components) {
        List<Component> resolved = new ArrayList<Component>();
        for (Component component : components) {
            Type type = component.getType();
            if (type == Type.MATH) {
                String value = ((Leaf) component).getValue();
                MathInterpreter interpreter = new MathInterpreter(value);
                int result = interpreter.calculate();
                String lexeme = Integer.toString(result);
                Leaf leaf = new Leaf(Type.WORD, lexeme);
                resolved.add(leaf);
            } else {
                resolved.add(component);
            }
        }
        return resolved;
    }

    public Component sortParagraphs(Component component) {
        Type type = component.getType();
        if (type == Type.TEXT) {
            Composite composite = (Composite) component;
            List<Component> children = composite.getChildren();
            Comparator<Component> comparator = Comparator.comparing(c -> ((Composite) c).getChildren().size());
            List<Component> sorted = children
                    .stream()
                    .sorted(comparator)
                    .collect(Collectors.toList());
            return new Composite(type, sorted);
        }
        throw new IllegalArgumentException(type + " is not defined Type for this method!");
    }


}
