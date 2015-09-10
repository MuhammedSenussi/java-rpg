package com.company.rpg.services.game;

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
