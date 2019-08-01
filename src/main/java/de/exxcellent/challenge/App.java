package de.exxcellent.challenge;

import de.exxcellent.challenge.parser.CSVParser;
import de.exxcellent.challenge.parser.Parser;

import java.io.IOException;

import de.exxcellent.challenge.data_classes.Football;
import de.exxcellent.challenge.data_classes.Weather;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {
    private static final String FOOTBALL_CSV = "src/main/resources/de/exxcellent/challenge/football.csv";
    private static final String WEATHER_CSV = "src/main/resources/de/exxcellent/challenge/weather.csv";
    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {
        Parser<Weather> weather_parser = new CSVParser<>(WEATHER_CSV, Weather.class);
        DataContainer<Weather> weather_data = new DataContainer<>(weather_parser.deserialize());

        Parser<Football> football_parser = new CSVParser<>(FOOTBALL_CSV, Football.class);
        DataContainer<Football> football_data = new DataContainer<>(football_parser.deserialize());

        try {
            Weather weather = weather_data.smallest_diff();
            Integer day = weather.getDay();
            System.out.println("Day with smallest temperature spread : " + day);
        } catch(IOException e) {
            System.out.println(e);
        }
        try {
            Football football = football_data.smallest_diff();
            String team = football.getTeam();
            System.out.println("Team with smallest goal spread       : " + team);
        } catch(IOException e) {
            System.out.println(e);
        }
    }
}
