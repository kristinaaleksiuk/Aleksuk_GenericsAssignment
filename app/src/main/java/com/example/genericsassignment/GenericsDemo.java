package com.example.genericsassignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;

/**
 * Запускает примеры из всех шести заданий и печатает результат через System.out.
 * Класс не зависит от Android, поэтому его можно запускать и как обычную Java-программу.
 */
public class GenericsDemo {

    public static void runAll() {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
    }

    private static void header(String title) {
        System.out.println();
        System.out.println("=== " + title + " ===");
    }

    // ---------- Задание 1 ----------
    static void task1() {
        header("Задание 1. Pair<A, B>");
        Pair<String, Integer> person = new Pair<>("Анна", 25);
        System.out.println(person);                         // (Анна, 25)

        Pair<Integer, String> swapped = person.swap();
        System.out.println(swapped);                        // (25, Анна)

        person.setFirst("Борис");
        person.setSecond(30);
        System.out.println(person.getFirst() + " / " + person.getSecond());
    }

    // ---------- Задание 2 ----------
    static void task2() {
        header("Задание 2. MyStack<E>");
        MyStack<Integer> stack = new MyStack<>();
        stack.push(10);
        stack.push(20);
        System.out.println(stack.pop());                    // 20
        System.out.println(stack.peek());                   // 10
        System.out.println("size = " + stack.size() + ", isEmpty = " + stack.isEmpty());

        stack.pop();
        try {
            stack.pop();
        } catch (EmptyStackException e) {
            System.out.println("pop() из пустого стека -> EmptyStackException");
        }
        try {
            stack.peek();
        } catch (EmptyStackException e) {
            System.out.println("peek() из пустого стека -> EmptyStackException");
        }

        NumberStack<Double> numbers = new NumberStack<>();
        numbers.push(3.14);
        numbers.push(2.71);
        System.out.println("NumberStack<Double>.pop() = " + numbers.pop());
        // NumberStack<String> bad = new NumberStack<>();   // ОШИБКА компиляции: String не Number
    }

    // ---------- Задание 3 ----------
    static void task3() {
        header("Задание 3. Utils.contains");
        String[] names = {"Анна", "Борис", "Вера"};
        Integer[] nums = {1, 2, 3, null};

        System.out.println("contains(names, \"Борис\") = " + Utils.contains(names, "Борис"));
        System.out.println("contains(names, \"Глеб\")  = " + Utils.contains(names, "Глеб"));
        System.out.println("contains(nums, 2)        = " + Utils.contains(nums, 2));
        System.out.println("contains(nums, null)     = " + Utils.contains(nums, null));
        System.out.println("contains(null, 1)        = " + Utils.contains((Integer[]) null, 1));
    }

    // ---------- Задание 4 ----------
    static void task4() {
        header("Задание 4. AnimalShelter<T extends Animal>");

        AnimalShelter<Dog> dogShelter = new AnimalShelter<>();
        dogShelter.add(new Dog("Бобик"));
        dogShelter.add(new Dog("Шарик"));
        // dogShelter.add(new Cat("Мурка"));   // ОШИБКА компиляции: Cat не Dog
        System.out.println("Приют для собак:");
        dogShelter.printNames();

        AnimalShelter<Animal> anyShelter = new AnimalShelter<>();
        anyShelter.add(new Dog("Рекс"));
        anyShelter.add(new Cat("Мурка"));
        System.out.println("Приют для любых животных:");
        anyShelter.printNames();
        System.out.println("Всего животных: " + anyShelter.getAll().size());
    }

    // ---------- Задание 5 ----------
    static void task5() {
        header("Задание 5. copy() и PECS");

        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("Бобик"));
        dogs.add(new Dog("Шарик"));

        List<Animal> animals = new ArrayList<>();
        animals.add(new Cat("Мурка"));

        CollectionUtils.copy(dogs, animals);                // Dog -> Animal: работает
        System.out.println("После copy(List<Dog>, List<Animal>):");
        for (Animal a : animals) {
            System.out.println("  " + a.getName());
        }

        // List<Animal> src = new ArrayList<>();
        // List<Dog> dst = new ArrayList<>();
        // CollectionUtils.copy(src, dst);   // ОШИБКА компиляции: нельзя класть Animal в List<Dog>
        System.out.println("copy(List<Animal>, List<Dog>) не компилируется (см. комментарий в коде)");
    }

    // ---------- Задание 6 ----------
    static void task6() {
        header("Задание 6. Transformer<F, T>");

        List<String> words = Arrays.asList("Java", "дженерики", "Android");
        List<Integer> lengths = TransformerApp.transformList(words, new StringToLength());
        System.out.println("Длины строк: " + lengths);

        List<Number> numbers = Arrays.<Number>asList(1, 2.5, 3L);
        List<String> strings = TransformerApp.transformList(numbers, new NumberToString());
        System.out.println("Числа в строки: " + strings);
    }
}
