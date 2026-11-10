package com.example.genericsassignment;

/** Задание 6. Дженерик-интерфейс. */
interface Transformer<F, T> {
    T transform(F from);
}
