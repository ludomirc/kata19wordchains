package com.codekata.kata;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class WordBreak {

    List<String> myMemory = new LinkedList<String>();
    private String solution;

    public static void main(String[] args) {
        short startIndex = 1;
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


        dictionary.add("cood");
        dictionary.add("xood");

        WordBreak ws = new WordBreak();
        String startWord = "lead";
        String finishWord = "gold";


        // create another HashSet so store the sub problems result
        String answer = startWord + " ";


        boolean solved = ws.findUsingDP(startWord, finishWord, dictionary, answer, startIndex);

        System.out.println(" solved: " + solved + " solution: " + ws.getSolution());
        System.out.println("my mem: " + ws.myMemory);
    }

    public boolean findUsingDP(String startWord, String endWord, HashSet<String> dictionary, String answer, short position) {
        System.out.println("call findUsingDP  input word: " + startWord);

        if (startWord.compareTo(endWord) == 0) {
            solution = answer;
            System.out.println("xxx " + answer);

            return true;

        }

        char[] tmpWord = startWord.toCharArray();
        char startChar = tmpWord[position];
        char currentChar = setStartChar(startChar);

        String newWord = "";
        while (startChar != currentChar) {

            tmpWord[position] = currentChar;
            newWord = new String(tmpWord);
            System.out.println("position: " + position + " nWord: " + newWord);


            if (dictionary.contains(newWord)) {
                dictionary.remove(newWord);

                for (short i = 0; i < newWord.length(); i++) {
                    if (findUsingDP(newWord, endWord, dictionary, answer + newWord + " ", i)) {
                        myMemory.add(newWord);
                        return true;
                    }
                }
            }

            currentChar++;

            if (currentChar > 'z') {
                currentChar = 'a';
            }

        }
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