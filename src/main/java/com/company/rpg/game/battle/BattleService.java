package com.company.rpg.game.battle;

import com.company.rpg.model.Player;
import com.company.rpg.model.NPC;

public interface BattleService {

    void battle(Player hero, NPC monster);
}