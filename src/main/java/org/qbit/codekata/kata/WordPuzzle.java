package org.qbit.codekata.kata;

import org.qbit.codekata.kata.exception.AppException;

import java.util.Collection;

/**
 * Created by Benek on 18.05.2017.
 */
public interface WordPuzzle {
    Collection<String> findTransition();

    void setPuzzleWords(String begin, String end) throws AppException;
}
