package be.lens.junit;

import java.util.Objects;

public class Temperature {
    private float value;

    public Temperature(float value) {
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public boolean isBoiling(){
        return value == 100F;
    }

    public boolean isFreezing(){
        return value < 0F;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Temperature that = (Temperature) o;
        return Float.compare(that.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
