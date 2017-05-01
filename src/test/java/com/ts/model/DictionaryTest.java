package com.ts.model;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by User on 01-05-2017.
 */
public class DictionaryTest {
    private static Dictionary dictionary;

    @BeforeClass
    public static void beforeClass(){
        dictionary = new Dictionary();
        dictionary.loadDictionary("C:\\Users\\User\\IdeaProjects\\PhoneNumberEncoder\\src\\test\\resources\\dictionary.txt");
    }

    @Test
    public void testValidateAndStore(){
        dictionary.validateAndStoreWord("Invalid@Word");
        Assert.assertEquals(false, dictionary.getWords().contains("Invalid@Word"));
        dictionary.validateAndStoreWord("Valid\"Word");
        Assert.assertEquals(true, dictionary.getWords().contains("Valid\"Word"));
        dictionary.validateAndStoreWord("AnotherValid\"Word-");
        Assert.assertEquals(true, dictionary.getWords().contains("Valid\"Word"));
        dictionary.validateAndStoreWord("LongInvalid\"Word-ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ");
        Assert.assertEquals(false, dictionary.getWords().contains("LongInvalid\"Word-ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ"));
    }

    @Test
    public void testGetWords(){
        Assert.assertEquals(23, dictionary.getWords().size());
        Assert.assertEquals(true, dictionary.getWords().contains("Wasser"));
    }


}
