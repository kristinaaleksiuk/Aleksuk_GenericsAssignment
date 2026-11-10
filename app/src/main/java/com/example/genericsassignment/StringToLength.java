package com.example.genericsassignment;

/** Строка -> длина строки. */
class StringToLength implements Transformer<String, Integer> {

    @Override
    public Integer transform(String from) {
        return from == null ? 0 : from.length();
    }
}
