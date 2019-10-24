package be.lens.junit;

public class Thermostat {
    private final static int DEFAULT_INTERVAL = 100;
    private Temperature targetTemperature;
    private boolean status;
    private Thread thread;
    private Sensor sensor;
    private Heating heating;
    private int interval = DEFAULT_INTERVAL;

    public Thermostat(Sensor sensor, Heating heating) {
        this.sensor = sensor;
        this.heating = heating;
        this.targetTemperature = new Temperature(0);
    }

    public void start() {
        thread = new Thread(this::run);
        thread.setDaemon(true);
        thread.start();
    }

    public void stop() {
        thread = null;
    }

    public void setTargetTemperature(Temperature t) {
        targetTemperature = t;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public boolean isHeating() {
        return status;
    }

    private void run() {
        while(thread == Thread.currentThread()){
            evaluate();
            try{
                Thread.sleep(interval);
            }catch (InterruptedException e){

            }
        }
    }

    private void evaluate() {
        Temperature currentTemperature = sensor.getTemperature();
        status = currentTemperature.getValue() < targetTemperature.getValue();
        heating.setHeating(status);
    }

}
