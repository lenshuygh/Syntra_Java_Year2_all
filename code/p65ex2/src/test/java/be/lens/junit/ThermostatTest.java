package be.lens.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ThermostatTest {
    private final static int INTERVAL = 10;
    private SensorStub sensorStub;
    private HeatingStub heatingStub;
    private Thermostat thermostat;

    private class HeatingStub implements Heating{
        public void setHeating(boolean status) {

        }
    }

    private class SensorStub implements Sensor{
        private float temp;

        public Temperature getTemperature() {
            return new Temperature(temp);
        }

        public void setTemp(float temp){
            this.temp = temp;
        }
    }

    @Test
    public final void testChangeCurrent(){
        float targetTemperature = 50;
        sensorStub = new SensorStub();
        heatingStub = new HeatingStub();
        thermostat = new Thermostat(sensorStub,heatingStub);
        thermostat.setInterval(INTERVAL);
        thermostat.start();

        sensorStub.setTemp(targetTemperature);


    }
}
