package com.example.genericsassignment;

/** Задание 3. Утилитарные дженерик-методы. */
public class Utils {

    // Базовая версия (через equals)
    public static <T> boolean contains(T[] array, T value) {
        if (array == null) return false;
        for (T element : array) {
            if (element == null && value == null) return true;
            if (element != null && element.equals(value)) return true;
        }
        return false;
    }

    // Перегруженная версия (через compareTo)
    public static <T extends Comparable<T>> boolean contains(T[] array, T value) {
        if (array == null) return false;
        for (T element : array) {
            if (element == null && value == null) return true;
            if (element != null && value != null && element.compareTo(value) == 0) return true;
        }
        return false;
    }
}
