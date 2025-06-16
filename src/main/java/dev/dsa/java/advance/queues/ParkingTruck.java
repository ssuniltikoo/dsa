package dev.dsa.java.advance.queues;

import java.util.ArrayList;
import java.util.List;

/*

Imagine you're an ice cream truck driver in a beachside town. The beach is divided into several sections, and each section has varying numbers of beachgoers wanting ice cream given by the array of integers A.

For simplicity, let's say the beach is divided into 8 sections. One day, you note down the number of potential customers in each section: [5, 12, 3, 4, 8, 10, 2, 7]. This means there are 5 people in the first section, 12 in the second, and so on.

You can only stop your truck in B consecutive sections at a time because of parking restrictions. To maximize sales, you want to park where the most customers are clustered together.

For all B consecutive sections, identify the busiest stretch to park your ice cream truck and serve the most customers. Return an array C, where C[i] is the busiest section in each of the B consecutive sections. Refer to the given example for clarity.

NOTE: If B > length of the array, return 1 element with the max of the array.
 */
public class ParkingTruck {
}
class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        ArrayList<Integer> max = new ArrayList();
        int start =0;

        int end = B-1;


        int iDx = findMax(A, end, start) ;
        max.add(A.get(iDx));

        while(end<A.size()-1){
            start++;
            end++;

            if((start) >= iDx){

                iDx = findMax(A, end, start) ;
                max.add(A.get(iDx));
            }else{

                if(A.get(end) >= A.get(iDx)){
                    max.add(A.get(end));
                    iDx=end;
                }else
                    max.add(A.get(iDx));
            }

        }
        return max;
    }

    private int findMax(List<Integer> A, int end, int start){
        int idx= -1;
        int ans = Integer.MIN_VALUE;
        while(end >= start){
            if(A.get(start)>ans){
                ans = A.get(start);
                idx = start;
            }
            start++;
        }
        return idx;
    }
}
