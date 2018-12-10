package berliner.lamp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LampRow {
    private final List<Lamp> row;

    private LampRow(Lamp... lamps) {
        row = Arrays.asList(lamps);
    }

    public static LampRow of(Lamp... lamps){
        return new LampRow(lamps);
    }

    public LampRow turnOn(int n) {
        row.stream().limit(n).forEach(Lamp::turnOn);
        return this;
    }

    public String display() {
        return row.stream()
                .map(Lamp::toString)
                .collect(Collectors.joining());
    }
}