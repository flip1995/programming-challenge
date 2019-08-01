package de.exxcellent.challenge;

import java.io.IOException;
import java.util.Iterator;

import de.exxcellent.challenge.queries.Diff;
import de.exxcellent.challenge.queries.SmallestDiff;

public class DataContainer<T extends Diff<T>> implements SmallestDiff<T> {
    private Iterator<T> data;

    public DataContainer(Iterator<T> data) {
        this.data = data;
    }

    @Override
    public T smallest_diff() throws IOException {
        T min = this.data.next();
        if (min == null)
            throw new IOException("No data in CSV file");
        while (this.data.hasNext()) {
            T next = this.data.next();

            if (next.cmp_diff(min) < 0)
                min = next;
        }

        return min;        
	}
}