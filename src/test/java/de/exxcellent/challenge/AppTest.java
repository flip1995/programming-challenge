package de.exxcellent.challenge;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Iterator;

import de.exxcellent.challenge.data_classes.Football;
import de.exxcellent.challenge.data_classes.Weather;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Example JUnit4 test case.
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public class AppTest {

    private static final ByteArrayOutputStream OUT = new ByteArrayOutputStream();
    private static final PrintStream ORIGINAL_OUT = System.out;

    @BeforeAll
    public static void setOut() {
        System.setOut(new PrintStream(OUT));
    }

    @Test
    public void weatherCmp() {
        Weather weather_low = new Weather();
        weather_low.setDay(2);
        weather_low.setMax_temp(3);
        weather_low.setMin_temp(1);

        Weather weather_high = new Weather();
        weather_high.setDay(1);
        weather_high.setMax_temp(10);
        weather_high.setMin_temp(0);

        assertTrue(weather_low.cmp_diff(weather_high) < 0);
    }

    @Test
    public void footballCmp() {
        Football football_low = new Football();
        football_low.setTeam("Loser");
        football_low.setGoals(3);
        football_low.setGoals_allowed(10); // -7

        Football football_high = new Football();
        football_high.setTeam("Winner");
        football_high.setGoals(3);
        football_high.setGoals_allowed(0); // +3

        assertTrue(football_low.cmp_diff(football_high) > 0);
        football_low.setGoals(7); // diff -3 == +3 = diff football_high
        assertEquals(football_low.cmp_diff(football_high), 0);
    }

    @Test
    public void emptyDataContainer() {
        Iterator<Weather> iter = new Iterator<Weather>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Weather next() {
                return null;
            }
        };
        DataContainer<Weather> data = new DataContainer<>(iter);

        assertThrows(IOException.class, () -> data.smallest_diff());
    }

    @Test
    public void runFootball() {
        App.main("");

        Iterator<String> output = OUT.toString().lines().iterator();
        assertEquals(output.next(), "Day with smallest temperature spread : 14");
        assertEquals(output.next(), "Team with smallest goal spread       : Aston_Villa");
    }

    @AfterAll
    public static void resetOut() {
        System.setOut(ORIGINAL_OUT);
    }

}
