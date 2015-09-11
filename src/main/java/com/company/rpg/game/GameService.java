package com.company.rpg.game;

import com.company.rpg.ui.TextUIController;

import java.io.IOException;

/**
 *
 */
public interface GameService {

    /**
     *
     */
    void startNewGame() throws IOException;

    /**
     *
     */
    void save(GameState gameState);


    /**
     *
     */
    GameState load();

    /**
     *
     */
    void exit();

    TextUIController getUiController();
}
