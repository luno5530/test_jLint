package de.fuas.algorithms;

public class Arrays {

    public static Object[] expandArray(Object[] initArray) {
        Object[] expandedArray = new String[initArray.length * 2];

        for (int i = 0; i < initArray.length; i++) {
            expandedArray[i] = initArray[i];
        }
        return expandedArray;
    }

    public static Object[] shiftElements(Object[] array, int index) {

        if (index < 1) {
            for (int i = array.length - 1; i >= index + 1; i--) {
                array[i] = array[i - 1];
            }
        } else {
            for (int i = array.length - 1; i >= index; i--) {
                array[i] = array[i - 1];
            }
        }
        return array;
    }
}