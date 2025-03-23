package dev.dsa.java.advance.hashing;

import java.util.ArrayList;

/*
    Given a binary string A of size N. There are Q queries given by the 2-D array B of size Q x 2.

Each query has 2 integers :-

First integer denotes the type of query. Type of query can be either 1 or 2.
Second integer denotes index x.
If type = 1, Flip the value at index x.

If type = 2, Find the index of the nearest 1 to the left or right of index x in the array.
If there are multiple indices has the same distance from x, return the index with the lower value. If there is no occurrence of 1 in the array, return -1.


 */

public class FlipAndFindNearestStore {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add(2);
        row1.add(4);
        input.add(row1);
//        ArrayList<Integer> row2 = new ArrayList<>();
//        row2.add(1);
//        row2.add(7);
//        input.add(row2);
//        ArrayList<Integer> row3 = new ArrayList<>();
//        row3.add(2);
//        row3.add(9);
//        input.add(row3);
        System.out.println(solution.solve("10010",input));
    }
}

class Solution {
    public ArrayList<Integer> solve(String A, ArrayList<ArrayList<Integer>> B) {

        int strLen = A.length();
        ArrayList<Integer> input = new ArrayList();
        for(int i=0; i<strLen; i++){
            char a  = A.charAt(i);
            int b = a-48;
            input.add(b);
        }
        ArrayList<Integer> ouput = new ArrayList();
        int len = B.size();
        for(int i =0; i<len; i++){
            int ops = B.get(i).get(0);
            if(ops==1){
                int value = B.get(i).get(1)-1;
                input.set(value,input.get(value).equals(1)?0:1);
            }else{
                int value = B.get(i).get(1)-1;
                int out =findNearestStoreForIndex(input,value);
                ouput.add(out);
            }
        }
        return ouput;
    }

    private int findNearestStoreForIndex(ArrayList<Integer> input, int value) {
        int leftPos = value-1;
        int rightPos = value+1;
        int leftDistance = input.size();
        int rightDistance = input.size();
        if(input.get(value).equals(1)){
            return value+1;
        }
        while(leftPos>=0){
            if(input.get(leftPos).equals(1)){
                leftDistance=value-leftPos;
                break;
            }
            leftPos--;
        }
        while(rightPos<input.size()){
            if(input.get(rightPos).equals(1)){
                rightDistance=rightPos-value;
                break;
            }
           rightPos++;
        }
        if(leftDistance==rightDistance &&(leftDistance!=input.size())){
            return leftPos+1;
        }
        if(leftDistance<rightDistance){
            return leftPos+1;
        }
        if(leftDistance>rightDistance){
            return rightPos+1;
        }

        return -1;
    }


}
