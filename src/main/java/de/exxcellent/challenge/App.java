package de.exxcellent.challenge;

import de.exxcellent.challenge.parser.CSVParser;
import de.exxcellent.challenge.parser.Parser;

import java.util.Iterator;

import de.exxcellent.challenge.data_classes.Weather;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {
    // private static final String football_csv = "src/main/resources/de/exxcellent/challenge/football.csv";
    private static final String weather_csv = "src/main/resources/de/exxcellent/challenge/weather.csv";
    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {
        Parser<Weather> parser = new CSVParser<Weather>(weather_csv, Weather.class);

        Iterator<Weather> iter =  parser.deserialize();

        DataContainer<Weather> data = new DataContainer<>(iter);

        Weather min = data.next();

        while (data.hasNext()) {
            Weather next = data.next();

            if (next.temp_diff() < min.temp_diff())
                min = next;

            System.out.println(next.getDay());
        }
        
        if (min != null) {
            int dayWithSmallestTempSpread = min.getDay();
            System.out.println("Day with smallest temperature spread : " + dayWithSmallestTempSpread);
        }

        // String teamWithSmallestGoalSpread = "A good team"; // Your goal analysis function call …
        // System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
    }
}
