package main;

import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.*;

public class RuntimeUserInputExceptionTest {

    @Test
    public void inputValidator() {
        String inputString="2233487";
        boolean result= RuntimeUserInputException.ifNumber(inputString);
        assertEquals(true,result);
    }

    @Test
    public void ifNumber() {
        String inputString="heu2356787";
        boolean result= RuntimeUserInputException.ifNumber(inputString);
        assertEquals(false,result);
    }

    @Test
    public void ifNotnullInputString() {
        String inputString=null;
        boolean result= RuntimeUserInputException.ifNotnull(inputString);
        assertEquals(false,result);
    }
}