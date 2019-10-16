package be.lens.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TemperatureTest {
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
}
