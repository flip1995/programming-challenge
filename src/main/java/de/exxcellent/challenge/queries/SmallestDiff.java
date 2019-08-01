package de.exxcellent.challenge.queries;

import java.io.IOException;

public interface SmallestDiff<T extends Diff<T>> {
    public T smallest_diff() throws IOException;
}