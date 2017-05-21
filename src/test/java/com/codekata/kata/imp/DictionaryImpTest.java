package com.codekata.kata.imp;

import com.codekata.kata.exception.AppException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.util.Arrays;

import static org.testng.Assert.*;

/**
 * Created by Benek on 18.05.2017.
 */
public class DictionaryImpTest {

    private static Logger logger = LogManager.getLogger(DictionaryImpTest.class.getName());

    private String expectedWorld[];

    @BeforeMethod
    public void setUp() throws Exception {
        expectedWorld = new String[]{"ala", "pies", "kot"};
    }


    @DataProvider(name = "wordTest1")
    public static Object[][] primeNumbers() {
        return new Object[][]{{"ala", true}, {"ola", false}, {"kot", true}, {"", false}, {"pies", true}};
    }

    @Test
    protected void testLoadDictionary() throws AppException {
        DictionaryImp dictionary = new DictionaryImp();
        dictionary.loadDictionary(DictionaryImpTest.class.getResourceAsStream("test-dictionary.txt"));

        logger.info("testLoadDictionary start...");
        int actual = dictionary.size();
        int expected = 3;
        assertEquals(actual, expected);
        logger.info("testLoadDictionary passed");
    }

    @Test(dataProvider = "wordTest1")
    public void testIsExist(String inputWorld, Boolean expected) throws Exception {
        DictionaryImp dictionary = new DictionaryImp();
        dictionary.loadDictionary(DictionaryImpTest.class.getResourceAsStream("test-dictionary.txt"));

        String[] dic = new String[dictionary.size()];
        assertEquals((boolean) dictionary.isExist(inputWorld), (boolean)expected,"input value: " + inputWorld + " expected value: " + expected +" dictionary size: " + dictionary.size());
    }

}