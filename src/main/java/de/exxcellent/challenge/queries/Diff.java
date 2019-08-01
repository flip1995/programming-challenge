package de.exxcellent.challenge.queries;

public interface Diff<T> {
    public int cmp_diff(T other);
}