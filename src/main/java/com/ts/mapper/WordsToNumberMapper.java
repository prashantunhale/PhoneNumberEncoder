package com.ts.mapper;

import com.ts.model.Dictionary;

import java.util.*;

/**
 * Converts all words in the given dictionary to corresponding numbers using the encoding format and saves in cache
 * Created by User on 30-04-2017.
 */
public class WordsToNumberMapper {
    private final String MAPPINGS[] = { "e", "jnq", "rwx", "dsy",
            "ft", "am", "civ", "bku", "lop", "ghz" };

    private Map<Character, Integer> letterToNumber = new HashMap<>();

    private Map<String, List<String>> wordsCache;

    public WordsToNumberMapper(Dictionary dictionary){
        initiateLetterMap();
        wordsCache = new HashMap<>();
        initiateWordsMap(dictionary);
    }

    private void initiateLetterMap(){
        for(int i = 0; i < MAPPINGS.length; i++){
            for(char c: MAPPINGS[i].toCharArray())
                letterToNumber.put(c,i);
        }
    }

    private void initiateWordsMap(Dictionary dictionary){

        for(String word : dictionary.getWords()){
            storeWord(word);
        }
    }

    public static String normaliseWord(String word){
        return word.replaceAll("[^a-zA-Z]+", "").toLowerCase();
    }

    private void storeWord(String word){
        if(wordsCache.containsKey(wordToNumber(word))){
            wordsCache.get(wordToNumber(word)).add(word);
        }else{
            wordsCache.put(wordToNumber(word), new ArrayList<String>());
            wordsCache.get(wordToNumber(word)).add(word);
        }
    }

    public String wordToNumber(String word){
        StringBuilder s = new StringBuilder();
        for(char c: normaliseWord(word).toCharArray()){
            s.append(letterToNumber.get(c));
        }
        return s.toString();
    }

    public List<String> getWords(String number){
        List<String> words = wordsCache.get(number);
        if(words == null){
            return Collections.EMPTY_LIST;
        }
        return words;
    }

}
