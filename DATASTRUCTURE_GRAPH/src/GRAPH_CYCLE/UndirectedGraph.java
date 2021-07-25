package GRAPH_CYCLE;

import java.util.ArrayList;
import java.util.List;

public class UndirectedGraph {

    public static void main(String[] args) {
        
        UndirectedGraphCycle a = new UndirectedGraphCycle(3);
        
        a.addEdge(0, 1);
        a.addEdge(1, 2);
        a.addEdge(2, 0);
        
        boolean result = a.verifyUndirectedGraphHasCycle();
        System.out.println(result);

    }

}

class UndirectedGraphCycle {

    private boolean[] visited;
    private List<List<Integer>> graph;

    public UndirectedGraphCycle(int nodes) {

        graph = new ArrayList<>();
        visited = new boolean[nodes];

        for (int i = 0; i < nodes; i++) {
            graph.add(i, new ArrayList<>());
        }
    }

    public void addEdge(int a, int b) {

        graph.get(a).add(b);
        graph.get(b).add(a);

    }

    public boolean verifyUndirectedGraphHasCycle() {

        for (int i = 0; i < graph.size(); i++) {
            if (!visited[i]) {
                if (ifCycle(i, -1)) {
                    return true;
                }
            }
        }

        return false;

    }

    private boolean ifCycle(int index, int parent) {

        visited[index] = true;
        List<Integer> neighbourList = graph.get(index);

        for (Integer neighbour : neighbourList) {
            if (!visited[neighbour]) {
                ifCycle(neighbour, index);
            } else if (neighbour != parent) {
                return true;
            }
        }

        return false;

    }

}
