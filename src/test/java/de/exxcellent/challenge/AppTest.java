package de.exxcellent.challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Iterator;

import de.exxcellent.challenge.data_classes.Weather;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Example JUnit4 test case.
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public class AppTest {

    private Weather weather_low;
    private Weather weather_high;

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
    }

    @Test
    public void weatherCmp() {
        assertTrue(this.weather_low.cmp_diff(this.weather_high) < 0);
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
