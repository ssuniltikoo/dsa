package dev.dsa.java.advance.graphs.possibilityOfFinishing;

import java.util.ArrayList;
import java.util.Arrays;

/*
* There are a total of A courses you have to take, labeled from 1 to A.

Some courses may have prerequisites, for example to take course 2 you have to first take course 1, which is expressed as a pair: [1,2].

So you are given two integer array B and C of same size where for each i (B[i], C[i]) denotes a pair.

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Return 1 if it is possible to finish all the courses, or 0 if it is not possible to finish all the courses.

Problem Constraints

1 <= A <= 6*104

1 <= length(B) = length(C) <= 105

1 <= B[i], C[i] <= A

Input Format

The first argument of input contains an integer A, representing the number of courses.

The second argument of input contains an integer array, B.

The third argument of input contains an integer array, C.

Output Format

Return 1 if it is possible to finish all the courses, or 0 if it is not possible to finish all the courses.
*
*
* */
public class Finish {
    public static void main(String[] args) {

    }

}

// 1->2 -> 3 ->4
//
// dfs depth search use to find whetehr there is cycle in graph or not
class Solution {
    public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
                boolean[] visited = new boolean[A];
                boolean[] path = new boolean[A];
        boolean flag=false;
        Arrays.fill(visited, false);
        Arrays.fill(path, false);

        ArrayList<ArrayList<Integer>> adjArr = new ArrayList<>();

        for (int i = 0; i < A; i++) {
            adjArr.add(new ArrayList<>());
        }

        for(int j=0; j < B.size(); j++) {
            int node = B.get(j)-1;
            int ngb = C.get(j) -1;
            ArrayList<Integer> arr = adjArr.get(node);
            arr.add(ngb);
            adjArr.set(node,arr);
        }


        for(int i = 0; i < A; i++) {
            if(!visited[i]) {
              if(dfs(adjArr,i,visited,path) == true){
                  flag=true;
                  break;
              }
            }
        }

        return flag==true?0:1;
    }

    boolean dfs(ArrayList<ArrayList<Integer>> graph, int currentNode, boolean[] visited, boolean[] path) {
            visited[currentNode] = true;
            path[currentNode] = true;

            ArrayList<Integer> ngbs = graph.get(currentNode);
            for(Integer ngb : ngbs) {
                int nb = ngb-1;
                if(path[nb]) {
                    return true;
                }

                if(!visited[nb] && dfs(graph,nb,visited,path)  ) {
                    return true;
                }

            }
            path[currentNode] = false;
            return false;

    }
}

