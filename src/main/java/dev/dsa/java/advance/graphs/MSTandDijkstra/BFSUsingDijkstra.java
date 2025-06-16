package dev.dsa.java.advance.graphs.MSTandDijkstra;

/*
    Given a weighted undirected graph having A nodes, a source node C and destination node D.

Find the shortest distance from C to D and if it is impossible to reach node D from C then return -1.

You are expected to do it in Time Complexity of O(A + M).

Note:

There are no self-loops in the graph.

No multiple edges between two pair of vertices.

The graph may or may not be connected.

Nodes are Numbered from 0 to A-1.

Your solution will run on multiple testcases. If you are using global variables make sure to clear them.

 */

import java.util.ArrayList;

public class BFSUsingDijkstra {
    public static void main(String[] args) {

    }
}


class Paair{
    int distance;
    int node;

    public Paair(int node, int distance) {
        this.node = node;
        this.distance = distance;


    }

    public int getDistance() {
        return distance;
    }

    public int getNode() {
        return node;
    }
}


class Test{
    public int findShortestPath(int A, ArrayList<ArrayList<Integer>> B, int C, int D) {
        int distance =-1;




        return distance;
    }
}
