package com.darren.game.readers;

import com.darren.game.actions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CommandManager {
    private String[] commands;
    private Action[] actions;
    private String fileName;

    public CommandManager(String fileName) {
        this.fileName = fileName;
    }

    private void getCommandsFromFile() {
        List<String> lines = new ArrayList<>();
        try {
            var file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine())
                lines.add(scanner.nextLine());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        commands = lines.toArray(new String[lines.size()]);
    }

    public Action[] getActions() {
        getCommandsFromFile();
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
