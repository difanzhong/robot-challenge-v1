package com.darren.game;

import com.darren.game.actions.Action;
import com.darren.game.readers.CommandManager;

public class Game {
    public static void main(String[] args) {
//        String[] inputCommands = {"PLACE 1,2,EAST", "RIGHT", "MOVE", "RIGHT", "REPORT"};

        CommandManager command = new CommandManager("C:\\Users\\difan\\Desktop\\input.txt");
        Action.robot = new Robot();
        Action.map = new SquareMapSize5();
        Action[] actions = command.getActions();

        for (Action action: actions)
            action.on();
    }
}
