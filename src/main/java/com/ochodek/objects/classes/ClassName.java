package com.ochodek.objects.classes;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum ClassName {

    WARRIOR,
    ARCHER,
    ;



    public static String getClassesNames() {
        return Arrays.stream(ClassName.values())
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
