package com.codekata.kata.imp;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public final class WordTool {

    private WordTool() {
    }


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


        WordTool ws = new WordTool();
        String startWord = "cat";
        String finishWord = "dog";

        List<String> memory = new LinkedList<>();

        boolean solved = findTransition(startWord, finishWord, dictionary, memory, startIndex);
        System.out.println(" solved: " + solved + " solution: " + memory);
    }

    public static boolean findTransition(String fromWord, String toWord, HashSet<String> dictionary, List<String> answerMemory, int position) {

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
}