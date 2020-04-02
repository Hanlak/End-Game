package com.endgame.util;

import com.endgame.model.Question;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AnswerCheckerUtil {
    public static int validateAnswers(List<Question> consumerQ, List<Question> userQ) {
        if (consumerQ.size() == userQ.size()) {
            Map<Integer, String> userMap = prepareMap(userQ);
            Map<Integer, String> consumerMap = prepareMap(consumerQ);
            int count = 0;
            for (int i = 1; i <= userQ.size(); i++) {
                if (userMap.get(i).equals(consumerMap.get(i))) {
                    count++;
                }
            }
            return count;
        }
        return -1;
    }

    private static Map<Integer, String> prepareMap(List<Question> questions) {
        Map<Integer, String> map = new LinkedHashMap<>();
        for (Question question : questions) {
            map.put(question.getQuestionId(), question.getAnswer());
        }
        return map;
    }
}
