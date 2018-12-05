package berliner;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BerlinerClockTest {

    @Test
    void shouldReturnOneLampInSecondsRow() {
        String myTime = "00:00:00";
        assertEquals(1, new BerlinerClock(myTime).displaySeconds().length());
    }

    @Test
    void shouldReturnFourLampsInTopHoursRow() {
        String anyTime = "00:00:00";
        assertEquals(4, new BerlinerClock(anyTime).displayTopHours().length());
    }

    @Test
    void shouldReturnFourLampsInBottomHoursRow() {
        String anyTime = "00:00:00";
        assertEquals(4, new BerlinerClock(anyTime).displayBottomHoursRow().length());
    }

    @Test
    void shouldReturnElevenLampsInFiveMinutesRow() {
        String anyTime = "00:00:00";
        assertEquals(11, new BerlinerClock(anyTime).displayFiveMinutesRow().length());
    }

    @Test
    void shouldReturnFourLampsInSingleMinutesRow() {
        String anyTime = "00:00:00";
        assertEquals(4, new BerlinerClock(anyTime).displaySingleMinutesRow().length());
    }

    @DisplayName("For seconds row")
    @ParameterizedTest(name = "\"{0}\" should be {1}")
    @CsvSource({
            "00:00:00, Y",
            "23:59:59, O",
    })
    void testSecondsRow(String hour, String output) {
        assertEquals(output, new BerlinerClock(hour).displaySeconds());
    }

    @DisplayName("For top hours row")
    @ParameterizedTest(name = "\"{0}\" should return {1}")
    @CsvSource({
            "00:00:00, OOOO",
            "23:59:59, RRRR",
            "02:04:00, OOOO",
            "08:23:00, ROOO",
            "16:35:00, RRRO"
    })
    void testTopHoursRow(String hour, String output) {
        assertEquals(output, new BerlinerClock(hour).displayTopHours());
    }

    @DisplayName("For bottom hours row")
    @ParameterizedTest(name = "\"{0}\" should return {1}")
    @CsvSource({
            "00:00:00, OOOO",
            "23:59:59, RRRO",
            "02:04:00, RROO",
            "08:23:00, RRRO",
            "14:35:00, RRRR"
    })
    void testBottomHoursRow(String hour, String output) {
        assertEquals(output, new BerlinerClock(hour).displayBottomHoursRow());
    }

    @DisplayName("For five minutes row")
    @ParameterizedTest(name = "\"{0}\" should return {1}")
    @CsvSource({
            "00:00:00, OOOOOOOOOOO",
            "23:59:59, YYRYYRYYRYY",
            "12:04:00, OOOOOOOOOOO",
            "12:23:00, YYRYOOOOOOO",
            "12:35:00, YYRYYRYOOOO"
    })
    void testFiveMinutesRow(String hour, String output) {
        assertEquals(output, new BerlinerClock(hour).displayFiveMinutesRow());
    }

    @DisplayName("For single minutes row")
    @ParameterizedTest(name = "\"{0}\" should return {1}")
    @CsvSource({
            "00:00:00, OOOO",
            "23:59:59, YYYY",
            "12:32:00, YYOO",
            "12:34:00, YYYY",
            "12:35:00, OOOO"
    })
    void testSingleMinutesRow(String hour, String output) {
        assertEquals(output, new BerlinerClock(hour).displaySingleMinutesRow());
    }

    @DisplayName("Berlin clock for")
    @ParameterizedTest(name = "\"{0}\" should return {1}")
    @CsvSource({
            "00:00:00, YOOOOOOOOOOOOOOOOOOOOOOO",
            "23:59:59, ORRRRRRROYYRYYRYYRYYYYYY",
            "16:50:06, YRRROROOOYYRYYRYYRYOOOOO",
            "11:37:01, ORROOROOOYYRYYRYOOOOYYOO"
     })
    void testWholeClock(String hour, String output){
        assertEquals(output, new BerlinerClock(hour).displayTime());
    }
}