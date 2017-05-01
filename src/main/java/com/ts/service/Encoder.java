package com.ts.service;

import com.ts.mapper.WordsToNumberMapper;
import com.ts.model.PhoneNumbers;

import java.util.ArrayList;
import java.util.List;

/**
 * Encodes given phone number
 * Created by User on 30-04-2017.
 */
public class Encoder {
    private WordsToNumberMapper mapper;

    public List<String> encode(String phoneNumber){
        return findWords(PhoneNumbers.normaliseNumber(phoneNumber), false);
    }

    public List<String> findWords(String number, boolean isLeftCharacterADigit) {
        final List<String> result = new ArrayList<>();
        //First find matches for the whole number
        result.addAll(mapper.getWords(number));

        if (number.length() == 1) {
            if (result.isEmpty() && !isLeftCharacterADigit) {
                result.add(number);
            }
            return result;
        }

        //Find possible solutions by splitting the given number into left and right recursively
        for (int i = 0; i < number.length() - 1; i++) {
            final String left = number.substring(0, i + 1);
            final String right = number.substring(i + 1);

            final List<String> leftWords = new ArrayList<>();
            boolean isCurrentLeftCharacterADigit = false;
            leftWords.addAll(mapper.getWords(left));

            if (!leftWords.isEmpty()) {
                final List<String> rightWords = findWords(right, isCurrentLeftCharacterADigit);

                if (!rightWords.isEmpty()) {
                    joinLeftRightWords(result, leftWords, rightWords);
                }
            }
        }

        if (result.isEmpty() && !isLeftCharacterADigit) {
            final String right = number.substring(1);
            final List<String> rightWords = findWords(right, true);
            if (!rightWords.isEmpty()) {
                final List<String> leftWords = new ArrayList<>();
                leftWords.add(number.substring(0, 1));
                joinLeftRightWords(result, leftWords, rightWords);
            }
        }

        return result;
    }

    private static void joinLeftRightWords(List<String> result,
                                            List<String> leftWords, List<String> rightWords) {
        for (String left : leftWords) {
            for (String right : rightWords) {
                result.add(left + " " + right);
            }
        }
    }

    public void setMapper(WordsToNumberMapper mapper){
        this.mapper = mapper;
    }
}
