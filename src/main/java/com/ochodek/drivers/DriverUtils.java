package com.ochodek.drivers;

import com.ochodek.common.CommunicationHelper;
import com.ochodek.objects.PlayerCharacter;

import java.util.Map;

public interface DriverUtils {

    String BACK = "BACK";

    static void printMedkitInfo(PlayerCharacter playerCharacter) {
        Map<String, Long> stringLongMap = playerCharacter.getBackpack().showAllMedkitsInBackpack();
        CommunicationHelper.createAdditionalInfo("Availible medkits:");
        for (Map.Entry<String, Long> entry : stringLongMap.entrySet()) {
            CommunicationHelper.createAdditionalInfo(String.format("%s, amount %d", entry.getKey(), entry.getValue()));
        }
        CommunicationHelper.createAdditionalInfo(String.format("Type %s to return, type medkit name to use it", BACK));
    }
}
