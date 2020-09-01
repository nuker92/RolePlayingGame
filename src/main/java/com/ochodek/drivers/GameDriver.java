package com.ochodek.drivers;

import com.ochodek.common.CommunicationHelper;
import com.ochodek.exceptions.InvalidLevelNumber;
import com.ochodek.exceptions.PlayerWantToLoadGameException;
import com.ochodek.exceptions.PlayerWantToPlayNewGameException;
import com.ochodek.gameOptions.LoadSaveHelper;
import com.ochodek.generators.CharacterCreator;
import com.ochodek.levels.*;
import com.ochodek.objects.PlayerCharacter;

import java.util.Scanner;

public class GameDriver {

    private Scanner console;
    int actualLevel = 0;

    public GameDriver() {
        console = new Scanner(System.in);
    }

    public void startGame() {
        PlayerCharacter character = null;

        boolean loadGame = false;
        boolean newGame = true;
        ExploreDriver exploreDriver;

        while (true) {
            if (newGame) {
                character = CharacterCreator.createCharacter(console);
                newGame = false;
                exploreDriver = new ExploreDriver(character, new FirstLevel(), console);
                actualLevel = 0;
            } else if (loadGame) {
                character = LoadSaveHelper.loadPlayerCharacter();
                exploreDriver = new ExploreDriver(character, LoadSaveHelper.loadLevel(), console);
                actualLevel = LoadSaveHelper.loadLevel().getLevelNumber();
                loadGame = false;
            } else {
                exploreDriver = new ExploreDriver(character, getCorrectLevel(), console);
            }
            try {
                exploreDriver.startLevel();
                actualLevel++;
            } catch (PlayerWantToPlayNewGameException exception) {
                CommunicationHelper.createMainInfo(exception.getMessage());
                newGame = true;
            } catch (PlayerWantToLoadGameException playerWantToLoadGameException) {
                CommunicationHelper.createMainInfo("Loading saved Game");
                loadGame = true;
            }

        }
    }

    private BasicLevel getCorrectLevel() {
        switch (actualLevel) {
            case 0 :
                return new FirstLevel();
            case 1 :
                return new SecondLevel();
            case 2 :
                return new ThirdLevel();
            case 3 :
                return new FourthLevel();
            case 4 :
                return new FifthLevel();
        }
        throw new InvalidLevelNumber("Journey is over");
    }

}
