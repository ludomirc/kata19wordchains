package org.qbit.codekata.kata.imp;

import org.qbit.codekata.kata.Dictionary;
import org.qbit.codekata.kata.WordPuzzle;
import org.qbit.codekata.kata.exception.TechnicalException;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Benek on 18.05.2017.
 */
public class WordPuzzleImp implements WordPuzzle {

    private Dictionary dictionary;

    private String wordFrom;
    private String wordTo;

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
    public void setPuzzleWords(String wordFrom, String wordTo) throws TechnicalException {
        if (WordTool.isEmpty(wordFrom) || WordTool.isEmpty(wordTo)) {
            IllegalArgumentException exp = new IllegalArgumentException("parm wordFrom or wordTo is empty: " + wordFrom + " " + wordTo);
            throw new TechnicalException(exp);
        }

        wordFrom.toLowerCase();
        wordTo.toLowerCase();

        this.wordFrom = wordFrom;
        this.wordTo = wordTo;
    }
}
