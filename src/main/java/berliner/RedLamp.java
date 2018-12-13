package berliner;

public class RedLamp extends Lamp {
    @Override
    void switchOn() {
        color = COLOR.RED;
    }
}
