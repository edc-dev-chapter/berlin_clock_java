package berliner.lamp;

public class RedLamp extends Lamp {

    public static RedLamp red() {
        return new RedLamp();
    }

    @Override
    Color blinkingColor() {
        return Color.Red;
    }
}