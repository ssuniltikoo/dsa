package dev.dsa.java.advance.tries.wordsearch;

import java.util.ArrayList;

public class ShortestUniquePath {

    public ArrayList<String> prefix(ArrayList<String> A) {
        Node root = new Node();

        for(int i =0 ; i <A.size(); i++){
            String word = A.get(i);
            insertWordInNode(word,root);
        }
        return findPrefixOfWords(A,root);

    }

    public void insertWordInNode(String word, Node root ){
        Node curent = root;
        for(int i =0 ; i <word.length(); i++){
            char ch = word.charAt(i);

            if(curent.children[ch-'a']==null){
                curent.children[ch-'a']=new Node();

            }else{
                curent.children[ch-'a'].frequency=1 + curent.children[ch-'a'].frequency;
                //curent = curent.children[ch-'a'];
            }

            // System.out.println("frequency of "+  ch +" char is "+ curent.children[ch-'a'].frequency + " for word is " + word );
            curent = curent.children[ch-'a'];
        }
    }

    public ArrayList<String> findPrefixOfWords(ArrayList<String> listOfWords, Node node){
        ArrayList<String> output = new ArrayList<>();

        for(int i =0 ; i < listOfWords.size(); i++){
            String word = listOfWords.get(i);
            Node current = node;
            StringBuilder stringBuilder = new StringBuilder();
            for(int j=0; j < word.length(); j++){
                char ch = word.charAt(j);
                int index = word.charAt(j) -'a';
                int frequency = current.children[index].frequency;

                stringBuilder.append(ch);
                if(frequency==1){
                    //  System.out.println("frequency of "+  ch +" char is "+ frequency );
                    output.add(stringBuilder.toString());
                    break;
                }
                if(j==(word.length()-1)){
                    //  System.out.println(" end word frequency of "+  ch +" char is "+ frequency );
                    output.add(word);
                    break;
                }
                current=current.children[ch-'a'];
            }
        }
        return  output;
    }

}

