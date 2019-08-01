package de.exxcellent.challenge;

import java.util.Iterator;

public class DataContainer<T> {
    private Iterator<T> data;

    public DataContainer(Iterator<T> data) {
        this.data = data;
    }

    public boolean hasNext() {
        return this.data.hasNext();
    }

    public T next() {
        return this.data.next();
    }
}