package com.ts;

import com.ts.mapper.WordsToNumberMapper;
import com.ts.model.Dictionary;
import com.ts.model.PhoneNumbers;
import com.ts.service.Encoder;

/**
 * Phone Number Encoder App takes two arguments:
 *  dictionary file name
 *  phone numbers file name
 * It then prints out the possible encodings on console
 * Created by User on 30-04-2017.
 */
public class PhoneNumberEncoderApp {
    public static void main(String [] args){
        Dictionary dictionary = new Dictionary();
        dictionary.loadDictionary(args [0]);
        WordsToNumberMapper mapper = new WordsToNumberMapper(dictionary);
        PhoneNumbers phoneNumbers = new PhoneNumbers();
        phoneNumbers.loadPhoneNumbers(args [1]);
        Encoder encoder = new Encoder();
        encoder.setMapper(mapper);
        for(String number : phoneNumbers.getPhoneNumbers()){
            for(String encodedNumber : encoder.encode(number)){
                System.out.println(number + ": " + encodedNumber);
            }
        }
    }
}
