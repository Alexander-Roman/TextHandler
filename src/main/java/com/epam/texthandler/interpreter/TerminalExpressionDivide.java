package com.epam.texthandler.interpreter;

import java.util.Deque;

public class TerminalExpressionDivide implements Expression {
    @Override
    public void interpret(Deque<Integer> context) {
        if (context.isEmpty()) {
            throw new IllegalArgumentException("Math operation with no arguments!");
        }
        int result = context.pollLast();
        if (context.isEmpty()) {
            result = 0 / result;
        } else {
            while (!context.isEmpty()) {
                result /= context.pollLast();
            }
        }
        context.push(result);
    }
}
