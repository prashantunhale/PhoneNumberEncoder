package com.ts.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Dictionary model: It filters valid words from given file and stores in a set
 * Created by User on 30-04-2017.
 */
public class Dictionary {

    private static final String WORD_VALIDATION = "[a-zA-Z\"-]{1,50}";

    private Set<String> words;

    public Dictionary(){
        words = new HashSet<>();
    }

    public void loadDictionary(String fileName){
        try(Stream<String> stream = Files.lines(Paths.get(fileName))){
            stream.forEach(word -> validateAndStoreWord(word));
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public void validateAndStoreWord(String word){
        if (word.matches(WORD_VALIDATION)) {
            words.add(word);
        }else{
            //System.out.println("Warning: Invalid word: " + word);
        }
    }

    public Set<String> getWords(){
        return words;
    }

}
