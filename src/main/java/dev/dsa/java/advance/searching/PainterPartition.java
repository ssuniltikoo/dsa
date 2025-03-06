package dev.dsa.java.advance.searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Painter partation problem
/*
    In this problem we have give array A []

    Problem Description

Given 2 integers A and B and an array of integers C of size N. Element C[i] represents the length of ith board.
You have to paint all N boards [C0, C1, C2, C3 … CN-1]. There are A painters available and each of them takes
B units of time to paint 1 unit of the board.

Calculate and return the minimum time required to paint all boards under the constraints that any painter will only
paint contiguous sections of the board.
NOTE:
1. 2 painters cannot share a board to paint. That is to say, a board cannot be painted partially by one painter, and partially by another.
2. A painter will only paint contiguous boards. This means a configuration where painter 1 paints boards 1 and 3 but not 2 is invalid.

Return the ans % 10000003.

 */

public class PainterPartition {

    public static void main(String[] args) {
        FindMinimumTime    fmt = new FindMinimumTime();
//        List<Integer> input = Arrays.asList(5,3,6,1,9);
        List<Integer> input = Arrays.asList(1000000,1000000);
        ArrayList<Integer> arrInput = new ArrayList<>();
        arrInput.addAll(input);
        System.out.println(fmt.paint(1,1000000,arrInput));
    }
}

class FindMinimumTime{

    public int paint(int painters, int timeRequired, ArrayList<Integer> boards){

        ArrayList<Long>  boardTime = new ArrayList<Long>();
        long max = -1;
        long sum =0;
        int mod = 10000003;
        for(int i = 0 ; i < boards.size() ; i++ ){
            // find
            long a = (boards.get(i)%(mod));
            long b = (timeRequired%mod);
            // time required to paint board = board length * time unit /unit board
            long timeReq = (a*b)%mod;
            // fimd max of board
            max = Math.max(max,timeReq);
            // add all values of time required in array
            boardTime.add(timeReq);
            // total sum required to paint all boards
            sum += boardTime.get(i);
        }

        long ans = sum;
        long start =1L;
        long end = sum;
        long mid = (start+end)/2; // get mid from start and end
        int count =1;
        long limit = mid;
        // search space from start = 1 to end = sum of all
        while(start <= end){
            count=1; // start count of paimnters =1
            int var =0;
            long assignWork = 0L;
            while(count<=painters && var< boards.size() ){  // condition to check if number of painters required is less than actual painters given

                if(assignWork + boardTime.get(var) >= mid){ //
                    count++;
                    assignWork=0; // as new painter is added set assignwed work to 0
                }
                assignWork+=boardTime.get(var); // assign greedly all boards to painter , assign more and more boards to painter
                var++; // var to note it don't over flows array size
            }

            if(count>painters){  // if number of  painters required is  more than given
                start=mid+1; // move search space to right
            }else{

                end = mid-1;  // move search space to left
                ans=mid-1; //
            }
            mid = (start+end)/2; // new mid


        }
        if(ans>=max)
            return (int)(ans%10000003);
        else
            return  (int)(max%10000003);
    }
}
