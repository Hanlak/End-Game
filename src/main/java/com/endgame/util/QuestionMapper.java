package com.endgame.util;

import java.util.HashMap;
import java.util.Map;

public class QuestionMapper {
    public static Map<String, Integer> questIdAnsMap() {
        Map<String, Integer> questionidmapper = new HashMap<>();

        questionidmapper.put("Popcorn", 1);
        questionidmapper.put("IceCream", 1);
        questionidmapper.put("Drink", 1);
        questionidmapper.put("FrenchFries", 1);
        questionidmapper.put("NorthIndia", 2);
        questionidmapper.put("southIndia", 2);
        questionidmapper.put("eastasia", 2);
        questionidmapper.put("europe", 2);
        //TODO ADD other 10 Questions as well
        return questionidmapper;
    }
}
