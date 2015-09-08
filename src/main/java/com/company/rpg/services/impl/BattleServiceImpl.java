package com.company.rpg.services.impl;

import com.company.rpg.MenuUtils;
import com.company.rpg.RandomUtil;
import com.company.rpg.model.Hero;
import com.company.rpg.model.Monster;
import com.company.rpg.services.BattleService;
import com.company.rpg.services.CommandsReaderService;

import java.io.IOException;

/**
 * Created by karmanov on 9/7/15.
 */
public class BattleServiceImpl implements BattleService {

    private CommandsReaderService commandsReaderService;

    public BattleServiceImpl(CommandsReaderService commandsReaderService) {
        this.commandsReaderService = commandsReaderService;
    }

    public void battle(Hero hero, Monster monster) throws IOException {
        boolean readyToEscape = false;
        int heroHealth = hero.getHealth();
        int monsterHealth = monster.getHealth();
        while (heroHealth > 0 && monsterHealth > 0 && !readyToEscape) {
            printMessage(hero.getName() + "'s health: " + heroHealth + " | " + monster.getName() + "'s Health: " + monsterHealth, false);
            System.out.println("");
            System.out.println("What would you like to do?");
            System.out.println("");
            System.out.println("1. Attack " + monster.getName());
            System.out.println("2. Charge Attack");
            System.out.println("3. Escape from battle");
            System.out.print(" > ");

            int selection = MenuUtils.getSelection(3);
            //Player turn
            if (selection == 1) {
                int monsterDodge = RandomUtil.nextInt(10) + 1;
                if (monsterDodge >= 9) { // Failed attack
                    printMessage(monster.getName() + " dodged your attack!", false);
                } else if (monsterDodge <= 8) { // Successful attack
                    int damage = hero.getDamage() + RandomUtil.nextInt(hero.getDamage()) - RandomUtil.nextInt(monster.getDefence());
                    if (damage < 0) {
                        damage = 0;
                    }
                    monsterHealth -= damage;
                    printMessage(hero.getName() + " hits " + monster.getName() + " for " + damage + " damage!", false);

                }
            } else if (selection == 2) {
                printMessage("You begin charging your attack!", false);
                hero.increaseDamageOnOnePoint();
                System.out.println("Press enter to continue...");
                commandsReaderService.readInput();
            } else if (selection == 3) {
                int escapeChance = RandomUtil.nextInt(hero.getAgility());
                int failChance = RandomUtil.nextInt(monster.getDefence());
                readyToEscape = true;
                if (escapeChance >= failChance) {
                    System.out.println("-------------------------------------------");
                    System.out.println("You successfully escape the " + monster.getName() + "!");
                    System.out.println("-------------------------------------------");
                    System.out.println("Press enter to continue...");
                    commandsReaderService.readInput();
                    break;
                } else {
                    System.out.println("----------------------------------");
                    System.out.println("You failed at escaping!");
                    System.out.println("----------------------------------");
                    System.out.println("Press enter to continue...");
                    commandsReaderService.readInput();
                }

            }

            //Enemy turn
            if (monsterHealth > 0 && heroHealth > 0) {
                int monsterDamage = monster.getDamage() + RandomUtil.nextInt(monster.getDamage()) - RandomUtil.nextInt(hero.getDefence());
                if (monsterDamage < 0) {
                    monsterDamage = 0;
                }
                int monsterHitPlayer = RandomUtil.nextInt(100) + 1;
                if (monsterHitPlayer > 15) {
                    heroHealth -= monsterDamage;
                    printMessage(monster.getName() + " hits " + hero.getName() + " for " + monsterDamage + " damage!", true);
                    commandsReaderService.readInput();
                } else if (monsterHitPlayer <= 15) {
                    printMessage(monster.getName() + " misses " + hero.getName() + "!", true);
                    commandsReaderService.readInput();
                }


            }
        }
        if (heroHealth <= 0) {
            System.out.println("You are dead!");
            System.exit(0);
            //TODO game over logic
        } else if (monsterHealth <= 0) {
            System.out.println("--------------------------------");
            System.out.println(hero.getName() + " has defeated " + monster.getName() + "!");
            System.out.println("You earn " + monster.getExpCost() + " exp on the enemy.");
            System.out.println("--------------------------------");
            hero.addExp(monster.getExpCost());
            System.out.println("Press enter to continue...");
        }
        commandsReaderService.readInput();
    }

    private void printMessage(String message, boolean isNextMoveExpected) {
        System.out.println("------------------------------------");
        System.out.println(message);
        System.out.println("------------------------------------");
        if (isNextMoveExpected) {
            System.out.println("Press enter to continue...");
        }
    }
}
