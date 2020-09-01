package com.ochodek.gameOptions;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum InExploreActions {
    SEARCH_AREA_FOR_ITEMS,
    EQUIP_FROM_BACKPACK,
    USE_MEDKIT,
    GET_INFO,
    GO_TO_NEXT_LEVEL,
    START_NEW_GAME,
    SAVE_GAME,
    LOAD_GAME,
    EXIT_GAME,

    ;

    public static String getActionNames() {
        return Arrays.stream(InExploreActions.values())
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
