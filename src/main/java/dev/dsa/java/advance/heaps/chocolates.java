package dev.dsa.java.advance.heaps;
/*

Given N bags, each bag contains Bi chocolates. There is a kid and a magician.
In a unit of time, the kid can choose any bag i, and eat Bi chocolates from it, then the magician will fill the ith bag with floor(Bi/2) chocolates.






Find the maximum number of chocolates that the kid can eat in A units of time.

NOTE:

floor() function returns the largest integer less than or equal to a given number.
Return your answer modulo 109+7







 */

import java.sql.SQLOutput;
import java.util.*;

public class chocolates {
    public static void main(String[] args) {
        Boy boy = new Boy();
        List<Integer> d = Arrays.asList(2,8,6,5,10);
        ArrayList<Integer> data = new ArrayList<>();
        data.addAll(d);
        System.out.println(boy.eat(5,data));
    }


}

class Boy {
    public int eat(int A, ArrayList<Integer> B) {

        PriorityQueue<Integer> data =new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i =0 ; i < B.size(); i++){
            data.add(B.get(i));
        }

        int timer=1;
        long totalCholates =0;

        while(timer <= A && data.size() >0){
            long maxCh =(long) data.poll();
            // System.out.println("maxCh"+ maxCh);
            totalCholates=( (totalCholates%(1000000007) ) + (maxCh % (1000000007)) ) ;
            //  System.out.println("totalCholates  " + totalCholates);
            // totalCholates+=maxCh;
            data.add((int)(maxCh/2));
            timer++;

        }

        //  return ((int)totalCholates%(1000000007));
        return (int) (totalCholates%(1000000007));

    }
}
