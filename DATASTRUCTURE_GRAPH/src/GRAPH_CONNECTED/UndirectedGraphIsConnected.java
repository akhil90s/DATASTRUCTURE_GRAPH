package GRAPH_CONNECTED;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class UndirectedGraphIsConnected {

    public static void main(String[] args) {
        
        UndirectedGraphIsConnectedVerify isConnected = new UndirectedGraphIsConnectedVerify(7);
        
        isConnected.addEdge(0, 1);
        isConnected.addEdge(0, 2);
        isConnected.addEdge(1, 3);
        isConnected.addEdge(2, 4);
        isConnected.addEdge(3, 5);
        isConnected.addEdge(4, 5);
        isConnected.addEdge(4, 6);

        
        boolean result = isConnected.isConnected();
        System.out.println(result);

    }

}

class UndirectedGraphIsConnectedVerify {

    boolean[] visited;
    private List<List<Integer>> graph;

    UndirectedGraphIsConnectedVerify(int nodes) {

        visited = new boolean[nodes];
        graph = new ArrayList<>();

        for (int i = 0; i < nodes; i++) {
            graph.add(i, new ArrayList<>());
        }

    }

    public boolean isConnected() {
        
        dfs(0);

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    public void addEdge(int a, int b) {

        graph.get(a).add(b);
        graph.get(b).add(a);

    }
    
    

    public void dfs(int start) {

        Stack<Integer> stack = new Stack<>();
        stack.add(start);
        visited[start] = true;

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
