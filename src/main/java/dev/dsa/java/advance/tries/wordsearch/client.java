package dev.dsa.java.advance.tries.wordsearch;

import java.util.ArrayList;

public class client {
    public static void main(String[] args) {
        int testcases = 5;

        while( testcases--> 0){
            System.out.println(testcases);

        }


        ShortestUniquePath sp = new ShortestUniquePath();
        ArrayList<String> words = new ArrayList<>();
        words.add("cat");
        words.add("dog");
        words.add("cati");
        words.add("apple");
        words.add("ball");

        ArrayList<String> pr = sp.prefix(words);
        pr.stream().forEach(System.out::println);
    }
}
