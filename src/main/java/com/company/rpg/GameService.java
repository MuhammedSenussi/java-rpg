package com.company.rpg;

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
}
