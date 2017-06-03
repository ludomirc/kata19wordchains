package com.codekata.kata;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class WordBreak {

    List<String> myMemory = new LinkedList<String>();
    private String solution;

    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<String>();
        hs.add("cat");
        hs.add("cot");
        hs.add("cog");
        hs.add("dog");
        hs.add("lead");
        hs.add("load");
        hs.add("goad");
        hs.add("gold");


        hs.add("ruby");
        hs.add("rubs");
        hs.add("robs");
        hs.add("rods");
        hs.add("rode");
        hs.add("code");

        WordBreak ws = new WordBreak();
        String s = "lead";
        // create another HashSet so store the sub problems result
        HashSet<String> memoization = new HashSet<String>();
        String answer = s + " ";

        List<String> memAnswer = new LinkedList<String>();

        boolean solved = ws.findUsingDP(s, "gold", hs, memoization, answer, (short) 1);

        System.out.println(" solved: " + solved + " solution: " + ws.getSolution());
        System.out.println("my mem: " + ws.myMemory);
        System.out.println(memoization);
    }

    public boolean findUsingDP(String startWord, String endWord, HashSet<String> dictionary, HashSet<String> memory, String answer, short position) {
        System.out.println("call findUsingDP  input word: " + startWord);

        if (startWord.compareTo(endWord) == 0) {
            solution = answer;
            System.out.println("xxx " + answer);

            return true;

        } else if (memory.contains(startWord) || position < 0 || position >= startWord.length()) {
            System.out.println("return false memory: " + startWord + " position:" + position);
            return false;

        } else {

            char ch = 'a';
            char[] cWord = startWord.toCharArray();
            String nWord = "";

            char startChar = cWord[position];
            ch = setStartChar(startChar);

            while (ch != startChar) {

                cWord[position] = ch;
                nWord = new String(cWord);
                System.out.println("position: " + position + " nWord: " + nWord);


                if (dictionary.contains(nWord)) {
                    dictionary.remove(nWord);

                    for (short i = 0; i < nWord.length(); i++) {
                        if (findUsingDP(nWord, endWord, dictionary, memory, answer + nWord + " ", i)) {
                            myMemory.add(nWord);
                            return true;
                        }
                    }
                }
                ch++;
                if (ch > 'z') {
                    ch = 'a';
                }

            }

            //memory.add(startWord);
            System.out.println("memxx: " + memory);
            return false;
        }
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