package com.ochodek;

import com.ochodek.common.CommunicationHelper;
import com.ochodek.drivers.GameDriver;

public class StartGame {

    public static void main(String[] args) {
        CommunicationHelper.createMainInfo("The Game started");
        GameDriver gameDriver = new GameDriver();
        gameDriver.startGame();
    }




}
