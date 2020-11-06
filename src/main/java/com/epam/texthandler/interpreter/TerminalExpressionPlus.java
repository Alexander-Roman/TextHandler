package com.epam.texthandler.interpreter;

import java.util.Deque;

public class TerminalExpressionPlus implements Expression {

    @Override
    public void interpret(Deque<Integer> context) {
        if (context.isEmpty()) {
            throw new IllegalArgumentException("Math operation with no arguments!");
        }
        int result = context.pollFirst();
        while (!context.isEmpty()) {
            result += context.pollFirst();
        }
        context.push(result);
    }
}
