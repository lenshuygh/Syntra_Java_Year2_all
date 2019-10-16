package be.lens.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class HelloWorldTest {


    @Test
    public final void testSayHello(){
        //given - Arrange
        HelloWorld helloWorld = new HelloWorld();
        // when - Act
        String helloString = helloWorld.sayHello();
        // then - Assert
        Assertions.assertEquals("Hello World", helloString);

    }

}
