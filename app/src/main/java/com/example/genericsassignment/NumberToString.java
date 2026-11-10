package com.example.genericsassignment;

/** Число -> строка. */
class NumberToString implements Transformer<Number, String> {

    @Override
    public String transform(Number from) {
        return from == null ? "" : String.valueOf(from);
    }
}
