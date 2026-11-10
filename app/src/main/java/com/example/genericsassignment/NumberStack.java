package com.example.genericsassignment;

/** Задание 2. Стек только для чисел (E extends Number). */
public class NumberStack<E extends Number> extends MyStack<E> {
    // Наследует всю логику MyStack, но принимает только Number и его наследников
}
