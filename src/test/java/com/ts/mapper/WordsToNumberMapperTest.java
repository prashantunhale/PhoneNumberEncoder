package com.ts.mapper;

import com.ts.model.Dictionary;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by User on 30-04-2017.
 */
public class WordsToNumberMapperTest {
    private static WordsToNumberMapper mapper;

    @BeforeClass
    public static void before(){
        Dictionary dictionary = new Dictionary();
        dictionary.loadDictionary("C:\\Users\\User\\IdeaProjects\\PhoneNumberEncoder\\src\\test\\resources\\dictionary.txt");
        mapper = new WordsToNumberMapper(dictionary);
    }

    @Test
    public void testNormaliseword(){
        Assert.assertEquals("bo",WordsToNumberMapper.normaliseWord("Bo\""));
        Assert.assertEquals("od",WordsToNumberMapper.normaliseWord("o\"d"));
    }

    @Test
    public void testWordToNumber(){
        Assert.assertEquals(mapper.wordToNumber("Mix"), "562");
        Assert.assertEquals(mapper.wordToNumber("mir"), "562");
        Assert.assertEquals(mapper.wordToNumber("bo\"s"), "783");
    }

    @Test
    public void testGetWords(){
        Assert.assertEquals(true, mapper.getWords("562").contains("Mix"));
        Assert.assertEquals(true, mapper.getWords("783").contains("bo\"s"));
        Assert.assertEquals(false, mapper.getWords("783").contains("mir"));

    }
}
