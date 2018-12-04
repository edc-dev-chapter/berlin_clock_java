package berliner.lamp;

import static berliner.lamp.Color.Yellow;

public class YellowLamp extends Lamp {

    public static YellowLamp yellow() {
        return new YellowLamp();
    }

    @Override
    public Lamp turnOn() {
        color = Yellow;
        return this;
    }

    @Override
    public String toString() {
        return color.toString();
    }
}