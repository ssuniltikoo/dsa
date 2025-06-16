package dev.dsa.java.advance.queues;
/*

    Given an array of integers A.


A represents a histogram i.e A[i] denotes the height of the ith histogram's bar. Width of each bar is 1.

Find the area of the largest rectangle formed by the histogram.




 */

import java.util.ArrayList;
import java.util.Stack;

public class RectanglesInHistorgram {

}
class SolutionRectangle {
    public int largestRectangleArea(ArrayList<Integer> A) {
        ArrayList<Integer> left = calculateLeft(A);
        ArrayList<Integer> Right = calculateRight(A);
        ArrayList<Integer> min = new ArrayList();
        for(int i=0; i<A.size(); i++){
            min.add( ((left.get(i) + Right.get(i) ) -1 ) * A.get(i));
        }
        // System.out.println(min);
        return findMax(min);
        // return 1;

    }

    public int findMax(ArrayList<Integer> hist){
        int ans = hist.get(0);
        for(int i=1; i < hist.size(); i++){
            if(hist.get(i) > ans)
                ans = hist.get(i);
        }
        return ans;
    }

    public ArrayList<Integer> calculateLeft(ArrayList<Integer> A){
        ArrayList<Integer> temp = new ArrayList();
        Stack<Integer> min = new Stack();
        int counter =-1;

        for(int i=0; i < A.size(); i++){

            while(true){
                if(counter==-1)
                {
                    temp.add(i-counter);
                    min.push(i);
                    counter++;
                    break;
                }

                if(A.get(i) > A.get(min.peek())){

                    temp.add(i-min.peek());
                    min.push(i);
                    counter++;
                    break;
                }else{
                    min.pop();
                    counter--;
                }
            }
        }





        // for(int i=0; i < A.size(); i++){
        //     counter=i;
        //     while(counter>=-1){
        //        // counter--;
        //         if(counter==-1){
        //             temp.add(i-counter);
        //             break;
        //         }else if(A.get(i)>A.get(counter)) {
        //             temp.add(i-counter);
        //             break;
        //         }else{
        //             counter--;
        //         }
        //     }

        // }

        // System.out.println(temp);
        return temp;
    }

    public ArrayList<Integer> calculateRight(ArrayList<Integer> A){
        ArrayList<Integer> temp = new ArrayList();
        int size= A.size();
        Stack<Integer> min = new Stack();
        int counter =-1;

        for(int j=0; j<size; j++){
            temp.add(0);
        }

        for(int i=size-1 ; i >= 0; i--){

            while(true){
                if(counter==-1)
                {
                    temp.set(i,size-i);
                    min.push(i);
                    counter++;
                    break;
                }

                if(A.get(i) > A.get(min.peek())){

                    temp.set(i,min.peek()-i);
                    min.push(i);
                    counter++;
                    break;
                }else{
                    min.pop();
                    counter--;
                }
            }
        }







        // for(int i=0; i < size; i++){
        //     counter=i;
        //     while(counter<=size){

        //         if(counter==size){
        //             temp.add(counter-i);
        //             break;
        //         }else if(A.get(i)>A.get(counter)) {
        //             temp.add(counter-i);
        //             break;
        //         }else{
        //             counter++;
        //         }
        //     }

        // }
        // System.out.println(temp);
        return temp;
    }
}


