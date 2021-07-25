package GRAPH_SOURCE_TO_DESTINATION;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DirectedGraphSourceToDestination {

    public static void main(String[] args) {

        SourceToDestinationDirectedGraph sourceToDestination = new SourceToDestinationDirectedGraph(7);

        sourceToDestination.addEdge(0, 1);
        sourceToDestination.addEdge(1, 2);
        sourceToDestination.addEdge(2, 0);
        
        sourceToDestination.addEdge(3, 2);
        sourceToDestination.addEdge(2, 4);
       
        
        boolean result = sourceToDestination.sourceToDestination(0, 2);
        // boolean result = sourceToDestination.sourceToDestination(0, 3);
        System.out.println(result);
    }

}

class SourceToDestinationDirectedGraph {

    private boolean[] visited;

    private List<List<Integer>> graph;

    SourceToDestinationDirectedGraph(int nodes) {

        visited = new boolean[nodes];
        graph = new ArrayList<>();

        for (int i = 0; i < nodes; i++) {
            graph.add(i, new ArrayList<Integer>());
        }

    }

    public void addEdge(int a, int b) {

        graph.get(a).add(b);

    }

    public boolean sourceToDestination(int source, int destination) {

        dfs(source);

        return visited[destination];
    }

    private void dfs(int source) {

        Stack<Integer> stack = new Stack<>();
        stack.add(source);
        visited[source] = true;

        while (!stack.isEmpty()) {

            Integer node = stack.pop();
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