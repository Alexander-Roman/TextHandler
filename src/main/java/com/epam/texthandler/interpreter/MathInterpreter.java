package com.epam.texthandler.interpreter;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MathInterpreter {

    private static final String SEPARATOR = "[_\\s]";

    public MathInterpreter() {
    }

    public int calculate(String mathExpression) {
        List<Expression> expressions = parse(mathExpression);
        Deque<Integer> context = new LinkedList<Integer>();
        for (Expression expression : expressions) {
            expression.interpret(context);
        }
        return context.pop();
    }

    private List<Expression> parse(String source) {
        String[] values = source.split(SEPARATOR);
        List<Expression> expressions = new ArrayList<Expression>();
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
        return expressions;
    }
}
