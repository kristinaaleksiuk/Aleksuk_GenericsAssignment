package com.example.genericsassignment;

import java.util.ArrayList;
import java.util.List;

/** Применяет Transformer ко всем элементам списка и возвращает новый список. */
class TransformerApp {

    public static <F, T> List<T> transformList(List<F> list, Transformer<F, T> transformer) {
        List<T> result = new ArrayList<>();
        for (F item : list) {
            result.add(transformer.transform(item));
        }
        return result;
    }
}
