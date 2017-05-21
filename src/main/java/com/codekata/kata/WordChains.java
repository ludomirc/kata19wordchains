package com.codekata.kata;

import java.util.Collection;

/**
 * Created by Benek on 18.05.2017.
 */
public interface WordChains {
    Collection<String> getChains();
    void setPuzzleWords(String begin, String end);
}
