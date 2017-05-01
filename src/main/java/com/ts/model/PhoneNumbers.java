package com.ts.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Phone Numbers model: It filters valid phone numbers from given file and stores them in a list
 * Created by User on 30-04-2017.
 */
public class PhoneNumbers {
    private static final String PHONE_NUMBER_VALIDATION = "[0-9/-]{1,50}";
    private List<String> phoneNumbers;

    public PhoneNumbers(){
        phoneNumbers = new ArrayList<>();
    }

    public void loadPhoneNumbers(String fileName){
        try(Stream<String> stream = Files.lines(Paths.get(fileName))){
            stream.forEach(number -> validateAndStore(number));
        }catch(IOException ex){
            //ex.printStackTrace();
        }
    }

    public static String normaliseNumber(String word){
        return word.replaceAll("[^0-9]+", "").toLowerCase();
    }

    public void validateAndStore(String number){
        if (number.matches(PHONE_NUMBER_VALIDATION)) {
            phoneNumbers.add(number);
        } else {
            //System.out.println("Warning: Invalid phone number: " + number);
        }
    }

    public List<String> getPhoneNumbers(){
        return phoneNumbers;
    }

}
