package com.example.genericsassignment;

import java.util.ArrayList;
import java.util.EmptyStackException;

/** Задание 2. Универсальный стек (LIFO). */
public class MyStack<E> {

    private final ArrayList<E> elements = new ArrayList<>();

    public void push(E element) {
        elements.add(element);
    }

    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elements.remove(elements.size() - 1);
    }

    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elements.get(elements.size() - 1);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public int size() {
        return elements.size();
    }
}
