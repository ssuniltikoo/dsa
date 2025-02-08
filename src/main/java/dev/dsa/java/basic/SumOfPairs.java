package dev.dsa.java.basic;

import java.util.ArrayList;
import java.util.Arrays;

public class SumOfPairs {
    public static void main(String[] args) {
        ArrayList<Integer> lsitArray = new ArrayList<>();
        Arrays.sort(lsitArray.toArray());
        lsitArray.sort(Integer::compareTo);
    }
}
