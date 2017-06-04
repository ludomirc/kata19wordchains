package com.codekata.kata.imp;

import com.codekata.kata.exception.AppException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Benek on 18.05.2017.
 */
public class DictionaryImpTest {

    private static Logger logger = LogManager.getLogger(DictionaryImpTest.class.getName());

    @DataProvider(name = "wordTest1")
    public static Object[][] primeNumbers() {
        return new Object[][]{{"cat", true}, {"ola", false}, {"lead", true}, {"", false}, {"code", true}};
    }

    @Test
    protected void testLoadDictionary() throws AppException {
        DictionaryImp dictionary = new DictionaryImp();
        dictionary.loadDictionary(DictionaryImpTest.class.getResourceAsStream("test-dictionary.txt"));

        logger.info("testLoadDictionary start...");
        int actual = dictionary.size();
        int expected = 14;
        assertEquals(actual, expected);
        logger.info("testLoadDictionary passed");
    }

    @Test(dataProvider = "wordTest1")
    public void testIsExist(String inputWorld, Boolean expected) throws Exception {
        DictionaryImp dictionary = new DictionaryImp();
        dictionary.loadDictionary(DictionaryImpTest.class.getResourceAsStream("test-dictionary.txt"));

        String[] dic = new String[dictionary.size()];
        assertEquals((boolean) dictionary.contains(inputWorld), (boolean) expected, "input value: " + inputWorld + " expected value: " + expected + " dictionary size: " + dictionary.size());
    }

}