package com.company.rpg.battle;

import com.company.rpg.model.Hero;
import com.company.rpg.model.NPC;

import java.io.IOException;

public interface BattleService {

    void battle(Hero hero, NPC monster) throws IOException;
}
