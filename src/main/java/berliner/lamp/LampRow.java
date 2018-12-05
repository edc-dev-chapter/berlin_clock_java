package berliner.lamp;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LampRow {
    private final List<Lamp> row;

    public LampRow(List<Lamp> lamps) {
        row = lamps;
    }

    public LampRow turnOn(int n) {
        IntStream.range(0, n).forEach(i -> row.get(i).turnOn());
        return this;
    }

    public String display() {
        return row.stream()
                .map(Lamp::toString)
                .collect(Collectors.joining());
    }
}