package dev.dsa.java.advance.twopointer;

import java.util.*;

public class DiffCountPair {
    public static void main(String[] args) {

    }
}

class Soluti {
    public int solve(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        int length = A.size();
        Set<Integer> output = new HashSet();
        for(int i=0; i <length; i++){
            output.add(A.get(i));
        }
        ArrayList<Integer> data = new ArrayList();
        Iterator<Integer> it = output.iterator();
        while(it.hasNext()){
            data.add(it.next());
        }

        int l =0;
        int r = 1;
        int count =0;

        while(l<r && r <data.size()){
            int diff = Math.abs(data.get(r)-data.get(l));

            if(diff==B){
                if(data.get(r-1)!=data.get(r)){
                    // if(A.get(l)!=A.get(l+1)){
                    count++;
                    // }
                }

            }
            if(diff<=B){
                r++;
            }else{
                l++;
            }
        }

        // if(l<length-1){
        //     if(A.get(l)==A.get(l+1)){
        //         count++;
        //         l++;
        //     }else{
        //         return count;
        //     }
        // }

        return count;
    }
}
