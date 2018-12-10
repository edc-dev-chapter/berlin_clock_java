package berliner;

import berliner.lamp.LampRow;

import static berliner.lamp.LampRow.of;
import static berliner.lamp.RedLamp.red;
import static berliner.lamp.YellowLamp.yellow;

class BerlinerClock {
    private final Integer seconds;
    private final Integer minutes;
    private final Integer hours;

    private final LampRow secondsRow = of(yellow());
    private final LampRow topHoursRow = of(red(), red(), red(), red());
    private final LampRow bottomHoursRow = of(red(), red(), red(), red());
    private final LampRow singleMinutesRow = of(yellow(), yellow(), yellow(), yellow());
    private final LampRow fiveMinutesRow = of(
            yellow(), yellow(), red(),
            yellow(), yellow(), red(),
            yellow(), yellow(), red(),
            yellow(), yellow()
    );

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

    String displayBottomHours() {
        return bottomHoursRow.turnOn(hours % 5).display();
    }

    String displayTopMinutes() {
        return fiveMinutesRow.turnOn(minutes / 5).display();
    }

    String displayBottomMinutes() {
        return singleMinutesRow.turnOn(minutes % 5).display();
    }

    String displayTime() {
        return displaySeconds()
                + displayTopHours() + displayBottomHours()
                + displayTopMinutes() + displayBottomMinutes();
    }
}
