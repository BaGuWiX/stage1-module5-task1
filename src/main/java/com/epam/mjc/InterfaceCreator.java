package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return list -> {
            for (String str : list) {
                if (!Character.isUpperCase(str.charAt(0))) {
                    return false;
                }
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            List<Integer> evenValues = new ArrayList<>();
            for (int i = 0; i < x.size(); i++) {
                if (x.get(i) % 2 == 0) {
                    evenValues.add(x.get(i));
                }
            }
            x.addAll(evenValues);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> filteredList = new ArrayList<>();
            for (String value : values) {
                if (isValidString(value)) {
                    filteredList.add(value);
                }
            }
            return filteredList;
        };
    }

    private static boolean isValidString(String value) {
        if (!Character.isUpperCase(value.charAt(0))) {
            return false;
        }

        if (!value.endsWith(".")) {
            return false;
        }

        String[] words = value.split(" ");
        if (words.length <= 3) {
            return false;
        }

        return true;
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            Map<String, Integer> resultMap = new HashMap<>();
            for (String str : x) {
                resultMap.put(str, str.length());
            }
            return resultMap;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            List<Integer> result = new ArrayList<>(list1);
            result.addAll(list2);
            return result;
        };
    }
}
