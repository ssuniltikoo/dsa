package dev.dsa.java.advance.graphs.MSTandDijkstra;

/*
* Flipkart has ‘A’ local distribution centers located across a large metropolitan city. Each distribution center needs to be interconnected through roads to facilitate efficient movement of goods. The cost of constructing a road between any two distribution centers is represented by the weight of the edge connecting them.

Given a graph with ‘A’ nodes representing the distribution centers and C weighted edges representing the possible roads between them, your task is to find the minimum total cost of constructing roads such that every distribution center can be reached from the first distribution center.

Cost Calculation:
The cost of constructing the roads is the sum of the weights of the edges selected for the construction.

*
*
*
*
* */




import java.util.ArrayList;
import java.util.PriorityQueue;

public class ConstructionCost {
    public static void main(String[] args) {

    }
}
class Edges{
    int node;
    int wt;

    public Edges(int node, int wt){
        this.node = node;
        this.wt = wt;
    }
    public Edges(){}
}

class Construction {
    public int Cost(int A, ArrayList<ArrayList<Integer>> B) {
        final  int MOD = 1000000007 ;

        // in this problem we have to find cost of construction rodes between nodes, so here we will use MST
        // prism algo

        // Declare visited array to know which array is selected
        boolean[] visited = new boolean[A];

        ArrayList<ArrayList<Edges>>  graph = new ArrayList<>();
        for(int i = 0; i < A; i++){
            ArrayList<Edges> edges = new ArrayList<>();
            graph.add(edges);
        }

        int size = B.size();

        if(size<1)
            return 0;

        for(int i = 0; i < B.size(); i++){
            int nodeNumber = B.get(i).get(0)-1;
            int vertex = B.get(i).get(1)-1;
            int wt = B.get(i).get(2);

            graph.get(nodeNumber).add(new Edges(vertex,wt));

            graph.get(vertex).add(new Edges(nodeNumber,wt));

        }

        PriorityQueue<Edges> heap = new PriorityQueue<>((a,b)->a.wt - b.wt);
        visited[0] = true;
        for (Edges edge : graph.get(0)) {
            heap.add(edge);
        }

        int cost =0;

        while(!heap.isEmpty()){
            Edges e = heap.remove();

            if(visited[e.node ]){
                continue;
            }else {
                visited[e.node] = true;
                cost = (cost%MOD + e.wt%MOD) % MOD;
                ArrayList<Edges> nodes = graph.get(e.node);
                for (Edges edge : nodes) {
                    heap.add(edge);
                }
            }

        }

        return cost;
    }
}
