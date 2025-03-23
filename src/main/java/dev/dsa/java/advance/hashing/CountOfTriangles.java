package dev.dsa.java.advance.hashing;

import java.util.*;

/*

Problem Description

Given two arrays of integers A and B of size N each, where each pair (A[i], B[i]) for 0 <= i < N represents a unique point (x, y) in 2D Cartesian plane.

Find and return the number of unordered triplets (i, j, k) such that (A[i], B[i]), (A[j], B[j]) and (A[k], B[k]) form a right-angled triangle with the triangle having one side parallel to the x-axis and one side parallel to the y-axis.

NOTE: The answer may be large so return the answer modulo (109 + 7).


 */
public class CountOfTriangles {
    public static void main(String[] args) {

    }
}

class Triangles{
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int len = A.size();
        int mod = 1000000007;
        Map<Integer,Integer> xCoordinatesFre = new HashMap<>();
        Map<Integer,Integer> yCoordinatesFre = new HashMap<>();
        for(int i =0 ; i < len;i++){
            if(!xCoordinatesFre.containsKey(A.get(i))){
                xCoordinatesFre.put(A.get(i),1);
            }else{
                xCoordinatesFre.put(A.get(i),xCoordinatesFre.get(A.get(i))+1);
            }
        }

        for(int i =0 ; i < len;i++){
            if(!yCoordinatesFre.containsKey(B.get(i))){
                yCoordinatesFre.put(B.get(i),1);
            }else{
                xCoordinatesFre.put(B.get(i),xCoordinatesFre.get(B.get(i))+1);
            }
        }

        long numberOfTriangles =0;
        for(int i =0; i < len;i++){
            int x = A.get(i);
            int y = B.get(i);
            // here we will compare if x and y are present and they will be in hash map but with how many frequesies
            // as frequescy of few coordinates wull be more than 1 , it will form right angle tiagle
            // fre of x -1 * freof y -1
            int freX = xCoordinatesFre.get(x);
            int freY = yCoordinatesFre.get(y);
            numberOfTriangles += (freX-1)*(freY-1);

        }


        return (int)(numberOfTriangles%mod);
    }
}
