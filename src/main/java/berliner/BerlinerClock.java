package berliner;

import berliner.lamp.LampRow;

import static berliner.lamp.RedLamp.red;
import static berliner.lamp.YellowLamp.yellow;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

class BerlinerClock {
    private final Integer seconds;
    private final Integer minutes;
    private final Integer hours;

    private final LampRow secondsRow = new LampRow(singletonList(yellow()));
    private final LampRow topHoursRow = new LampRow(asList(red(), red(), red(), red()));
    private final LampRow bottomHoursRow = new LampRow(asList(red(), red(), red(), red()));
    private final LampRow singleMinutesRow = new LampRow(asList(yellow(), yellow(), yellow(), yellow()));
    private final LampRow fiveMinutesRow = new LampRow(asList(
            yellow(), yellow(), red(),
            yellow(), yellow(), red(),
            yellow(), yellow(), red(),
            yellow(), yellow()
    ));

    BerlinerClock(String time) {
        String[] parts = time.split(":");
        seconds = Integer.valueOf(parts[2]);
        minutes = Integer.valueOf(parts[1]);
        hours = Integer.valueOf(parts[0]);
    }

    String displaySeconds() {
        return secondsRow.turnOn(1 - seconds % 2).display();
    }

    String displayTopHours() {
        return topHoursRow.turnOn(hours / 5).display();
    }

    String displayBottomHoursRow() {
        return bottomHoursRow.turnOn(hours % 5).display();
    }

    String displayFiveMinutesRow() {
        return fiveMinutesRow.turnOn(minutes / 5).display();
    }

    String displaySingleMinutesRow() {
        return singleMinutesRow.turnOn(minutes % 5).display();
    }

    String displayTime() {
        return displaySeconds()
                + displayTopHours() + displayBottomHoursRow()
                + displayFiveMinutesRow() + displaySingleMinutesRow();
    }
}
