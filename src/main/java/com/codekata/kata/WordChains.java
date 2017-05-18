package com.codekata.kata;

import java.util.Collection;

/**
 * Created by Benek on 18.05.2017.
 */
public interface WordChains {
    Collection<CharSequence> getChains();
    void setPuzzleWords(CharSequence begin, CharSequence end);
}
