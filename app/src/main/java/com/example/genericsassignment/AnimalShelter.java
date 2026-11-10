package com.example.genericsassignment;

import java.util.ArrayList;
import java.util.List;

/** Задание 4. Приют с ограничением верхней границы T extends Animal. */
class AnimalShelter<T extends Animal> {

    private final List<T> shelter = new ArrayList<>();

    public void add(T animal) {
        shelter.add(animal);
    }

    public List<T> getAll() {
        return shelter;
    }

    public void printNames() {
        for (T animal : shelter) {
            System.out.println(animal.getName());
        }
    }
}
