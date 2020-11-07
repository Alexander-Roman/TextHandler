package com.epam.texthandler.logic;

import com.epam.texthandler.composite.Component;
import com.epam.texthandler.composite.Composite;
import com.epam.texthandler.composite.Leaf;
import com.epam.texthandler.composite.Type;
import com.epam.texthandler.interpreter.MathInterpreter;

import java.util.ArrayList;
import java.util.List;

public class TextManipulatorByIterator {

    private static final String SEPARATOR = " ";

    /* Recursive */
    public Component resolveComponentMath(Component component) {
        Component resolved;
        Type type = component.getType();
        if (component.hasChildren()) {
            List<Component> components = new ArrayList<Component>();
            for (Component child : component) {
                Component childResolved = resolveComponentMath(child); // recursive call
                components.add(childResolved);
            }
            resolved = new Composite(type, components);
        } else {
            Leaf leaf = (Leaf) component;
            resolved = resolveLeafMath(leaf); // private call
        }
        return resolved;
    }

    private Leaf resolveLeafMath(Leaf leaf) {
        Leaf resolved;
        Type type = leaf.getType();
        if (type == Type.MATH) {
            String value = leaf.getValue();
            MathInterpreter interpreter = new MathInterpreter(value);
            int result = interpreter.calculate();
            String lexeme = Integer.toString(result);
            resolved = new Leaf(Type.WORD, lexeme);
        } else {
            resolved = leaf;
        }
        return resolved;
    }

}
