package dev.dsa.java.advance.searching;

/*
    Problem Description

Farmer John has built a new long barn with N stalls.
Given an array of integers A of size N where each element of the array represents
the location of the stall and an integer B which represents the number of cows.

His cows don't like this barn layout and become aggressive towards each other once put into a stall.
To prevent the cows from hurting each other, John wants to assign the cows to the stalls, 
such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?



Problem Constraints

2 <= N <= 100000
0 <= A[i] <= 109


 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AggressiveCows {
    public static void main(String[] args) {
        Cows c = new Cows();
        // first use case number of cows equal to size of array
//        List<Integer> data1 =Arrays.asList(1,2,10,50,125);
//        ArrayList<Integer> arrData1 = new ArrayList<>();
//        arrData1.addAll(data1);
//        System.out.println(c.solve(arrData1,5));
//        // 2nd use case number of cows equal to size of array
//        List<Integer> data2 =Arrays.asList(1,2,10,50,125);
//        ArrayList<Integer> arrData2 = new ArrayList<>();
//        arrData1.addAll(data2);
//        System.out.println(c.solve(arrData2,2));
        // 3nd use case : number of cows equal to size of array
        List<Integer> data3 =Arrays.asList(82,61,38,88,12,7,6,12,48,8,31,90,35,5,88,2,66,19,5,96,84,95);
        ArrayList<Integer> arrData3 = new ArrayList<>();
        arrData3.addAll(data3);
        System.out.println(c.solve(arrData3,8));

        List<Integer> data4 =Arrays.asList(5,17,100,11);
        ArrayList<Integer> arrData4 = new ArrayList<>();
        arrData4.addAll(data4);
        System.out.println(c.solve(arrData4,2));
    }
}

 class Cows {
    public int solve(ArrayList<Integer> A, int B) {
        // [ 5   10   15   20 ]
        // find low and high
        Collections.sort(A);
        int low = 1;
        int size = A.size();
        int high = A.get(size-1) -low;
        int min = findMinDistanceInArray(A);
        int ans =0;
        // edge conditions - if size of array equal to number of cows
        if(B==2){

            return  Math.abs(A.get(size-1) -A.get(0));
        }

        // if(size==B){
        //     return Math.abs(high-low);
        // }
        while(low <= high){
            int mid = low + (high - low) / 2;
            int adjCows = findAdjustedCows(A,mid,B);
            if(adjCows>=B){
                low = mid+1;
                ans=mid;
            }else{
                high = mid-1;
                // ans=mid;
            }
        }

        return ans;

    }

     private int findAdjustedCows(ArrayList<Integer> a, int mid,int B) {
         int count =1;
         int ref = a.get(0);
         for(int i =1; i<a.size();i++){
             if(Math.abs(a.get(i)-ref)>=mid){
                 count++;
                 ref = a.get(i);

                 // if(count==B){
                 //     return B;
                 // }
             }
         }
         return count;
     }

     private int findMinDistanceInArray(ArrayList<Integer> A){
         int min = Integer.MAX_VALUE;
         for(int i =0; i < A.size(); i++){
             if(min > A.get(i)){
                 min = A.get(i);
             }
         }
         return min;
     }
     private int findMaxDistanceInArray(ArrayList<Integer> A){
         int max = Integer.MIN_VALUE;
         for(int i =0; i < A.size(); i++){
             if(max < A.get(i)){
                 max = A.get(i);
             }
         }
         return max;
     }
 }