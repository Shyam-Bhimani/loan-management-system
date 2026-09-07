package com.loan.week7;

import java.util.ArrayList;
import java.util.List;

public class GraphBasics {
    public static void main(String[] args) {
        int vertices = 4;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<vertices;i++){
            graph.add(new ArrayList<>());
        }

        addEdge(graph,0,1);
        addEdge(graph,0,2);
        addEdge(graph,1,3);
        addEdge(graph,2,3);

        printGraph(graph);
    }

    public static void addEdge(List<List<Integer>> graph, int u , int v){
        graph.get(u).add(v);
        graph.get(v).add(u);

    }

    public static void printGraph(List<List<Integer>> graph){
        for(int i=0;i<graph.size();i++){
            System.out.print("Vertex "+i+": ");
            //System.out.println(graph.get(i));
            System.out.println(i +"->"+graph.get(i));
        }
    }
}
