package dev.dsa.java.advance.queues;

import java.util.LinkedList;
import java.util.Queue;

/*
    Given an integer A, you have to find the Ath Perfect Number.

A Perfect Number has the following properties:

It comprises only 1 and 2.
The number of digits in a Perfect number is even.
It is a palindrome number.
For example, 11, 22, 112211 are Perfect numbers, where 123, 121, 782, 1 are not.






 */
public class PerfectNumbers {
    public static void main(String[] args) {
        SolveQueue solveQueue = new SolveQueue();
        System.out.println(solveQueue.solve(10000000));
    }
}
class SolveQueue {
    public String solve(int A) {
//
//        String a="1";
//        String b= "2";
        if(A == 1)
            return "11";
        else if (A == 2)
            return "22";

        Queue<String> que = new LinkedList<String>();
        que.add("1");
        que.add("2");
        int count =0;
        while(count != A){
            String val = que.remove();
            que.add(val+"1");
            que.add(val+"2");
            count++;
            if(count==A){
                StringBuilder str = new StringBuilder(val);
                return val + str.reverse().toString();
            }
        }

        return "";
    }

}