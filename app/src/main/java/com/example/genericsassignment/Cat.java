package com.example.genericsassignment;

class Cat extends Animal {

    private final String name;

    public Cat(String name) { this.name = name; }

    @Override
    String getName() { return name; }
}
