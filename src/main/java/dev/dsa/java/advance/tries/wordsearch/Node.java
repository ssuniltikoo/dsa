package dev.dsa.java.advance.tries.wordsearch;


class Node{
    Node[] children;
    int frequency;
    public Node(){
        frequency=1;
        children = new Node[26];
    }
}

