
package dev.dsa.java.advance.searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* @ docs
* Problem Description
There are two sorted arrays A and B of sizes N and M respectively.
Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).
NOTE:
The overall run time complexity should be O(log(m+n)).
IF the number of elements in the merged array is even,
* then the median is the average of (n/2)th and (n/2+1)th element.
* For example, if the array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5.
*
* ==================APPROACH TO SOLVE=============================
* AS both arrays A and B are sorted  - one approach is to merge both sprted arrays like merge sort but then complexity will be o(nlog) and we have
* solve this in O(LOG(N+M))
* -------------------------------------
* how to solve this using O(log(N+M)
* we neeed to find mid1 of left array and mid2 of right array
*  if leftofAarray < rightOFBArray |  leftofBArray < rightOf
*
*
* ================================================================
* */

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
        // move min array to left and right to left
        if(sizeOfA > sizeOfB) {
           return findMedianSortedArrays(b,a);
        }
        //
        int low = 0;
        // high of A
        int high = sizeOfA;
        // find middle of both arrays [aSize+ bSize +1/2]
        int middle = (sizeOfA + sizeOfB +1)/2;

        while(low<= high) {
            // middle index of first array
            int mid1 = (low + high) / 2;
            // middle index of second array [ middle of both arrays  - middle of A array]
            int mid2 = (middle - mid1);

            // ALeftValue --> mid - 1 value
            int ALeftValue = (mid1 == 0) ? Integer.MIN_VALUE : a.get(mid1 - 1).intValue();
            // left array mid value
            int ARightValue = (mid1 == sizeOfA) ? Integer.MAX_VALUE : a.get(mid1).intValue();
            // mid - 1 right value of right array
            int BLeftValue = (mid2 == 0) ? Integer.MIN_VALUE : b.get(mid2 - 1).intValue();
            // array b mid value
            int BRightValue = (mid2 == sizeOfB) ? Integer.MAX_VALUE : b.get(mid2).intValue();

            // now compare left array  L R value wirh right array L R values
            // like LeftA < RightB && LEFTB < ARIGHT if this condition satisfies we have god our right mid 1 and mid2 value
            if ((ALeftValue <= BRightValue) && (BLeftValue <= ARightValue)) {
                // AL AR
                // L   R
                // Bl BR
                // find max of left value from both arrays and get that
                int maxLeft = Math.max(ALeftValue, BLeftValue);
                // find min of right value of both arrays and pick it
                int minRight = Math.min(ARightValue, BRightValue);
                int total = sizeOfA + sizeOfB;
                if ((total%2) == 0) {
                    // if array size of a + b is even then max left +miright /2 is ans
                    return (0.5 * (maxLeft + minRight));
                }
                // if odd then our answer is max of left arrays
                return (double) maxLeft;
            }// if our left array left value is greater  than right array then our high will be mid1 -1 so that our mid moves towards left
            else if (ALeftValue > BRightValue) {
                high = mid1 - 1;
            } else { // if aleft value is low than bright value then we need to move mid1 to left low = mid+1
                low = mid1 + 1;
            }
        }
        return (0.0);

    }




}