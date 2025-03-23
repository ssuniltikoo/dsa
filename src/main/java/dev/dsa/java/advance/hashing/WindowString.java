package dev.dsa.java.advance.hashing;

import java.util.HashMap;
import java.util.Map;

/*
* Given a string A and a string B, find the window with minimum length in A, which will contain all the characters in B in linear time complexity.
Note that when the count of a character c in B is x, then the count of c in the minimum window in A should be at least x.

Note:

If there is no such window in A that covers all characters in B, return the empty string.
If there are multiple such windows, return the first occurring minimum window ( with minimum start index and length )
*
* */
public class WindowString {
    public static void main(String[] args) {

    }
}

class Window{
    public String minWindow(String A, String B) {
        int start = 0;
        int end = 0;
        int len = A.length();
        int len2 = B.length();
        Map<Character,Integer> freB = new HashMap<>();
        for(int i=0; i <len2;i++){
            if(!freB.containsKey(B.charAt(i))){
                freB.put(B.charAt(i),1);
            }else{
                freB.put(B.charAt(i),freB.get(B.charAt(i))+1);
            }
        }

        Map<Character,Integer> minWindFre = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        while(end <len){
           if(comapre2Maps(freB,minWindFre)){
               break;
            }
            if(freB.containsKey(A.charAt(end))){
                if(!minWindFre.containsKey(A.charAt(end))){
                    freB.put(B.charAt(end),1);
                }else{
                    freB.put(B.charAt(end),freB.get(B.charAt(end))+1);
                }
            }
            end++;
        }
        ans = Math.min(ans,end-start);


        return A.substring(start,end);
    }

    private boolean comapre2Maps(Map<Character, Integer> freB, Map<Character, Integer> minWindFre) {
        if(freB.size() != minWindFre.size()){
            return false;
        }
        for(Map.Entry<Character, Integer> entry : freB.entrySet()){
            Character key = entry.getKey();
            if(!freB.get(key).equals(minWindFre.get(key))){
                return false;

            }
        }
        return true;
    }
}
