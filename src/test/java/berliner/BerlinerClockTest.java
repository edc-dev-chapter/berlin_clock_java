package berliner;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BerlinerClockTest {

    @Test
    void shouldReturnOneLampInSecondsRow() {
        String anyTime = "00:00:00";
        assertEquals(1, new BerlinerClock(anyTime).getSeconds().length());
    }

    @Test
    void shouldNotBlinkWhenSecondsAreOdd() {
        String oddSecondsTime = "00:00:01";
        assertEquals("O", new BerlinerClock(oddSecondsTime).getSeconds());
    }

    @Test
    void shouldBlinkWhenSecondsAreEven() {
        String evenSecondsTime = "00:00:00";
        assertEquals("Y", new BerlinerClock(evenSecondsTime).getSeconds());
    }

    @Test
    void shouldReturnFourLampInFiveHoursRow() {
        String anyTime = "00:00:00";
        assertEquals(4, new BerlinerClock(anyTime).getFiveHoursRow().length());
    }

    @ParameterizedTest(name = "\"{0}\" should be {1}")
    @DisplayName("for five hour row")
    @CsvSource({
            "00:00:00, OOOO",
            "08:00:00, ROOO",
            "13:00:00, RROO"
    })
    void forFiveHourRow_LampsShouldGetOnEachFiveHours(String time, String result) {
        assertEquals(result, new BerlinerClock(time).getFiveHoursRow());
    }
}