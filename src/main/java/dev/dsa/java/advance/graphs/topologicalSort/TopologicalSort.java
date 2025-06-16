package dev.dsa.java.advance.graphs.topologicalSort;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopologicalSort {
    public static void main(String[] args) {

    }
}

class Solution {
    public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {
        // first set in-degree of each node to 0

        ArrayList<Integer> indegreeOfNodes = new ArrayList<>();

        ArrayList<Integer> output = new ArrayList<>();

        ArrayList<ArrayList<Integer>> ngbs = new ArrayList<>();

        for(int i =0; i <= A; i++){
            indegreeOfNodes.add(0);
            ngbs.add(new ArrayList<>());
        }

        int totalEdges = B.size();

        for (ArrayList<Integer> integers : B) {

            // for(int j=0; j<1;j++){
            int connectedNode = integers.get(1);
            int neighbour =    integers.get(0);
            ArrayList<Integer> arr = ngbs.get(neighbour);
            arr.add(connectedNode);
            ngbs.set(neighbour, arr);
            indegreeOfNodes.set(connectedNode, indegreeOfNodes.get(connectedNode) + 1);
            //}
        }

        Queue<Integer>  nodes = new PriorityQueue<>();

        for(int i=1; i <= A ; i++){
            if(indegreeOfNodes.get(i) == 0){
                nodes.add(i);
            }
        }

        while(!nodes.isEmpty()){
           int x =  nodes.remove();
           if(x!=0) {
               output.add(x);
               ArrayList<Integer> neighbours = ngbs.get(x);
               for (Integer neighbour : neighbours) {
                   indegreeOfNodes.set(neighbour, indegreeOfNodes.get(neighbour) - 1);
                   if (indegreeOfNodes.get(neighbour) == 0) {
                       nodes.add(neighbour);
                   }
               }
           }


        }

        return output;

    }
}
