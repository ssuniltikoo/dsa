package dev.dsa.java.advance.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class FootBall {
    public static void main(String[] args) {
        FootBallPasses passes = new FootBallPasses();
       // List<Integer> d = Arrays.asList(13,0,26,38,0,49,21,0,25,0);
        ArrayList<Integer> data = new ArrayList<>(Arrays.asList(13, 0, 26, 38, 0, 49, 21, 0, 25, 0));
        passes.solve(10,43,data);
    }
}


class FootBallPasses {
    public int solve(int A, int B, ArrayList<Integer> C) {

        Stack<Integer> passes = new Stack<>();
        passes.push(B);
        for(int i = 0; i < C.size(); i++){
            if(C.get(i).equals(0)){
                passes.pop();

            }else
                passes.push(C.get(i));
        }
        return passes.pop();
    }
}

