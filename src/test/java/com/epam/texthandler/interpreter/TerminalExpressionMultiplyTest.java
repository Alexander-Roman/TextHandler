package com.epam.texthandler.interpreter;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class TerminalExpressionMultiplyTest {

    private final TerminalExpressionMultiply expression = new TerminalExpressionMultiply();

    @Test
    public void testInterpretShouldMultiplyContextValues() {
        //given
        Deque<Integer> context = new LinkedList<Integer>(Arrays.asList(6, 7));
        //when
        expression.interpret(context);
        //then
        Deque<Integer> expected = new LinkedList<>(Collections.singletonList(42));
        Assert.assertEquals(context, expected);
    }
}
