package de.fuas.algorithms;

public class ArrayList<T> implements List<T> {

    private int size;
    private Object[] internalArray;
    private static final int DEFAULT_LEN = 10;

    public ArrayList(int size) {
        this.size = 0;
        this.internalArray = new Object[size];
    }

    public ArrayList() {
        this(DEFAULT_LEN);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) this.internalArray[index];
    }

    @Override
    public void add(int index, T obj) {
        if (size >= internalArray.length) {
            this.internalArray = Arrays.expandArray(this.internalArray);
        }

        if (index < size) {
            this.internalArray = Arrays.shiftElements(this.internalArray, index);
        }

        internalArray[index] = obj;
        this.size++;
    }

    @Override
    public T remove(int index) {
        T removedValue = this.get(index);

        for (int i = index; i < this.size - 1; i++) {
            internalArray[i] = internalArray[i + 1];
        }
        // sets the last index that index that does not get overwritten to null
        internalArray[this.size - 1] = null;

        this.size--;
        return removedValue;
    }
}