package com.company.rpg.services;

import com.company.rpg.model.Hero;
import com.company.rpg.model.Monster;

import java.io.IOException;

public interface BattleService {

    void battle(Hero hero, Monster monster) throws IOException;
}
