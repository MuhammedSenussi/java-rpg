package com.company.rpg.game.battle;

import com.company.rpg.map.locations.Location;
import com.company.rpg.map.locations.LocationType;
import com.company.rpg.game.model.NPC;
import com.company.rpg.game.model.Player;
import com.company.rpg.ui.menu.AbstractMenu;
import com.company.rpg.ui.menu.BattleMenu;
import com.company.rpg.utils.RandomUtil;

/**
 * Basic implementation of {@link BattleService}
 *
 * @author Dmitriy Karmanov
 * @since 1.0
 */
public class BattleServiceImpl implements BattleService {

    private AbstractMenu menu;

    public BattleServiceImpl() {
        menu = new BattleMenu();
    }

    /**
     * {@inheritDoc}
     */
    public void battle(Player hero, Location location) {
        NPC monster = (NPC) location.getLocationItem();
        boolean readyToEscape = false;
        int heroHealth = hero.getCurrentHealth();
        int monsterHealth = monster.getCurrentHealth();
        while (heroHealth > 0 && monsterHealth > 0 && !readyToEscape) {
            printMessage(hero.getName() + "'s health: " + heroHealth + " | " + monster.getName() + "'s Health: " + monsterHealth, false);
            menu.showMenu();
            int selection = menu.getSelectionIndex();

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
            } else if (selection == 3) {
                int escapeChance = RandomUtil.nextInt(hero.getAgility());
                int failChance = RandomUtil.nextInt(monster.getDefence());
                readyToEscape = true;
                if (escapeChance >= failChance) {
//                    System.out.println("-------------------------------------------");
                    System.out.println("You successfully escape the " + monster.getName() + "!");
//                    System.out.println("-------------------------------------------");
//                    System.out.println("Press enter to continue...");
                    break;
                } else {
//                    System.out.println("----------------------------------");
                    System.out.println("You failed at escaping!");
//                    System.out.println("----------------------------------");
//                    System.out.println("Press enter to continue...");
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
                } else if (monsterHitPlayer <= 15) {
                    printMessage(monster.getName() + " misses " + hero.getName() + "!", true);
                }


            }
        }
        if (heroHealth <= 0) {
            System.out.println("You are dead!");
            System.exit(0);
            //TODO game over logic
        } else if (monsterHealth <= 0) {
//            System.out.println("--------------------------------");
            System.out.println(hero.getName() + " has defeated " + monster.getName() + "!");
            System.out.println("You earn " + monster.getExpCost() + " exp on the enemy.");
//            System.out.println("--------------------------------");
            hero.addExp(monster.getExpCost());
            location.setLocationItem(null);
            location.setLocationType(LocationType.EMPTY);
            location.setIsOpened(true);
            System.out.println("Press enter to continue...");
        }
    }

    private void printMessage(String message, boolean isNextMoveExpected) {
//        System.out.println("------------------------------------");
        System.out.println(message);
//        System.out.println("------------------------------------");
        if (isNextMoveExpected) {
            System.out.println("Press enter to continue...");
        }
    }
}
