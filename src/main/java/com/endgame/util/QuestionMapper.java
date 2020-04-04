package com.endgame.util;

import java.util.HashMap;
import java.util.Map;

public class QuestionMapper {
    public static Map<String, Integer> questIdAnsMap() {
        Map<String, Integer> questionidmapper = new HashMap<>();
        //Question1
        questionidmapper.put("Popcorn", 1);
        questionidmapper.put("IceCream", 1);
        questionidmapper.put("Drink", 1);
        questionidmapper.put("FrenchFries", 1);
        //Question2
        questionidmapper.put("NorthIndia", 2);
        questionidmapper.put("southIndia", 2);
        questionidmapper.put("eastasia", 2);
        questionidmapper.put("europe", 2);
        //Question3
        questionidmapper.put("Home", 3);
        questionidmapper.put("work", 3);
        questionidmapper.put("travel", 3);
        questionidmapper.put("Movies", 3);
        //Question4
        questionidmapper.put("Love", 4);
        questionidmapper.put("Love&Arrange", 4);
        questionidmapper.put("Arranged", 4);
        questionidmapper.put("Bachelor", 4);
        //Question5
        questionidmapper.put("TechOrFinance", 5);
        questionidmapper.put("Manufacturer&Engineering", 5);
        questionidmapper.put("Entertainment", 5);
        questionidmapper.put("Agriculture", 5);
        //Question6
        questionidmapper.put("God", 6);
        questionidmapper.put("MysticalForce", 6);
        questionidmapper.put("NoOne", 6);
        questionidmapper.put("Karma", 6);
        //Question7
        questionidmapper.put("soft", 7);
        questionidmapper.put("active", 7);
        questionidmapper.put("tough", 7);
        questionidmapper.put("lazy", 7);
        return questionidmapper;
    }
}
