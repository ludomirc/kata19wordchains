package com.codekata.kata;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class WordBreak {

    public static void main(String[] args) {
        short startIndex = 0;
        HashSet<String> dictionary = new HashSet<String>();
        dictionary.add("cat");
        dictionary.add("cot");
        dictionary.add("cog");
        dictionary.add("dog");
        dictionary.add("lead");
        dictionary.add("load");
        dictionary.add("goad");
        dictionary.add("gold");


        dictionary.add("ruby");
        dictionary.add("rubs");
        dictionary.add("robs");
        dictionary.add("rods");
        dictionary.add("rode");
        dictionary.add("code");


        dictionary.add("coosd");
        dictionary.add("xoosd");


        dictionary.add("ala");
        dictionary.add("ali");
        dictionary.add("ola");
        dictionary.add("olo");


        WordBreak ws = new WordBreak();
        String startWord = "ala";
        String finishWord = "olo";

        List<String> memory = new LinkedList<>();

        boolean solved = ws.findUsingDP(startWord, finishWord, dictionary, memory, startIndex);
        System.out.println(" solved: " + solved + " solution: " + memory);
    }

    public boolean findUsingDP(String startWord, String endWord, HashSet<String> dictionary, List<String> answerMemory, int position) {

        //found solution
        if (startWord.compareTo(endWord) == 0) {
            answerMemory.add(startWord);
            return true;
        }

        //bad path, word in memory
        if (answerMemory.contains(startWord)) {
            return false;
        }

        //add path to memory
        answerMemory.add(startWord);
        int tmpPosition = position;

        do {
            char[] tmpWord = startWord.toCharArray();
            char startChar = tmpWord[position];
            char currentChar = shiftChar(startChar);

            String newWord = "";
            while (startChar != currentChar) {

                tmpWord[position] = currentChar;
                newWord = new String(tmpWord);

                if (dictionary.contains(newWord)) {
                    for (short i = 0; i < newWord.length(); i++) {
                        if (findUsingDP(newWord, endWord, dictionary, answerMemory, i)) {
                            return true;
                        }
                    }
                }

                currentChar = shiftChar(currentChar);
            }
            tmpPosition++;
            position = tmpPosition;

        } while (tmpPosition < startWord.length());

        //remove form answer, bad path
        answerMemory.remove(startWord);
        return false;

    }

    private char shiftChar(char inputChar) {
        char ch;
        if (inputChar < 'z') {
            ch = (char) (inputChar + 1);
        } else ch = 'a';
        return ch;
    }
}