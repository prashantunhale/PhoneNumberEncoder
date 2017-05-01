package com.ts.service;

import com.ts.mapper.WordsToNumberMapper;
import com.ts.model.Dictionary;
import com.ts.model.PhoneNumbers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by User on 01-05-2017.
 */
public class EncoderTest {

    private static Encoder encoder;

    @BeforeClass
    public static void beforeClass(){
        Dictionary dictionary = new Dictionary();
        dictionary.loadDictionary("C:\\Users\\User\\IdeaProjects\\PhoneNumberEncoder\\src\\test\\resources\\dictionary.txt");
        WordsToNumberMapper mapper = new WordsToNumberMapper(dictionary);
        encoder = new Encoder();
        encoder.setMapper(mapper);
    }

    @Test
    public void testEncode(){
        Assert.assertEquals(true,encoder.encode("5624-82").contains("mir Tor"));
        Assert.assertEquals(true,encoder.encode("5624-82").contains("Mix Tor"));
        Assert.assertEquals(true,encoder.encode("4824").contains("Torf"));
        Assert.assertEquals(true,encoder.encode("4824").contains("fort"));
        Assert.assertEquals(true,encoder.encode("4824").contains("Tor 4"));
        Assert.assertEquals(true,encoder.encode("10/783--5").contains("neu o\"d 5"));
        Assert.assertEquals(true,encoder.encode("10/783--5").contains("je bo\"s 5"));
        Assert.assertEquals(true,encoder.encode("10/783--5").contains("je Bo\" da"));
        Assert.assertEquals(true,encoder.encode("381482").contains("so 1 Tor"));
        Assert.assertEquals(true,encoder.encode("04824").contains("0 Torf"));
        Assert.assertEquals(true,encoder.encode("04824").contains("0 fort"));
        Assert.assertEquals(true,encoder.encode("04824").contains("0 Tor 4"));

        Assert.assertEquals(false,encoder.encode("10/783--5").contains("je bos 5"));
        Assert.assertEquals(false,encoder.encode("4824").contains("4 Ort"));
        Assert.assertEquals(false,encoder.encode("1078-913-5").contains("je Bo\" 9 1 da"));
        Assert.assertEquals(false,encoder.encode("04824").contains("0 Tor"));
        Assert.assertEquals(false,encoder.encode("5624-82").contains("mir Torf"));

    }
}
