package com.epam.texthandler.interpreter;

import java.util.Deque;

public class TerminalExpressionPlus implements Expression {

    @Override
    public void interpret(Deque<Integer> context) {
        int result = context.pop();
        result += context.pop();
        context.push(result);
    }
}
