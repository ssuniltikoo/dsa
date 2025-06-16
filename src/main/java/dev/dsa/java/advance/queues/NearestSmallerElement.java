package dev.dsa.java.advance.queues;

/*
    Given an array A, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.


More formally,

G[i] for an element A[i] = an element A[j] such that

j is maximum possible AND

j < i AND

A[j] < A[i]

Elements for which no smaller element exist, consider the next smaller element as -1.


 */

import java.util.ArrayList;
import java.util.Stack;

public class NearestSmallerElement {

}

class SolutionProblem {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        ArrayList<Integer> nearest = new ArrayList();
        nearest.add(-1);
        Stack<Integer> leastNumber = new Stack();
        int counter = 0;
        leastNumber.push(A.get(0));
        for(int i=1; i < A.size(); i++ ){

            while(counter>=0){
                int currentNumber = A.get(i);
                int smallerNumber = leastNumber.peek();

                if(currentNumber > smallerNumber){
                    nearest.add(smallerNumber);
                    counter++;
                    leastNumber.push(currentNumber);
                    break;
                }else{
                    leastNumber.pop();
                    counter--;
                }
            }

            if(counter<0){
                nearest.add(-1);
                leastNumber.push(A.get(i));
                counter++;
            }


        }
        return nearest;
    }
}

