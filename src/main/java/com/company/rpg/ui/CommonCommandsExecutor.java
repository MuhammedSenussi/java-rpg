package com.company.rpg.ui;

import com.company.rpg.model.GameContext;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;

/**
 * Utility class contains common game methods
 *
 * @author Dmitriy Karmanov
 * @since 1.0
 */
public class CommonCommandsExecutor {

    /**
     * Iterate over "save" directory and output to the user's console
     * list of all saved games in menu view (numbered list, with ability to select)
     * Deserialize selected file to {@link GameContext} class instance and return it.
     *
     * @return deserialized file to {@link GameContext} class instance
     */
    public static GameContext load() {
        return null;
    }

    /**
     * Serialize given {@link GameContext} instance to the file under "save" directory
     * with current timestamp as file name
     *
     * @param gameContext to serialize
     */
    public static void save(GameContext gameContext) {
        System.out.println("Saving current game....");
        LocalDateTime localDateTime = LocalDateTime.now();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("save/" + localDateTime.toString() + ".ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(gameContext);
            System.out.println("Saved game to the file: " + localDateTime + ".ser");
        } catch (IOException e) {
            System.err.println("Could not save game. Reason: " + e.getMessage());
        }
    }

    /**
     * Exit from the game
     */
    public static void exit() {
        System.out.println("Thanks you for playing Java RPG.");
        System.exit(0);
    }
}
