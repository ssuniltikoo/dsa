package dev.dsa.java.advance.graphs.MSTandDijkstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class CommutableIslands {
    public static void main(String[] args) {

    }
}

class IslandEdges {
    int node;
    int weight;
    public IslandEdges(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    public int getNode(){
        return node;
    }

    public int getWeight(){
        return weight;
    }


}

class Islands{

    public int findPAth(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<ArrayList<IslandEdges>> graph = new ArrayList<>();
        for (int i = 0; i <= A; i++) {
            graph.add(new ArrayList<IslandEdges>());
        }
        for(int i =0 ; i < B.size(); i++){
            int node = B.get(i).get(0) ;
            int edge = B.get(i).get(1) ;
            int wt = B.get(i).get(2);

            // add edge connected to node
            ArrayList<IslandEdges> arrlist = graph.get(node);
            arrlist.add(new IslandEdges(edge, wt));
            graph.set(node, arrlist);

            // as this is undirected - add node connected to edge

            ArrayList<IslandEdges> edgelist = graph.get(edge);
            edgelist.add(new IslandEdges(node, wt));
            graph.set(edge, edgelist);

        }

        boolean[] visited = new boolean[A+1];

        PriorityQueue<IslandEdges> heap = new PriorityQueue<>((a,b)->a.getWeight()-b.getWeight());

        // select any node e.g select node 1st

        ArrayList<IslandEdges> firstNodeEdges = graph.get(1);
        for(IslandEdges edge : firstNodeEdges){
            heap.add(edge);
        }
        visited[1] = true;
        int toatlCost =0;
        while(!heap.isEmpty()){
            IslandEdges edge = heap.remove();
            int node = edge.getNode();
            int weight = edge.getWeight();
            if(visited[node]){
                continue;
            }else{
                toatlCost += weight;
                visited[node] = true;
                ArrayList<IslandEdges> arrEges= graph.get(node);
                for(IslandEdges edge1 : arrEges){
                    heap.add(edge1);
                }
            }
        }

        return toatlCost;
    }
}
