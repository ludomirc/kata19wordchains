package org.qbit.codekata.kata.imp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qbit.codekata.kata.WordPuzzle;
import org.qbit.codekata.kata.exception.AppException;
import org.qbit.codekata.kata.exception.TechnicalException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by Benek on 18.05.2017.
 */
public class WordPuzzleImpTest {

    private static Logger logger = LogManager.getLogger(WordPuzzleImpTest.class.getName());

    @DataProvider
    public static Object[][] transitionTestDataProvider() {

        return new Object[][]{
                {new String[]{"cat", "dog"}, new LinkedList(Arrays.asList(new String[]{"cat", "cot", "cog", "dog"}))},
                {new String[]{"lead", "gold"}, new LinkedList(Arrays.asList(new String[]{"lead", "load", "goad", "gold"}))},
                {new String[]{"ruby", "code"}, new LinkedList(Arrays.asList(new String[]{"ruby", "rubs", "robs", "rods", "rode", "code"}))},
                {new String[]{"coosd", "xoosd"}, new LinkedList(Arrays.asList(new String[]{"coosd", "xoosd"}))},
                {new String[]{"ala", "olo"}, new LinkedList(Arrays.asList(new String[]{"ala", "ola", "olo"}))},
        };
    }

    @DataProvider
    public static Object[][] nullParameterTestProvider() {
        return new Object[][]{
                {null, "ala"},
                {"ala", null}
        };
    }

    @Test(dataProvider = "nullParameterTestProvider", expectedExceptions = TechnicalException.class)
    public void testSetPuzzleWordsNullException(String p1, String p2) throws AppException {
        WordPuzzle puzzle = new WordPuzzleImp(null);
        puzzle.setPuzzleWords(p1, p2);
    }

    @Test(dataProvider = "transitionTestDataProvider")
    public void testFindTransition(String[] inputData, List<String> expected) throws Exception {
        logger.info("testFindTransition start...");


        DictionaryImp dictionary = new DictionaryImp();
        dictionary.loadDictionary(DictionaryImpTest.class.getResourceAsStream("test-dictionary.txt"));

        WordPuzzle puzzle = new WordPuzzleImp(dictionary);

        puzzle.setPuzzleWords(inputData[0], inputData[1]);
        List<String> actual = (List<String>) puzzle.findTransition();

        assertEquals(actual, expected);

        logger.info("testFindTransition passed");

    }
}