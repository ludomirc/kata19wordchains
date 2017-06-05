package org.qbit.codekata.kata.imp;

import org.qbit.codekata.kata.Dictionary;

import java.util.List;

public final class WordTool {

    private WordTool() {
    }

    public static boolean findTransition(String fromWord, String toWord, Dictionary dictionary, List<String> answerMemory, int position) {

        //found solution :)
        if (fromWord.compareTo(toWord) == 0) {
            answerMemory.add(fromWord);
            return true;
        }

        //bad path, word in memory
        if (answerMemory.contains(fromWord)) {
            return false;
        }

        //add candidate path to memory
        answerMemory.add(fromWord);

        for (int tmpPosition = position; tmpPosition < fromWord.length(); tmpPosition++) {
            char[] tmpWord = fromWord.toCharArray();
            char startChar = tmpWord[tmpPosition];
            char currentChar = shiftChar(startChar);

            String newWord = "";
            while (startChar != currentChar) {

                tmpWord[tmpPosition] = currentChar;
                newWord = new String(tmpWord);

                if (dictionary.contains(newWord)) {
                    for (short i = 0; i < newWord.length(); i++) {
                        if (findTransition(newWord, toWord, dictionary, answerMemory, i)) {
                            return true;
                        }
                    }
                }

                currentChar = shiftChar(currentChar);
            }
        }

        //remove form memory, bad path
        answerMemory.remove(fromWord);
        return false;

    }

    private static char shiftChar(char inputChar) {
        char ch;
        if (inputChar < 'z') {
            ch = (char) (inputChar + 1);
        } else ch = 'a';
        return ch;
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;

    }
}