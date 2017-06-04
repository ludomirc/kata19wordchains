package com.codekata.kata.imp;

import com.codekata.kata.WordPuzzle;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Benek on 18.05.2017.
 */
public class WordPuzzleImpTest {


    @Test
    public void testGetChains() throws Exception {
        String[] expected = {"cat","cot","cog","dog"};

        DictionaryImp dictionary = new DictionaryImp();
        dictionary.loadDictionary(DictionaryImpTest.class.getResourceAsStream("test-dictionary.txt"));

        WordPuzzle puzz = new WordPuzzleImp(dictionary);

        puzz.setPuzzleWords("cat", "dog");
        List<String> actual = (List<String>) puzz.findTransition();


    }

    @Test
    public void testSetPuzzleWords() throws Exception {

    }

}