package com.darren.game;

import com.darren.game.actions.*;
import com.darren.game.exceptions.InvalidCommandException;

import java.util.ArrayList;
import java.util.Arrays;

public class Command {
    private String[] commands;
    private Action[] actions;

    public Command(String[] inputCommands) {
        commands = inputCommands;
    }

    public Action[] getActions() {
        trim();
        actions = new Action[commands.length];

        for (int i=0; i<commands.length; i++)
            actions[i] = getActionBy(commands[i]);

        return actions;
    }

    private void trim() {
        /*
            Action only start from 'PLACE'
            ignore all actions before 'PLACE'.
        */
        ArrayList<Integer> indices = new ArrayList<>();

        for (int i=0; i<commands.length; i++)
            if (isFirstAction(commands[i])) indices.add(i);

        commands = Arrays.copyOfRange(commands, indices.get(indices.size() - 1), commands.length);
    }

    private boolean isFirstAction(String command) {
        return command.contains("PLACE");
    }

    private Action getActionBy(String inputCommand) {
        if (isFirstAction(inputCommand))
            return new Placement(inputCommand);
        if (inputCommand.equals("MOVE"))
            return new Movement(inputCommand, 1);
        if (inputCommand.equals("LEFT"))
            return new LeftTurn(inputCommand);
        if (inputCommand.equals("RIGHT"))
            return new RightTurn(inputCommand);
        if (inputCommand.equals("REPORT"))
            return new Report(inputCommand);
        return null;
    }
}
