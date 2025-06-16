package dev.dsa.java.advance.tries.autocomplete;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class searchWordsFromPrefix {
    private static String[] dictWords;
    private static String[] prefixes;
    private static int[] weights;
    private static int sizeOfDictionaryWords, sizeOfPrefixes;

    private static Pair[] pairList;
    private static HashMap<Integer, String> map;
    private static TrieNode root;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();

        while( testcases--> 0){
            sizeOfDictionaryWords = sc.nextInt();
            sizeOfPrefixes = sc.nextInt();

            dictWords = new String[sizeOfDictionaryWords];
            prefixes = new String[sizeOfPrefixes];
            weights = new int[sizeOfDictionaryWords];

            root = new TrieNode();
            map = new HashMap<>();

            sc.nextLine();

            for(int i = 0; i < sizeOfDictionaryWords; i++){
                dictWords[i] = sc.next().trim();
            }

            for(int i = 0; i < sizeOfDictionaryWords; i++){
                weights[i] = sc.nextInt();
            }

            sc.nextLine();

            for(int i = 0; i < sizeOfPrefixes; i++){
                prefixes[i] = sc.next().trim();
            }


            pairList = new Pair[sizeOfDictionaryWords];
            for(int i = 0; i < sizeOfDictionaryWords; i++){
                pairList[i] = new Pair(dictWords[i], weights[i] );
            }

            sortBasedOnWeights();

            for(Pair p : pairList){
                map.put(p.weight,p.str);
            }

            insertToTries();
            searchInTrie();

        }



    }

    static void insertToTries(){
        for(Pair p : pairList){
            TrieNode curr = root;
            String word = p.str;
            int weight = p.weight;
            int length = word.length();


            for( int i = 0; i < length; i++){
                int index = word.charAt(i) - 'a';

                if(curr.ch[index] == null){
                    curr.ch[index] = new TrieNode();
                }
                int wIndx = 0;
                while(wIndx< 5){
                    if(curr.ch[index].outputArr[wIndx] == 0){
                        curr.ch[index].outputArr[wIndx]= weight;
                        break;
                    }
                    wIndx++;
                }
                curr = curr.ch[index];

            }

        }
    }

    static void searchInTrie(){
        for (String prefix : prefixes) {
            TrieNode curr = root;
            int length = prefix.length();
            boolean prefixFound = true;
            for (int i = 0; i < length; i++) {
                int idx = prefix.charAt(i) - 'a';

                if (curr.ch[idx] == null) {
                    System.out.print("-1 ");
                    prefixFound = false;
                    break;
                }

                curr = curr.ch[idx];
            }
            if (prefixFound) {
                for (int weight : curr.outputArr) {
                    if (weight == 0) {
                        break;
                    }
                    System.out.print(map.get(weight) + " ");
                }
            }
            System.out.println();
        }
    }




    public static void sortBasedOnWeights(){
//
//        Comparator<Pair> comparator = new Comparator<Pair>() {
//
//            @Override
//            public int compare(Pair o1, Pair o2) {
//                return  o2.weight - o1.weight;
//            }
//        };

        Arrays.sort(pairList,(Pair o1, Pair o2)->{return o2.weight - o1.weight;});

    }
}
class Pair{
    String str;
    int weight;

    public Pair(String str, int weight){
        this.str = str;
        this.weight = weight;
    }
}

class TrieNode{
    TrieNode[] ch;
    int[] outputArr;

    public TrieNode(){
        ch = new TrieNode[26];
        outputArr = new int[5];
    }

}