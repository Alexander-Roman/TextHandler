package com.epam.texthandler.interpreter;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MathInterpreter {

    private final List<Expression> expressions = new ArrayList<Expression>();
    private final Deque<Integer> context = new LinkedList<Integer>();

    public MathInterpreter(List<String> values) {
        parse(values);
    }

    public int calculate() {
        for (Expression expression : expressions) {
            expression.interpret(context);
        }
        return context.pop();
    }

    private void parse(List<String> values) {
        for (String value : values) {
            switch (value) {
                case "+":
                    expressions.add(new TerminalExpressionPlus());
                    break;
                case "-":
                    expressions.add(new TerminalExpressionMinus());
                    break;
                case "*":
                    expressions.add(new TerminalExpressionMultiply());
                    break;
                case "/":
                    expressions.add(new TerminalExpressionDivide());
                    break;
                default:
                    int number = Integer.parseInt(value);
                    expressions.add(new NonTerminalExpression(number));
                    break;
            }
        }
    }
}
