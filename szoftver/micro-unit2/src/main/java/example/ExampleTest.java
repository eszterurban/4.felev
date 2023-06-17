package example;

import microunit.Test;

import java.io.IOException;

import static microunit.Assert.assertTrue;

public class ExampleTest {
    public ExampleTest(){

    }

    @Test
    public void test_alwaysTrueCondition_shouldReturnTrue(){
        assertTrue(1+1==2, "This should always be true");
    }

    @Test
    public void test_alwaysFailsCondition_shouldReturnTrue() {
        assertTrue(1+1==0, "This should never be true");
    }

    @Test (expected= IOException.class)
    public void test_invalidParameter_shouldThrowException() {
        Integer.parseInt("Hello, World");
    }

    @Test (expected= IOException.class)
    public void test_emptyMethodBody_shouldThrowException() throws Exception{

    }
    @Test (expected = IOException.class)
    public void test_expectedIOException_shouldThrowException() throws Exception{
        throw new IOException("An I/O exception occurred");
    }
}
