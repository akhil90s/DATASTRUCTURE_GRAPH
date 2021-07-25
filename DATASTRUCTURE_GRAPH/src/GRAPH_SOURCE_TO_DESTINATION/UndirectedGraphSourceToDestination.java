package GRAPH_SOURCE_TO_DESTINATION;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class UndirectedGraphSourceToDestination {

    public static void main(String[] args) {

        SourceToDestinationUndirectedGraph sourceToDestination = new SourceToDestinationUndirectedGraph(7);

        sourceToDestination.addEdge(0, 1);
        sourceToDestination.addEdge(0, 2);
        sourceToDestination.addEdge(1, 3);

        // sourceToDestination.addEdge(3, 4);
        sourceToDestination.addEdge(4, 5);
        sourceToDestination.addEdge(4, 6);

        boolean result = sourceToDestination.sourceToDestination(0, 5);
        System.out.println(result);

    }

}

class SourceToDestinationUndirectedGraph {

    private boolean[] visited;

    private List<List<Integer>> graph;

    SourceToDestinationUndirectedGraph(int nodes) {

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