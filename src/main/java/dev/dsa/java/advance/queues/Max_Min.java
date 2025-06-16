package dev.dsa.java.advance.queues;

/*
    Given an array of integers A.


The value of an array is computed as the difference between the maximum element in the array and the minimum element in the array A.

Calculate and return the sum of values of all possible subarrays of A modulo 109+7.






 */

import java.util.ArrayList;
import java.util.Stack;

public class Max_Min {
}
//
//class Solution {
//    public int solve(ArrayList<Integer> A) {
//        int n = A.size();
//        int mod = 1000000007;
//
//        // Arrays to store nearest smaller elements for left and right
//        int[] nsr = new int[n];  // Nearest smaller to right
//        int[] nsl = new int[n];  // Nearest smaller to left
//
//        // Arrays to store nearest greater elements for left and right
//        int[] ngr = new int[n];  // Nearest greater to right
//        int[] ngl = new int[n];  // Nearest greater to left
//
//        Stack<Integer> s = new Stack<>();
//
//        // Fill NSR (Nearest Smaller to Right)
//        for (int i = n - 1; i >= 0; i--) {
//            while (!s.isEmpty() && A[s.peek()] >= A[i]) {
//                s.pop();
//            }
//            nsr[i] = s.isEmpty() ? n : s.peek();
//            s.push(i);
//        }
//
//        s.clear();
//
//        // Fill NSL (Nearest Smaller to Left)
//        for (int i = 0; i < n; i++) {
//            while (!s.isEmpty() && A[s.peek()] > A[i]) s.pop();
//            nsl[i] = s.isEmpty() ? -1 : s.peek();
//            s.push(i);
//        }
//
//        s.clear();
//
//        // Fill NGR (Nearest Greater to Right)
//        for (int i = n - 1; i >= 0; i--) {
//            while (!s.isEmpty() && A[s.peek()] <= A[i]) s.pop();
//            ngr[i] = s.isEmpty() ? n : s.peek();
//            s.push(i);
//        }
//
//        s.clear();
//
//        // Fill NGL (Nearest Greater to Left)
//        for (int i = 0; i < n; i++) {
//            while (!s.isEmpty() && A[s.peek()] < A[i]) s.pop();
//            ngl[i] = s.isEmpty() ? -1 : s.peek();
//            s.push(i);
//        }
//
//        long sum = 0;
//
//        // Calculate total sum by subtracting contribution of min and max for each subarray
//        for (int i = 0; i < n; i++) {
//            long maxCnt = (long) (i - ngl[i]) * (ngr[i] - i) % mod; // checking here overflow condition
//            long minCnt = (long) (i - nsl[i]) * (nsr[i] - i) % mod; // checking here overflow condition
//
//            sum = (sum + A[i] * (maxCnt - minCnt) % mod) % mod;
//        }
//
//        return (int) ((sum + mod) % mod);
//    }
//}
//