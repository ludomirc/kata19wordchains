package com.codekata.kata.imp;

import com.codekata.kata.Dictionary;
import com.codekata.kata.WordChains;

import java.util.Collection;

/**
 * Created by Benek on 18.05.2017.
 */
public class WordChainsImp implements WordChains {

    Dictionary dictionary;

    String wordFrom;
    String wordTo;

    public WordChainsImp(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    @Override
    public Collection<String> getChains() {
        return null;
    }

    @Override
    public void setPuzzleWords(String wordFrom, String wordTo) {
            this.wordFrom = (String) wordFrom;
            this.wordTo = (String) wordTo;
    }
}
