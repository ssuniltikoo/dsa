
package dev.dsa.java.advance.searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MedianOfAnArray {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
//        List<Integer> arr1 = Arrays.asList(1,3,5,7,9);
//        List<Integer> arr2 = Arrays.asList(2,4,6,8,10,12,14,18,20);
//        List<Integer> arr1 = Arrays.asList(-43,-25,-18,-15,-10,9,39,40);
//        List<Integer> arr2 = Arrays.asList(-2);
        List<Integer> arr1 = Arrays.asList(-50, -47, -36, -35, 0, 13, 14, 16 );
        List<Integer> arr2 = Arrays.asList(-31, 1, 9, 23, 30, 39);
        System.out.println((solution.findMedianSortedArrays(arr1, arr2)));

    }
}

class Solution1 {
    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        int sizeOfA = a.size();
        int sizeOfB = b.size();
        if(sizeOfA > sizeOfB) {
           return findMedianSortedArrays(b,a);
        }
        int low = 0;
        int high = sizeOfA;
        int middle = (sizeOfA + sizeOfB +1)/2;
        while(low<= high) {
            int mid1 = (low + high) / 2;
            int mid2 = (middle - mid1);

            int ALeftValue = (mid1 == 0) ? Integer.MIN_VALUE : a.get(mid1 - 1).intValue();
            int ARightValue = (mid1 == sizeOfA) ? Integer.MAX_VALUE : a.get(mid1).intValue();

            int BLeftValue = (mid2 == 0) ? Integer.MIN_VALUE : b.get(mid2 - 1).intValue();
            int BRightValue = (mid2 == sizeOfB) ? Integer.MAX_VALUE : b.get(mid2).intValue();

            if ((ALeftValue <= BRightValue) && (BLeftValue <= ARightValue)) {
                // AL AR
                // L   R
                // Bl BR
                int maxLeft = Math.max(ALeftValue, BLeftValue);
                int minRight = Math.min(ARightValue, BRightValue);
                int total = sizeOfA + sizeOfB;
                if ((total%2) == 0) {
                    return (0.5 * (maxLeft + minRight));
                }
                return (double) maxLeft;
            } else if (ALeftValue > BRightValue) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }
        return (0.0);

    }




}