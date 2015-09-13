package com.company.rpg.repository;

import com.company.rpg.model.GameContext;

public class GameContextRepository {

    private GameContext gameContext;

    public GameContext getGameContext() {
        if (gameContext == null) {
            gameContext = new GameContext();
        }
        return gameContext;
    }


}
