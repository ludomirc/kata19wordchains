package org.qbit.codekata.kata.imp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qbit.codekata.kata.exception.AppException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Benek on 18.05.2017.
 */
public class DictionaryImpTest {

    private static Logger logger = LogManager.getLogger(DictionaryImpTest.class.getName());

    @DataProvider
    public static Object[][] wordDataProvider() {
        return new Object[][]{{"cat", true}, {"gol", false}, {"lead", true}, {"", false}, {"code", true}};
    }

    @Test
    protected void testLoadDictionary() throws AppException {
        DictionaryImp dictionary = new DictionaryImp();
        dictionary.loadDictionary(DictionaryImpTest.class.getResourceAsStream("test-dictionary.txt"));

        logger.info("testLoadDictionary start...");
        int actual = dictionary.size();
        int expectedSize = 20;
        assertEquals(actual, expectedSize);
        logger.info("testLoadDictionary passed");
    }

    @Test(dataProvider = "wordDataProvider")
    public void testContains(String inputWorld, Boolean expected) throws Exception {
        logger.info("testContains start...");

        DictionaryImp dictionary = new DictionaryImp();
        dictionary.loadDictionary(DictionaryImpTest.class.getResourceAsStream("test-dictionary.txt"));

        String[] dic = new String[dictionary.size()];
        assertEquals((boolean) dictionary.contains(inputWorld), (boolean) expected, "input value: " + inputWorld + " expected value: " + expected + " dictionary size: " + dictionary.size());

        logger.info("testContains passed");
    }

}