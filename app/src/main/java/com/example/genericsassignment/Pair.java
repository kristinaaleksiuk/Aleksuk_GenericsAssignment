package com.example.genericsassignment;

/** Задание 1. Дженерик-кортеж из двух значений любых типов. */
public class Pair<A, B> {

    private A first;
    private B second;

    // Конструктор, принимающий оба значения
    public Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    // Геттеры
    public A getFirst() { return first; }

    public B getSecond() { return second; }

    // Сеттеры
    public void setFirst(A first) { this.first = first; }

    public void setSecond(B second) { this.second = second; }

    // Красивый вывод пары
    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }

    // Возвращает новую пару с поменянными местами значениями
    public Pair<B, A> swap() {
        return new Pair<>(this.second, this.first);
    }
}
