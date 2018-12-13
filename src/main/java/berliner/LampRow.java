package berliner;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LampRow {

    private List<Lamp> lamps;

    public LampRow(Lamp... lampList) {
        lamps = Arrays.asList(lampList);
    }

    public void set(int lampsToSwitch) {
        for (int x = 0; x < lampsToSwitch; x++) {
            lamps.get(x).switchOn();
        }
    }

    @Override
    public String toString() {
        return lamps.stream()
                .map(Lamp::getValue)
                .collect(Collectors.joining());
    }
}
