package de.exxcellent.challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
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

    private Weather weather_low;
    private Weather weather_high;

    private Football football_low;
    private Football football_high;

    @BeforeEach
    public void setUp() {
        this.weather_low = new Weather();
        this.weather_low.setDay(2);
        this.weather_low.setMax_temp(3);
        this.weather_low.setMin_temp(1);

        this.weather_high = new Weather();
        this.weather_high.setDay(1);
        this.weather_high.setMax_temp(10);
        this.weather_high.setMin_temp(0);

        this.football_low = new Football();
        this.football_low.setTeam("Loser");
        this.football_low.setGoals(3);
        this.football_low.setGoals_allowed(10); // -7

        this.football_high = new Football();
        this.football_high.setTeam("Winner");
        this.football_high.setGoals(3);
        this.football_high.setGoals_allowed(0); // +3
    }

    @Test
    public void weatherCmp() {
        assertTrue(this.weather_low.cmp_diff(this.weather_high) < 0);
    }

    @Test
    public void footballCmp() {
        assertTrue(this.football_low.cmp_diff(this.football_high) > 0);
        this.football_low.setGoals(7); // diff -3 == +3 = diff football_high
        assertEquals(this.football_low.cmp_diff(this.football_high), 0);
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
    }

}
