package com.endgame.util;

import java.util.Random;

public class RandomPassword {
    public static String randomPassword() {
        Random random = new Random();
        String generatePin = String.format("%04d", random.nextInt(10000));
        return "RP" + generatePin + "EG";
    }
}
