package com.ochodek.drivers;

import com.ochodek.common.CommunicationHelper;
import com.ochodek.exceptions.DeadException;
import com.ochodek.exceptions.GameEndException;
import com.ochodek.gameOptions.InFightAction;
import com.ochodek.objects.PlayerCharacter;
import com.ochodek.objects.enemies.Enemy;
import com.ochodek.objects.items.medicaments.FirstAidKit;
import com.ochodek.objects.items.medicaments.FirstAidKitType;

import java.util.Scanner;

import static com.ochodek.drivers.DriverUtils.BACK;
import static com.ochodek.drivers.DriverUtils.printMedkitInfo;

public class FightDriver {

    private final PlayerCharacter playerCharacter;
    private final Enemy enemy;
    private final Scanner console;

    public FightDriver(PlayerCharacter playerCharacter, Enemy enemy, Scanner console) {
        this.playerCharacter = playerCharacter;
        this.enemy = enemy;
        this.console = console;
    }

    public void startFight() {
        CommunicationHelper.createAdditionalInfo(String.format("You start a fight with %s", enemy.getName().getAsString()));
        while (!enemy.getLifePoints().isDead()) {
            try {
                doAction(readUserAction());
            } catch (DeadException e) {
                CommunicationHelper.createAdditionalInfo(String.format("%s %s", enemy.getName().getAsString(), e.getMessage()));
                break;
            }
            try {
                doEnemyAction();
            } catch (DeadException e) {
                CommunicationHelper.createAdditionalInfo(String.format("%s %s", enemy.getName().getAsString(),e.getMessage()));
                throw new GameEndException("You are dead. Game's over. Try again");
            }
        }
        CommunicationHelper.createAdditionalInfo(String.format("You successfully killed %s", enemy.getName().getAsString()));
    }

    private InFightAction readUserAction() {
        InFightAction action = null;
        while (action == null) {
            try {
                CommunicationHelper.createAdditionalInfo(String.format("Choose action. Available actions: %s", InFightAction.getActionNames()));
                action = InFightAction.valueOf(console.nextLine());
            } catch (IllegalArgumentException e) {
                CommunicationHelper.createErrorInfo("Invalid command");
            }
        }
        return action;
    }

    private void doAction(InFightAction action) {
        switch (action) {
            case ATTACK:
                attackEnemyAction();
                break;
            case USE_MEDKIT:
                useMedkitAction();
                break;
            case GET_INFO:
                getInfoAction();
                doAction(readUserAction());
        }
    }

    private void attackEnemyAction() {
        enemy.getDamage(playerCharacter.getCharacterAttack());
    }

    private void useMedkitAction() {
        boolean isMedkitUsed = useMedkit();
        if (!isMedkitUsed) {
            doAction(readUserAction());
        }
    }

    private boolean useMedkit() {
        FirstAidKit medkit = null;
        while (medkit == null) {
            try {
                printMedkitInfo(playerCharacter);
                String userInput = console.nextLine();
                if (BACK.equals(userInput)) {
                    return false;
                }
                FirstAidKitType firstAidKitType = FirstAidKitType.valueOf(userInput);
                medkit = (FirstAidKit) playerCharacter.getBackpack().grabItemFromBackpack(firstAidKitType.name());
            } catch (IllegalArgumentException e) {
                CommunicationHelper.createErrorInfo("Invalid action");
                return false;
            }
        }
        playerCharacter.healYourself(medkit);
        return true;
    }

    private void getInfoAction() {
        playerCharacter.printFullInfo();
        enemy.printFullInfo();
    }

    private void doEnemyAction() {
        playerCharacter.getDamage(enemy.attack());
    }

}
