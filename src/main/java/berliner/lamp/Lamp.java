package berliner.lamp;

import static berliner.lamp.Color.Off;

public abstract class Lamp {
    Color color;

    Lamp() {
        turnOff();
    }

    abstract Lamp turnOn();

    protected Lamp turnOff() {
        color = Off;
        return this;
    }

}


