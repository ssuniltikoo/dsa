package dev.dsa.java.advance.sorting;

import java.util.ArrayList;
import java.util.List;

public class InversionCount {
    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<>();
        test.add(5);
        test.add(4);
        test.add(3);
        test.add(1);
        test.add(2);
        Solution solution = new Solution();
        solution.solve(test);
    }
}

class Solution {
    private long count = 0;
    private final int MOD = 1000000007;

    public int solve(ArrayList<Integer> A) {
        mergeSort(A, 0, A.size() - 1);
        return (int) (count % MOD);
    }

    private void mergeSort(ArrayList<Integer> A, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(A, start, mid);
            mergeSort(A, mid + 1, end);
            merge(A, start, mid, end);
        }
    }

    private void merge(ArrayList<Integer> A, int start, int mid, int end) {
        ArrayList<Integer> left = new ArrayList<>(A.subList(start, mid + 1));
        ArrayList<Integer> right = new ArrayList<>(A.subList(mid + 1, end + 1));

        int i = 0, j = 0, k = start;
        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) {
                A.set(k++, left.get(i++));
            } else {
                A.set(k++, right.get(j++));
                count = (count + (mid - start + 1 - i)) % MOD;
            }
        }

        while (i < left.size()) A.set(k++, left.get(i++));
        while (j < right.size()) A.set(k++, right.get(j++));
    }
}

