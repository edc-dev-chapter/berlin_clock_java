package berliner;

public class YellowLamp extends Lamp {
    @Override
    void switchOn() {
        color = COLOR.YELLOW;
    }
}
