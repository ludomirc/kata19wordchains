package com.codekata.kata.imp;

import com.codekata.kata.Dictionary;
import com.codekata.kata.WordPuzzle;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Benek on 18.05.2017.
 */
public class WordPuzzleImp implements WordPuzzle {

    Dictionary dictionary;

    String wordFrom;
    String wordTo;

    public WordPuzzleImp(Dictionary dictionary, String wordFrom, String wordTo) {
        this.dictionary = dictionary;
        this.wordFrom = wordFrom;
        this.wordTo = wordTo;
    }

    public WordPuzzleImp(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    @Override
    public Collection<String> findTransition() {

        List<String> solution = new LinkedList<String>();
        int startPosition = 0;
        WordTool.findTransition(wordFrom, wordTo, dictionary, solution, startPosition);

        return solution;
    }

    @Override
    public void setPuzzleWords(String wordFrom, String wordTo) {
        this.wordFrom = wordFrom;
        this.wordTo = wordTo;
    }
}
