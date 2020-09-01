package com.ochodek.drivers;

import com.ochodek.common.CommunicationHelper;
import com.ochodek.exceptions.GameEndException;
import com.ochodek.exceptions.ItemNotFoundByNameException;
import com.ochodek.exceptions.PlayerWantToLoadGameException;
import com.ochodek.exceptions.PlayerWantToPlayNewGameException;
import com.ochodek.gameOptions.LoadSaveHelper;
import com.ochodek.levels.BasicLevel;
import com.ochodek.gameOptions.InExploreActions;
import com.ochodek.objects.PlayerCharacter;
import com.ochodek.objects.enemies.Enemy;
import com.ochodek.objects.items.Item;
import com.ochodek.objects.items.armours.Armour;
import com.ochodek.objects.items.medicaments.FirstAidKit;
import com.ochodek.objects.items.medicaments.FirstAidKitType;
import com.ochodek.objects.items.weapons.Weapon;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static com.ochodek.drivers.DriverUtils.BACK;
import static com.ochodek.drivers.DriverUtils.printMedkitInfo;

public class ExploreDriver {


    private final BasicLevel level;
    private final PlayerCharacter playerCharacter;
    private final Enemy enemy;
    private final Scanner console;

    public ExploreDriver(PlayerCharacter playerCharacter, BasicLevel level, Scanner console) {
        this.playerCharacter = playerCharacter;
        this.level = level;
        this.enemy = level.getEnemy();
        this.console = console;
    }

    public void startLevel() {
        CommunicationHelper.createMainInfo(level.getArriveAreaDescription());
        if (enemy != null && !enemy.getLifePoints().isDead()) {
            CommunicationHelper.createMainInfo(level.getEnemyDescription());
            FightDriver fightDriver = new FightDriver(playerCharacter, enemy, console);
            fightDriver.startFight();

        }
        boolean doMoreActions = true;
        while (doMoreActions) {
            doMoreActions = doAction(readUserAction());
        }
        CommunicationHelper.createMainInfo(level.getExitAreaDescription());
    }

    private InExploreActions readUserAction() {
        InExploreActions action = null;
        while (action == null) {
            try {
                CommunicationHelper.createAdditionalInfo(String.format("Choose action. Available actions: %s", InExploreActions.getActionNames()));
                action = InExploreActions.valueOf(console.nextLine());
            } catch (IllegalArgumentException e) {
                CommunicationHelper.createErrorInfo("Invalid command");
            }
        }
        return action;
    }

    private boolean doAction(InExploreActions action) {
        switch (action) {
            case SEARCH_AREA_FOR_ITEMS:
                searchAreaForItemsAction();
                return true;
            case EQUIP_FROM_BACKPACK:
                equipFromBackpackAction();
                return true;
            case USE_MEDKIT:
                useMedkitAction();
                return true;
            case GET_INFO:
                getInfoAction();
                return true;
            case GO_TO_NEXT_LEVEL:
                return false;
            case START_NEW_GAME:
                throw new PlayerWantToPlayNewGameException("You want to play new game");
            case SAVE_GAME:
                LoadSaveHelper.saveProgress(playerCharacter, level);
                return true;
            case LOAD_GAME:
                loadGameAction();
                return true;
            case EXIT_GAME:
                throw new GameEndException("Game over");
        }
        return false;
    }

    private void searchAreaForItemsAction() {
        CommunicationHelper.createAdditionalInfo("You start searching area for loot");
        List<Item> items = level.searchAreaForItems();
        if (items.isEmpty()) {
            CommunicationHelper.createAdditionalInfo("You didn't find anything useful");
        } else {
            CommunicationHelper.createAdditionalInfo("You found:");
            items.forEach(item -> {
                CommunicationHelper.createAdditionalInfo(item.getItemName());
                playerCharacter.getBackpack().putIntoBackpack(item);
            });
        }

    }

    private void equipFromBackpackAction() {
        Item item = null;
        while (item == null) {
            try {
                printBackpackInfo();
                String userInput = console.nextLine();
                if (BACK.equals(userInput)) {
                    return;
                }
                item = playerCharacter.getBackpack().grabItemFromBackpack(userInput);
            } catch (ItemNotFoundByNameException e) {
                CommunicationHelper.createErrorInfo(e.getMessage());
                return;
            }
        }
        wearItem(item);
    }

    private void printBackpackInfo() {
        Map<String, Long> stringLongMap = playerCharacter.getBackpack().showAllNotMedkitItemsInBackpack();
        CommunicationHelper.createAdditionalInfo("Availible items:");
        for (Map.Entry<String, Long> entry : stringLongMap.entrySet()) {
            CommunicationHelper.createAdditionalInfo(String.format("%s, amount %d", entry.getKey(), entry.getValue()));
        }
        CommunicationHelper.createAdditionalInfo(String.format("Type %s to return, type item name to grab it", BACK));
    }

    private void wearItem(Item item) {
        Item playerItem;
        if (item instanceof Weapon) {
            playerItem = playerCharacter.getWeapon();
            playerCharacter.setWeapon((Weapon) item);
        } else {
            playerItem = playerCharacter.getArmour();
            playerCharacter.setArmour((Armour) item);
        }
        playerCharacter.getBackpack().putIntoBackpack(playerItem);
        CommunicationHelper.createAdditionalInfo(String.format("You managed to wear a %s", item.getItemName()));
        CommunicationHelper.createAdditionalInfo(String.format("You put %s in Your backpack", playerItem.getItemName()));
    }

    private void useMedkitAction() {
        FirstAidKit medkit = null;
        while (medkit == null) {
            try {
                printMedkitInfo(playerCharacter);
                String userInput = console.nextLine();
                if (BACK.equals(userInput)) {
                    return;
                }
                FirstAidKitType firstAidKitType = FirstAidKitType.valueOf(userInput);
                medkit = (FirstAidKit) playerCharacter.getBackpack().grabItemFromBackpack(firstAidKitType.name());
            } catch (IllegalArgumentException e) {
                CommunicationHelper.createErrorInfo("Invalid action");
                return;
            }
        }
        playerCharacter.healYourself(medkit);
    }

    private void getInfoAction() {
        playerCharacter.printFullInfo();
    }

    private void loadGameAction() {
        if (LoadSaveHelper.loadPlayerCharacter() != null && LoadSaveHelper.loadLevel() != null) {
            throw new PlayerWantToLoadGameException("Player want to load game");
        } else {
            CommunicationHelper.createErrorInfo("There is no saved game");
        }
    }

}
