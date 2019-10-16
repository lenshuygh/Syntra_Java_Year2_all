package be.lens.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloWorldTest {


    @Test
    public final void testSayHello(){
        HelloWorld helloWorld = new HelloWorld();
        Assertions.assertEquals("Hello World",helloWorld.sayHello());

    }

}
