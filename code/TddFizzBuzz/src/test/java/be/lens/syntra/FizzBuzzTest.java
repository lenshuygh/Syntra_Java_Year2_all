package be.lens.syntra;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {

    @Test
    void testFizzBuzzOf1IsString1(){
        assertEquals("1",FizzBuzz.fizzBuzz(1));
    }

    @Test
    void testFizzBuzzOf2IsString2(){
        assertEquals("2",FizzBuzz.fizzBuzz(2));
    }

    @Test
    void testFizzBuzzOf3IsStringFizz(){
        assertEquals("Fizz",FizzBuzz.fizzBuzz(3));
    }

    @Test
    void testFizzBuzzOf5IsStringBuzz(){
        assertEquals("Buzz",FizzBuzz.fizzBuzz(5));
    }

    @Test
    void testFizzBuzzOf6IsStringFizz(){
        assertEquals("Fizz",FizzBuzz.fizzBuzz(6));
    }

    @Test
    void testFizzBuzzOf10IsStringBuzz(){
        assertEquals("Buzz",FizzBuzz.fizzBuzz(10));
    }

    @Test
    void testFizzBuzzOf15IsStringFizzBuzz(){
        assertEquals("FizzBuzz",FizzBuzz.fizzBuzz(15));
    }


}
