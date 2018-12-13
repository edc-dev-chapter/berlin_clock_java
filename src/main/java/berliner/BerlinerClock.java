package berliner;


import java.util.ArrayList;
import java.util.List;

class BerlinerClock {

    Integer hours;
    Integer seconds;
    private LampRow fiveHoursRow;
    private LampRow secondsRow;

    BerlinerClock(String oddSecondsTime) {
        seconds = Integer.valueOf(oddSecondsTime.split(":")[2]);
        hours = Integer.valueOf(oddSecondsTime.split(":")[0]);

        this.fiveHoursRow = new LampRow(new RedLamp(), new RedLamp(), new RedLamp(), new RedLamp());
        this.secondsRow  = new LampRow(new YellowLamp());
    }

    String getSeconds() {
        int lampsToSwitch = 1 - (seconds % 2);
        secondsRow.set(lampsToSwitch);
        return secondsRow.toString();
    }

    public String getFiveHoursRow() {
        int lampsToSwitch = hours / 5;
        fiveHoursRow.set(lampsToSwitch);
        return fiveHoursRow.toString();

    }


}
