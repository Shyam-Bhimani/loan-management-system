package com.loan.week7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphTraversal {
    private int vertices;
    private List<List<Integer>> adjList;

    public GraphTraversal(int vertices){
        this.vertices=vertices;
        adjList=new ArrayList<>(vertices);
        for(int i=0;i<vertices;i++){
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source,int destination){
        adjList.get(source).add(destination);
    }

    public void printGraph(){
        for(int i=0;i<vertices;i++){
            System.out.println("Vertex "+i+" is connected to: ");
            System.out.println(adjList.get(i));
        }
    }

    public void dfs(int startVertex){
        boolean[]visited = new boolean[vertices];
        System.out.println("DFS Traversal starting from vertex : "+startVertex+": ");
        dfsHelper(startVertex,visited);
        System.out.println();
    }

    private void dfsHelper(int vertex,boolean[]visited){
        visited[vertex]=true;
        System.out.println(vertex + " ");
        for(int neighbor:adjList.get(vertex)){
            if(!visited[neighbor]){
                dfsHelper(neighbor,visited);
            }
        }
    }

    public void bfs(int startVertex){
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[startVertex]=true;
        queue.add(startVertex);

        System.out.println("BFS Traversal starting from vertex "+ startVertex+": ");

        while(!queue.isEmpty()){
            int current = queue.poll();
            System.out.println(current+" ");

            for(int neighbor:adjList.get(current)){
                if(!visited[neighbor]){
                    visited[neighbor]=true;
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        GraphTraversal graph=new GraphTraversal(6);

        graph.addEdge(0,1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);

        graph.printGraph();

        System.out.println("########### DFS #############");
        graph.dfs(0);

        System.out.println("########### BFS #############");
        graph.bfs(0);
    }
}
