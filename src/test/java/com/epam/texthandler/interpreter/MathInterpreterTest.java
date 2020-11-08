package com.epam.texthandler.interpreter;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MathInterpreterTest {

    private static final String TEST_VALUE = "10_13_+_2_*";

    @Test
    public void testCalculateShouldReturnCorrectResult() {
        //given
        MathInterpreter interpreter = new MathInterpreter(TEST_VALUE);
        //when
        int actual = interpreter.calculate();
        //then
        Assert.assertEquals(actual, 46);
    }
}
