package com.company.rpg.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextUIController {

    private BufferedReader inputReader;

    public TextUIController() {
        inputReader = new BufferedReader(new InputStreamReader(System.in));
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


}
