package be.lens.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TemperatureTest {
    Temperature t;

    @BeforeEach
    public void init(){
        t = new Temperature(0);
    }

    @Test
    @DisplayName("Tests the Temperature constructor and check the constructor arg with a getter")
    public final void testConstructor(){
        Temperature temperature = new Temperature(50F);
        float testTemperature = temperature.getValue();
        Assertions.assertEquals(50F,testTemperature);
    }

    @Test
    @DisplayName("Tests the getter and setter for the value property")
    public final void testValue(){
        Temperature temperature = new Temperature(50);
        temperature.setValue(80F);
        float testTemperature = temperature.getValue();
        Assertions.assertEquals(80F,testTemperature);
    }

    @Test
    @DisplayName("Tests the .equals method")
    public final void testEquals(){
        Temperature temperatureA = new Temperature(50F);
        Temperature temperatureB = new Temperature(50F);
        boolean isEqual = temperatureA.equals(temperatureB);
        Assertions.assertEquals(true,isEqual);
    }

    @Test
    @DisplayName("Tests the .equals method to not be equal when different")
    public final void testNotEquals(){
        Temperature temperatureA = new Temperature(50F);
        Temperature temperatureB = new Temperature(60F);
        boolean isEqual = temperatureA.equals(temperatureB);
        Assertions.assertEquals(false,isEqual);
    }

    @Test
    @DisplayName("Tests the .hashCode")
    public final void testHashCode(){
        Temperature temperatureA = new Temperature(50F);
        Temperature temperatureB = new Temperature(50F);
        Assertions.assertEquals(temperatureA.hashCode(),temperatureB.hashCode());
    }

    @Test
    @DisplayName("Tests the .hashCode not to be equal when different")
    public final void testHashCodeDiffer(){
        Temperature temperatureA = new Temperature(50F);
        Temperature temperatureB = new Temperature(60F);
        Assertions.assertNotEquals(temperatureA.hashCode(),temperatureB.hashCode());
    }

    @Test
    public final void testBoiling(){
        t.setValue(99F);
        Assertions.assertEquals(false,t.isBoiling());
        t.setValue(101F);
        Assertions.assertEquals(false,t.isBoiling());
        t.setValue(100F);
        Assertions.assertEquals(true,t.isBoiling());
    }

    @Test
    public final void testFreezing(){
        t.setValue(1F);
        Assertions.assertEquals(false,t.isFreezing());
        t.setValue(0F);
        Assertions.assertEquals(false,t.isFreezing());
        t.setValue(-1F);
        Assertions.assertEquals(true,t.isFreezing());
    }

    @Test
    public final void throwsInvalidTemperatureException(){
        Assertions.assertThrows(InvalidTemperatureException.class,() -> t.setValue(-400F));
    }

    @Test
    public final void doesNotTrowsInvalidTemperatureException(){
        Assertions.assertDoesNotThrow(() -> t.setValue(-272F));
    }

    @Test
    public final void temperatureConstructorThrowsInvalidTemperatureException(){
        Assertions.assertThrows(InvalidTemperatureException.class,() -> new Temperature(-400F));
    }
}
