package dev.dsa.java.advance.searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

        if(end==0){
            return A.get(0);
        }

        if(!A.get(0).equals(A.get(0+1))){
            return A.get(0);
        }

        if(!A.get(end).equals(A.get(end-1))){
            return A.get(end);
        }

        while(start<=end ){
            mid = (start + ((end-start)/2));

           // if(  ((!A.get(mid).equals(A.get(mid -1))) && A.get(mid) != A.get(mid+1) ) ){
            if( (!A.get(mid).equals(A.get(mid-1))) && (!A.get(mid).equals(A.get(mid+1)))   ){
                return A.get(mid);
            }

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
