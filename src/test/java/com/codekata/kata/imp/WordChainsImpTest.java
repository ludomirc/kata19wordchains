package com.codekata.kata.imp;

import com.codekata.kata.WordPuzzle;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Benek on 18.05.2017.
 */
public class WordChainsImpTest {


    @Test
    public void testGetChains() throws Exception {
        String[] expected = {"cat","cot","cog","dog"};

        DictionaryImp dictionary = new DictionaryImp();
        dictionary.loadDictionary(DictionaryImpTest.class.getResourceAsStream("test-dictionary.txt"));

        WordPuzzle wordChains = new WordPuzzleImp(dictionary);

        wordChains.setPuzzleWords("cat","dog");
        List<String> actual = (List<String>) wordChains.getChains();

    }

    @Test
    public void testSetPuzzleWords() throws Exception {

    }

}