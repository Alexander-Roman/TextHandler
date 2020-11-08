package com.epam.texthandler.interpreter;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class TerminalExpressionPlusTest {

    private final TerminalExpressionPlus expression = new TerminalExpressionPlus();

    @Test
    public void testInterpretShouldSumUpContextValues() {
        //given
        Deque<Integer> context = new LinkedList<Integer>(Arrays.asList(6, 7));
        //when
        expression.interpret(context);
        //then
        Deque<Integer> expected = new LinkedList<>(Collections.singletonList(13));
        Assert.assertEquals(context, expected);
    }
}
