package berliner.lamp;

public class YellowLamp extends Lamp {

    public static YellowLamp yellow() {
        return new YellowLamp();
    }

    @Override
    Color blinkingColor() {
        return Color.Yellow;
    }
}