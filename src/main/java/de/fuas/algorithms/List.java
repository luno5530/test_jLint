package de.fuas.algorithms;

public interface List<T> {

    boolean isEmpty();

    int size();

    void add(int index, T value);

    T remove(int index);

    T get(int index);
}