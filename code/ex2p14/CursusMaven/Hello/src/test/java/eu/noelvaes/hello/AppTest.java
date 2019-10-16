package eu.noelvaes.hello;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AppTest {
    @Test
    public final void testSayHello() {
        App app = new App();
        String text = app.sayHello();
        assertEquals("Hello World", text);
    }
}
