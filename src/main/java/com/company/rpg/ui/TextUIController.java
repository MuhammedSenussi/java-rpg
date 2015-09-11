package com.company.rpg.ui;

import com.company.rpg.game.GameState;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class TextUIController {

    private BufferedReader inputReader;

    public TextUIController() {
        this.inputReader = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * @param numberOfParameters
     * @return
     */
    public int getSelection(int numberOfParameters) {
        int result = -1;
        try {
            do {
                String input = inputReader.readLine();
                try {
                    result = Integer.parseInt(input);
                    if (result < 0 || result > numberOfParameters) {
                        //TODO refactor this
                        System.out.println("Not a valid option!");
                        result = -1;
                    }
                } catch (NumberFormatException numberException) {
                    System.out.println("Please enter a number from 1 to " + numberOfParameters);
                    result = -1;
                }

            } while (result == -1);
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            System.exit(1);
        }
        System.out.println("");
        return result;
    }

    public String readInput() throws IOException {
        return inputReader.readLine();
    }

    public void printInto() {
        System.out.println("This is game into");
    }

    public void printMessage(String message) {
        int msgLength = message.length();
        printBorder(msgLength);
        System.out.println(message);
        printBorder(msgLength);
    }

    private void printBorder(int size) {
        for (int i = 0; i < size; i++) {
            System.out.print("-");
        }
        System.out.println("");
    }

    public void printIndexedList(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + 1 + ". " + list.get(i));
        }
    }

    public Stream<String> loadConfigFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        return Files.lines(path);
    }

    public void exitWithError(String message) {
        System.err.print(message);
        System.exit(-1);
    }
}
