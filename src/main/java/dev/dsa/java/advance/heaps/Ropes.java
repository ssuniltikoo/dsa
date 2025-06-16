package dev.dsa.java.advance.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
You are given an array A of integers that represent the lengths of ropes.




You need to connect these ropes into one rope. The cost of joining two ropes equals the sum of their lengths.

Find and return the minimum cost to connect these ropes into one rope.






Problem Constraints

1 <= length of the array <= 100000
1 <= A[i] <= 1000



 */
public class Ropes {
    public static void main(String[] args) {
        RopesSolution solution = new RopesSolution();
        List<Integer> d = Arrays.asList(5, 17, 100, 11);
        ArrayList<Integer> data = new ArrayList<>();
        data.addAll(d);
        System.out.println(solution.solve(data));
    }
}

class RopesSolution {

    public int solve(ArrayList<Integer> A) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue();
        for(int i=0; i < A.size(); i++){
            priorityQueue.add(A.get(i));
        }

        int total =0;

        while(priorityQueue.size() > 1){
            int firstEle = priorityQueue.poll();
            int secondEle = priorityQueue.poll();
            total+=firstEle + secondEle;
            priorityQueue.add(firstEle+secondEle);

        }

        return total;

    }

}



