package com.epam.texthandler.interpreter;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MathInterpreter {

    private static final String SEPARATOR = "[\\s_]";
    private final List<Expression> expressions = new ArrayList<Expression>();
    private final Deque<Integer> context = new LinkedList<Integer>();

    public MathInterpreter(String source) {
        parse(source);
    }

    public int calculate() {
        for (Expression expression : expressions) {
            expression.interpret(context);
        }
        return context.pop();
    }

    private void parse(String source) {
        String[] values = source.split(SEPARATOR);
        for (String value : values) {
            switch (value) {
                case "+":
                    expressions.add(new TerminalExpressionPlus());
                    break;
                case "*":
                    expressions.add(new TerminalExpressionMultiply());
                    break;
                default:
                    int number = Integer.parseInt(value);
                    expressions.add(new NonTerminalExpression(number));
                    break;
            }
        }
    }
}
