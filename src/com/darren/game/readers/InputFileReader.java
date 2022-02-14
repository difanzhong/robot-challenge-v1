package com.darren.game.readers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class InputFileReader extends FileReader implements commandObtainable {
    private List<String> lines;

    public InputFileReader(String fileName) throws FileNotFoundException {
        super(fileName);
    }

    public String[] getInputCommands() {
        try ( var bufferedReader = new BufferedReader(this) ) {
            String line = bufferedReader.readLine();
            while (line != null)
                lines.add(line);
        } catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return lines.toArray(new String[lines.size()]);
    }
}
