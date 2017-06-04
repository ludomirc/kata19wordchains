package com.codekata.kata;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class WordBreak {

    private String solution;

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


        // create another HashSet so store the sub problems result
        String answer = startWord + " ";
        List<String> memory = new LinkedList<>();

        boolean solved = ws.findUsingDP(startWord, finishWord, dictionary, memory, startIndex);

        System.out.println(" solved: " + solved + " solution: " + ws.getSolution());

        System.out.println(memory);
    }

    public boolean findUsingDP(String startWord, String endWord, HashSet<String> dictionary, List<String> answerMem, int position) {

        //found solution
        if (startWord.compareTo(endWord) == 0) {
            answerMem.add(startWord);
            return true;
        }

        //bad track word in memory
        if (answerMem.contains(startWord)) {
            return false;
        }


        answerMem.add(startWord);
        int tmpPosition = position;

        do {
            char[] tmpWord = startWord.toCharArray();
            char startChar = tmpWord[position];
            char currentChar = setStartChar(startChar);

            String newWord = "";
            while (startChar != currentChar) {

                tmpWord[position] = currentChar;
                newWord = new String(tmpWord);

                if (dictionary.contains(newWord)) {
                    for (short i = 0; i < newWord.length(); i++) {
                        if (findUsingDP(newWord, endWord, dictionary, answerMem, i)) {
                            return true;
                        }
                    }
                }

                currentChar++;

                if (currentChar > 'z') {
                    currentChar = 'a';
                }
            }
            tmpPosition++;
            position = tmpPosition;
            System.out.println("cntr: " + tmpPosition);
        } while (tmpPosition < startWord.length());

        //remove form answer bad track
        answerMem.remove(startWord);
        return false;

    }

    private char setStartChar(char startChar) {
        char ch;
        if (startChar != 'z') {
            ch = (char) (startChar + 1);
        } else ch = 'a';
        return ch;
    }

    /**
     * function cheack if char is in start and final solution block the letter
     *
     * @param index
     * @param startCondition
     * @param finalCondition
     * @return true if char is in start and final word, else false
     */
    private boolean isBlockIndex(int index, String startCondition, String finalCondition) {
        return startCondition.charAt(index) == finalCondition.charAt(index);
    }

    public String getSolution() {
        return solution;
    }
}