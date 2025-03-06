package dev.dsa.java.advance.searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
/*
* @Docs
* @@@
* Problem Description

Given a sorted array of integers A where every element appears twice except for one element which appears once,
*  find and return this single element that appears only once.

Elements which are appearing twice are adjacent to each other.

NOTE:  solve this in O(log(N)) time.
*
* This problem can also be solved using bit manuulation using XROX but tc is o(N) is same elemt exist xor of same bits is 0, uing that technique we can get answer of that problem
*
* but as array is already sorted we have to find solution in log time
*
* Approach
* e.g [1 1 3 3 6 6 7 8 8 9  9  15  15]
* ind [0 1 2 3 4 5 6 7 8 9 10  11 12]
* on observation index of 1st element is at even index and post unique element ind of first elemet is at odd position using this
* we can solve this in log time
*
*
*
* */

public class SingleElementInSortedArray {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = {13 , 13,21,21,27,50,50,102,102,108,108,110,110,117,117,120,120,123,123,124,124,132,132,164,164,166,166,190,190,200,200,212,
                212,217,217,225,225,238,238,261,261,276,276,347,347,348,348,386,386,394,394,405,405,426,426,435,435,474,474,493,493};

        List<Integer> input = Arrays.asList(13 , 13,21,21,27,50,50,102,102,108,108,110,110,117,117,120,120,123,123,124,124,132,132,164,164,166,166,190,190,200,200,212,
                212,217,217,225,225,238,238,261,261,276,276,347,347,348,348,386,386,394,394,405,405,426,426,435,435,474,474,493,493);
        ArrayList output = new ArrayList();
        output.addAll(input.stream().toList());
//        for(Integer a: input){
//            output.add(a);
//        }


        System.out.println(solution.solve(output));
    }
}

class Solution{
    public int solve(ArrayList<Integer> A) {

        int start =0 ;
        int end = A.size() -1 ;
        int ans = 0;
        int mid =-1;
        // edge case only 1 element
        if(end==0){
            return A.get(0);
        }
        //edge case if first elemnent is unique
        if(!A.get(0).equals(A.get(0+1))){
            return A.get(0);
        }
        // edge case if last elemnt is unique
        if(!A.get(end).equals(A.get(end-1))){
            return A.get(end);
        }

        // when unique elemnt is in middle
        while(start<=end ){
            mid = (start + ((end-start)/2)); // to avoid over flow

            // if mid element is neither equal to one element before or after we have reached to our answer
            // [ 3 4 6]
            if( (!A.get(mid).equals(A.get(mid-1))) && (!A.get(mid).equals(A.get(mid+1)))   ){
                return A.get(mid);
            }
            // we are in  space  search before our unique element
            if( ( A.get(mid).equals(A.get(mid+1)) ) && (mid %2==0) ){
                start = mid+1;
            }

            if( ( A.get(mid).equals(A.get(mid-1)) ) && ((mid-1) %2==0) ){
                start = mid+1;
            }

            if( ( A.get(mid).equals(A.get(mid+1)) ) && ((mid) %2!=0 )){
                end = mid-1;
            }

            if( ( A.get(mid).equals(A.get(mid-1))) && ((mid-1) %2!=0) ){
                end = mid-1;
            }

        }

        return A.get(start);
    }
}
