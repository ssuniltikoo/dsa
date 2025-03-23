package dev.dsa.java.advance.hashing;

import java.util.*;
/*
* Given two arrays of integers A and B of size N each, where each pair (A[i], B[i]) for 0 <= i < N represents a unique point (x, y) in a 2-D Cartesian plane.

Find and return the number of unordered quadruplet (i, j, k, l) such that (A[i], B[i]), (A[j], B[j]), (A[k], B[k]) and (A[l], B[l]) form a rectangle with the rectangle having all the sides parallel to either x-axis or y-axis.


*
* */

public class CountRectangles {
    public static void main(String[] args) {
        List<Integer> x = Arrays.asList(1, 1, 2, 2, 3, 3);
        List<Integer> y = Arrays.asList(1, 2, 1, 2, 1, 2);
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();
        A.addAll(x);
        B.addAll(y);
        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle.solve(A,B));
    }
}

class Rectangle {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int len = A.size();
        // create set to store all coordinates
        Set<String> coordinates = new HashSet<>();
        for(int i =0 ; i <len;i++){
            coordinates.add(A.get(i)+","+B.get(i));
        }
        // find valid diagonals
        int rectanglesCount =0;
        for(int i =0 ; i<len;i++){
            for(int j=i+1; j<len;j++){
                int x1=  A.get(i);
                int y1= B.get(i);
                int x2=  A.get(j);
                int y2 = B.get(j);
                // check for valid diagonal - valid diagonal will form only if x1 <> x2 and y1 <> y2 => x1 = 1 y1 = 2 , x2 = 2 , y2 = 1
                if(x1!=x2 && y1 != y2){
                    if(coordinates.contains(x1+","+y2)  && coordinates.contains(x2+","+y1)){
                        rectanglesCount++;
                    }
                }

            }
        }

        return rectanglesCount/2;
    }

}