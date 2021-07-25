package GRAPH_TRAVERSAL;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AdjacencyListBFS {

    public static void main(String[] args) {
        GraphBFSTraversalAdjacencyList bfs = new GraphBFSTraversalAdjacencyList(8);
        
        bfs.addEdge(0, 1);
        bfs.addEdge(0, 2);
        bfs.addEdge(0, 3);
        bfs.addEdge(1, 4);
        bfs.addEdge(2, 4);
        bfs.addEdge(2, 5);
        bfs.addEdge(5, 6);
        bfs.addEdge(5, 7);
        
        bfs.bfsTraversal(0);
        
    }

}

class GraphBFSTraversalAdjacencyList {

    private boolean[] visited;
    private List<List<Integer>> graph;

    GraphBFSTraversalAdjacencyList(int nodes) {

        visited = new boolean[nodes];
        graph = new ArrayList<>();

        for (int i = 0; i < nodes; i++) {
            graph.add(i, new ArrayList<Integer>());
        }
    }

    public void addEdge(int a, int b) {

        graph.get(a).add(b);
        graph.get(b).add(a);
    }

    public void bfsTraversal(int start) {

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {

            Integer nodeValue = queue.poll();
            System.out.print(nodeValue + " ");

            List<Integer> neighbours = graph.get(nodeValue);

            for (int neighbour : neighbours) {

                if (!visited[neighbour]) {
                    queue.offer(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
    }

}
