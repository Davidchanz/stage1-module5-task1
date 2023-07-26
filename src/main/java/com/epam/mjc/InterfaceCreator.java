package com.epam.mjc;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return strings -> {
            for(var string: strings){
                if(!Character.isUpperCase(string.charAt(0)) || !Character.isLetter(string.charAt(0)))
                    return false;
            }
            return true;
        };
        //throw new UnsupportedOperationException("You should implement this method.");
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return integers -> {
            for (int integer : integers.toArray(new Integer[0])) {
                if (integer % 2 == 0) {
                    integers.add(integer);
                }
            }
        };
        //throw new UnsupportedOperationException("You should implement this method.");
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            for(var string: values.toArray(new String[0])){
                if(!Character.isUpperCase(string.charAt(0)) ||
                   !Character.isLetter(string.charAt(0)) ||
                   !string.endsWith(".") ||
                   string.split(" ").length <= 3
                ){
                    values.remove(string);
                }
            }
            return values;
        };
        //throw new UnsupportedOperationException("You should implement this method.");
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return strings -> {
            Map<String, Integer> result = new HashMap<>();
            strings.forEach(string -> {
                result.put(string, string.length());
            });
            return result;
        };
        //throw new UnsupportedOperationException("You should implement this method.");
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (first, second) -> {
            return Stream.concat(first.stream(), second.stream()).collect(Collectors.toList());
        };
        //throw new UnsupportedOperationException("You should implement this method.");
    }
}
