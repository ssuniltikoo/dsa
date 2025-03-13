package dev.dsa.java.advance.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* Given a sorted array of integers (not necessarily distinct) A and an integer B, find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.

Since the number of such pairs can be very large, return number of such pairs modulo (109 + 7).
* */
public class PairWithGivenSum {

    public static void main(String[] args) {
        PairSum pair = new PairSum();
        ArrayList<Integer> list = new ArrayList<>();
        List<Integer> data1 = Arrays.asList(2,2,2,2,2,2);
        list.addAll(data1);
        System.out.println(pair.solve(list,4));

    }
}

 class PairSum {
    public int solve(ArrayList<Integer> A, int B) {
        int len = A.size();
        int l =0;
        int r=len-1;
        int count =0;
        boolean flag = false;
        while(l<r && l<len && r >= 0){
            if(flag){
                break;
            }
            int sum = A.get(l) + A.get(r);
            if(sum>B){
                r--;
            }else if (sum < B){
                l++;
            }else{
                int lCounter=1;
                int rCounter =1;

                int sameNumberCounter=0;
                while(l<r && l<len && r >= 0 ){
                    if(A.get(l).equals(A.get(r))){
                        flag = true;
                        sameNumberCounter=(r-l)+1;
                        break;
                    }else if(A.get(r).equals(A.get(r-1))){
                        rCounter++;
                        r--;
                    }else if(A.get(l).equals(A.get(l+1))){
                        lCounter++;
                        l++;
                    }else{

                        break;
                    }
                }
                int p =(rCounter*lCounter) ;
                int sumOfSameNumbers=(sameNumberCounter*(sameNumberCounter-1))/2;
                if(!flag)
                    count+=p;
                else
                    count+=sumOfSameNumbers;

                l++;
                r--;
            }
        }
        
        return count;
    }
}
