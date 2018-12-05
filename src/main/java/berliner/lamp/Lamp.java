package berliner.lamp;

public abstract class Lamp {
    private Color color;

    Lamp() {
        turnOff();
    }

    Lamp turnOn() {
        color = blinkingColor();
        return this;
    }

    Lamp turnOff() {
        color = Color.Off;
        return this;
    }

    abstract Color blinkingColor();

    @Override
    public String toString() {
        return color.toString();
    }
}


