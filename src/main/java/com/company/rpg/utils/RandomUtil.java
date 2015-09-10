package com.company.rpg.utils;

import java.util.Random;

/**
 * Created by karmanov on 9/7/15.
 */
public class RandomUtil {

    private static Random random = new Random();

    public static int nextInt(int base) {
        return random.nextInt(base);
    }
}
