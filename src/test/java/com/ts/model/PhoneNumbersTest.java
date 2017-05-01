package com.ts.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by User on 01-05-2017.
 */
public class PhoneNumbersTest {

    private static PhoneNumbers phoneNumbers;

    @BeforeClass
    public static void beforeClass(){
        phoneNumbers = new PhoneNumbers();
        phoneNumbers.loadPhoneNumbers("C:\\Users\\User\\IdeaProjects\\PhoneNumberEncoder\\src\\test\\resources\\input.txt");
    }

    @Test
    public void testNormaliseNumber(){
        Assert.assertEquals(true, PhoneNumbers.normaliseNumber("124-24").equals("12424"));
        Assert.assertEquals(true, PhoneNumbers.normaliseNumber("124\"24").equals("12424"));
    }

    @Test
    public void testValidateAndStore(){
        phoneNumbers.validateAndStore("123/23-");
        Assert.assertEquals(true, phoneNumbers.getPhoneNumbers().contains("123/23-"));
        phoneNumbers.validateAndStore("123/23-@");
        Assert.assertEquals(false, phoneNumbers.getPhoneNumbers().contains("123/23-@"));
    }

    @Test
    public void testGetPhoneNumbers(){
        Assert.assertEquals(true, phoneNumbers.getPhoneNumbers().contains("5624-82"));
        Assert.assertEquals(true, phoneNumbers.getPhoneNumbers().contains("0721/608-4067"));
        Assert.assertEquals(true, phoneNumbers.getPhoneNumbers().contains("10/783--5"));
        Assert.assertEquals(false, phoneNumbers.getPhoneNumbers().contains("1078-913-5-"));
    }
}
