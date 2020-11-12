package com.epam.texthandler.data;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DataReaderImplTest {

    private static final String FILE_CORRECT = "src/test/resources/TextTest.txt";
    private static final String FILE_LOST = "src/test/resources/TextTestLost.txt";
    private static final String EXPECTED = "Hello world!" + System.lineSeparator() + "Hello world!";
    private final DataReader reader = new DataReaderImpl();

    @Test
    public void testReadShouldReturnCorrectString() throws DataException {
        //given
        //when
        String actual = reader.read(FILE_CORRECT);
        //then
        Assert.assertEquals(actual, EXPECTED);
    }

    @Test(expectedExceptions = DataException.class)
    public void testReadShouldThrowDataExceptionWhenFileLost() throws DataException {
        //given
        //when
        reader.read(FILE_LOST);
        //then
    }
}
