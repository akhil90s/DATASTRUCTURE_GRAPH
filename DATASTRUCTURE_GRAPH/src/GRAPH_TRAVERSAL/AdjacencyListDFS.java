package GRAPH_TRAVERSAL;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AdjacencyListDFS {

    public static void main(String[] args) {

        GraphDFSTraversalAdjacencyList dfs = new GraphDFSTraversalAdjacencyList(8);

        dfs.addEdge(0, 1);
        dfs.addEdge(0, 2);
        dfs.addEdge(0, 3);
        dfs.addEdge(1, 4);
        dfs.addEdge(2, 4);
        dfs.addEdge(2, 5);
        dfs.addEdge(5, 6);
        dfs.addEdge(5, 7);

        dfs.dfsTraversal(0);

    }

}

class GraphDFSTraversalAdjacencyList {

    private boolean[] visited;
    private List<List<Integer>> graph;

    GraphDFSTraversalAdjacencyList(int nodes) {

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

    public void dfsTraversal(int start) {

        Stack<Integer> stack = new Stack<Integer>();
        stack.add(start);
        visited[start] = true;

        while (!stack.isEmpty()) {

            Integer node = stack.pop();
            System.out.print(node + " ");
            List<Integer> neighbours = graph.get(node);

            for (int neighbour : neighbours) {

                if (!visited[neighbour]) {
                    stack.add(neighbour);
                    visited[neighbour] = true;
                }
            }
        }

    }

}
