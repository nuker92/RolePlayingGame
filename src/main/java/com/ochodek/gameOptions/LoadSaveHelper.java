package com.ochodek.gameOptions;

import com.ochodek.common.CommunicationHelper;
import com.ochodek.levels.BasicLevel;
import com.ochodek.objects.PlayerCharacter;

public class LoadSaveHelper {

    private static PlayerCharacter playerCharacter;
    private static BasicLevel level;

    public static void saveProgress(PlayerCharacter playerCharacter, BasicLevel level) {
        LoadSaveHelper.playerCharacter = new PlayerCharacter(playerCharacter);
        LoadSaveHelper.level = createCopyOfLevel(level);
    }

    public static PlayerCharacter loadPlayerCharacter() {
        return new PlayerCharacter(LoadSaveHelper.playerCharacter);
    }

    public static BasicLevel loadLevel() {
        return createCopyOfLevel(LoadSaveHelper.level);
    }

    private static BasicLevel createCopyOfLevel(BasicLevel level) {
        BasicLevel copyOfLevel = null;
        try {
            copyOfLevel = level.getClass().getConstructor().newInstance();
            copyOfLevel.setEnemy(null);
            copyOfLevel.setItemsInArea(level.getItemsInArea());
            copyOfLevel.setLevelNumber(level.getLevelNumber());
        } catch (Exception e) {
            CommunicationHelper.createErrorInfo("Unable to save game.");
        }
        return copyOfLevel;
    }

}
