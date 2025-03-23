package dev.dsa.java.advance.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/*
* You are given two strings, A and B, of size N and M, respectively.

You have to find the count of all permutations of A present in B as a substring. You can assume a string will have only lowercase letters.



*
*
* */
public class PermutationSlindingWindow {
    public static void main(String[] args) {
        SolutionA solution = new SolutionA();
        System.out.println(solution.solve("p","pccdpeeooadeocdoacddapacaecb"));
    }
}

class SolutionA {
    public int solve(String A, String B) {
        int sizeOfA = A.length();
        int sizeOfB = B.length();
        if(sizeOfA>sizeOfB){
            return 0;
        }
        ArrayList<Integer> alphabets = new ArrayList<>();
        for(int i=0; i<26; i++){
            alphabets.add(0);
        }
        for(int i=0; i<sizeOfA; i++){
            int ch = A.charAt(i) ;
            ch = ch -97;
            alphabets.set(ch,alphabets.get(ch)+1);
        }

        ArrayList<Integer> data = new ArrayList<>();
        for(int i=0; i<26; i++){
            data.add(0);
        }

        for(int i=0; i<sizeOfA; i++){
            int ch = B.charAt(i) ;
            ch = ch -97;
            data.set(ch,data.get(ch)+1);
        }
        int count =0;
        if(sizeOfA==sizeOfB && Arrays.equals(alphabets.toArray(),data.toArray())){
            count++;
            return  count;
        }

        if(Arrays.equals(alphabets.toArray(),data.toArray())){
            count++;
        }


        for(int i =0; i <(sizeOfB-sizeOfA); i++){
            int removeChar = B.charAt(i) -97;
            int addChar = B.charAt(sizeOfA+i) -97;
            if(data.get(removeChar)>0){
                data.set(removeChar,data.get(removeChar)-1);
            }
            data.set(addChar,data.get(addChar)+1);
            if(Arrays.equals(alphabets.toArray(),data.toArray())){
                count++;
            }

        }

        return count;
    }
}

/*
older brute force approach
 // O(N*M)
 public int solve(String A, String B) {
        int sizeOfA = A.length();
        int sizeOfB = B.length();
        if(sizeOfA>sizeOfB){
            return 0;
        }
        ArrayList<Integer> alphabets = new ArrayList<>();
        for(int i=0; i<26; i++){
            alphabets.add(0);
        }
        for(int i=0; i<sizeOfA; i++){
            int ch = A.charAt(i) ;
            ch = ch -97;
            alphabets.set(ch,alphabets.get(ch)+1);
        }
        int count =0;
        int pointA =0;
        int pointB =sizeOfA;
        while(pointB<=sizeOfB){
            boolean found = true;
            ArrayList<Integer> test = new ArrayList<>();
            test = (ArrayList)alphabets.clone();
            for(int i=pointA; i<pointB; i++){
                int ch = B.charAt(i) -97;
                int val = test.get(ch);
                if(val==0){
                    found = false;
                    break;
                }else{
                    test.set(ch,test.get(ch)-1);
                }

            }
            if(found){
                count++;
            }
            pointA=pointA+1;
            pointB=pointB+1;
        }


        return count;
    }
}




 */
