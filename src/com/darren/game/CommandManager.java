package com.darren.game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

abstract public class CommandManager {
    private static String[] commands;
    private static String[][] commandGroups;

    public static String[] getCommandsFromFile(String fileName) {
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
        return getSingleGroupOfCommands();
    }

    private static String[] getSingleGroupOfCommands() {
        groupCommands();
        return commandGroups[commandGroups.length-1];
    }

    private static void groupCommands() {
        /*
            Action only start from 'PLACE'
            ignore all actions before 'PLACE'.
        */
        ArrayList<Integer> indices = new ArrayList<>();

        for (int i=0; i<commands.length; i++) {
            commands[i] = commands[i].trim();
            if (isFirstCommand(commands[i]))
                indices.add(i);
        }

        commandGroups = new String[indices.size()][];
        for (int i=0; i<commandGroups.length; i++) {
            int startIndex = indices.get(i);
            int endIndex = (i+1) >= indices.size() ? commands.length : indices.get(i+1);
            commandGroups[i] = Arrays.copyOfRange(commands, startIndex, endIndex);
        }
    }

    private static boolean isFirstCommand(String command) {
        return command.contains("PLACE");
    }
}
