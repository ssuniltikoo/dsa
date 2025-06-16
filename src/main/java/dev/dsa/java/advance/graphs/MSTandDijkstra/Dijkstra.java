package dev.dsa.java.advance.graphs.MSTandDijkstra;

/*
    Given a weighted undirected graph having A nodes and M weighted edges, and a source node C.
You have to find an integer array D of size A such that:
D[i]: Shortest distance from the C node to node i.
If node i is not reachable from C then -1.
Note:

There are no self-loops in the graph.
There are no multiple edges between two pairs of vertices.
The graph may or may not be connected.
Nodes are numbered from 0 to A-1.
Your solution will run on multiple test cases. If you are using global variables, make sure to clear them.
 */

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstra {
    public static void main(String[] args) {

    }
}



class Pair{
    int distance;
    int node;

    public Pair(int node, int distance) {
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

class DJ{

    public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B, int C) {
        ArrayList<Integer> dist = new ArrayList<>();
        boolean[] visited = new boolean[A];
        for(int i =0 ; i < A; i++){
            dist.add(-1);
            visited[i] = false;
        }

        // create adajency matric
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();

        for(int i = 0; i < A; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i =0 ; i < B.size() ; i++){
            int node = B.get(i).get(0);
            int edge = B.get(i).get(1);
            int wt = B.get(i).get(2);
            graph.get(node).add(new Pair(edge, wt));
            // as it is undirected -- add edge to node
            graph.get(edge).add(new Pair(node, wt));
        }

        PriorityQueue<Pair> heapify = new PriorityQueue<>((a,b)->a.getDistance()-b.getDistance());

        // pick source
        heapify.add(new Pair(C, 0)); // distance and node

        while(!heapify.isEmpty()){

            Pair ed = heapify.remove();

            int distance = ed.getDistance();
            int node = ed.getNode();
            if(dist.get(node) != -1)
                continue;

            dist.set(node, distance);
            for(Pair p : graph.get(node)){
                int d = p.getDistance();
                int n = p.getNode();
                if(dist.get(n)==-1)
                    heapify.add(new Pair(n,d+distance));
            }


        }
        return dist;
    }
}

