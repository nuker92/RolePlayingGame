package com.ochodek.gameOptions;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum InFightAction {

    ATTACK,
    USE_MEDKIT,
    GET_INFO,
    WAIT,

    ;

    public static String getActionNames() {
        return Arrays.stream(InFightAction.values())
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

}
