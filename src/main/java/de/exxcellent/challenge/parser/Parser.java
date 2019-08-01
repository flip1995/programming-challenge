package de.exxcellent.challenge.parser;

import java.util.Iterator;

public interface Parser<T> {
    public Iterator<T> deserialize();
}