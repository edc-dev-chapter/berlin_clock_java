package berliner;

public abstract class Lamp {

    enum COLOR {
        RED("R"),
        YELLOW("Y"),
        OFF("O");

        String state;

        COLOR(String state) {
            this.state = state;
        }
    }

    protected COLOR color;

    public Lamp() {
        this.color = COLOR.OFF;
    }

    abstract void switchOn();

    public String getValue() {
        return color.state;
    }
}


