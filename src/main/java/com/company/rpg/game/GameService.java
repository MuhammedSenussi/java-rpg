package com.company.rpg.game;

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
    void save();

    /**
     *
     */
    void load();

    /**
     *
     */
    void exit();
}
