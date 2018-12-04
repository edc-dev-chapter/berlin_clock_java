package berliner.lamp;

import static berliner.lamp.Color.Red;

public class RedLamp extends Lamp {

    public static RedLamp red() {
        return new RedLamp();
    }

    @Override
    public Lamp turnOn() {
        color = Red;
        return this;
    }

    @Override
    public String toString() {
        return color.toString();
    }
}