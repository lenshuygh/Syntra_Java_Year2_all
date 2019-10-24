package be.lens.syntra.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    public final void TestAddMethodEmpty() {
        assertEquals(calculator.add(""), "0");
    }

    @Test
    public final void TestAddMethod1() {
        assertEquals(calculator.add("1"), "1");
    }

    @Test
    public final void TestAddMethod1point1() {
        assertEquals(calculator.add("1.1"), "1.1");
    }

    @Test
    public final void TestAddMethod2point1() {
        assertEquals(calculator.add("2.1"), "2.1");
    }

    @Test
    public final void TestAddMethod1Comma1() {
        assertEquals(calculator.add("1,1"), "2.0");
    }

    @Test
    public final void TestAddMethodEndsWithComma() {
        assertEquals(calculator.add("1,1,"), "Number expected but EOF found.");
    }

    @Test
    public final void TestAddMethodIsOneComma() {
        assertEquals(calculator.add(","), "Number expected but EOF found.");
    }

    @Test
    public final void TestAddMethod1Plus2() {
        assertEquals(calculator.add("1,2"), "3.0");
    }

    @Test
    public final void TestAddMethodHasNewSeparatorSemiColon() {
        assertEquals(calculator.add(";\\n1;2"), "3.0");
    }

    @Test
    public final void TestAddMethodHasNewSeparatorExclamationMark() {
        assertEquals(calculator.add("!\\n1!2"), "3.0");
    }

    @Test
    public final void TestAddMethodHasNewSeparatorWrongCharacter() {
        assertEquals(calculator.add("!\\n1!2,1"), "4.0");
    }


}
