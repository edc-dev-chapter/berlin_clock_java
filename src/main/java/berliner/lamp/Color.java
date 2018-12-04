package berliner.lamp;

public enum Color {
    Red("R"), Yellow("Y"), Off("O");

    private final String color;

    Color(String c) {
        this.color = c;
    }

    @Override
    public String toString() {
        return color;
    }

}