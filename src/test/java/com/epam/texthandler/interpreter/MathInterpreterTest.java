package com.epam.texthandler.interpreter;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MathInterpreterTest {

    private static final String TEST_VALUE = "10_13_+_2_*";
    private final MathInterpreter interpreter = new MathInterpreter();

    @Test
    public void testCalculateShouldReturnCorrectResult() {
        //given
        //when
        int actual = interpreter.calculate(TEST_VALUE);
        //then
        Assert.assertEquals(actual, 46);
    }
}
