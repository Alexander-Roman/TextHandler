package com.epam.texthandler.interpreter;

import java.util.Deque;

public interface Expression {

    void interpret(Deque<Integer> context);
}
