package com.example.genericsassignment;

class Dog extends Animal {

    private final String name;

    public Dog(String name) { this.name = name; }

    @Override
    String getName() { return name; }
}
