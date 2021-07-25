package GRAPH_MIN_DISTANCE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class UnweightedGraphMinimumDistance {

    public static void main(String[] args) {

        MinimumDistanceInUnweightedGraph a = new MinimumDistanceInUnweightedGraph(6);

        a.addEdge(0, 1);
        a.addEdge(0, 3);
        a.addEdge(1, 2);
        a.addEdge(3, 4);
        a.addEdge(2, 4);
        a.addEdge(4, 5);

        System.out.println(a.getMinimumDistanceBetweenNodes(0, 5));

    }
}

class MinimumDistanceInUnweightedGraph {

    private boolean[] visited;
    private List<List<Integer>> graph;

    MinimumDistanceInUnweightedGraph(int nodes) {

        visited = new boolean[nodes];
        graph = new ArrayList<>();

        for (int i = 0; i < nodes; i++) {
            graph.add(i, new ArrayList<>());
        }

    }

    public void addEdge(int a, int b) {

        graph.get(a).add(b);
        graph.get(b).add(a);

    }

    public int getMinimumDistanceBetweenNodes(int start, int target) {

        int minimumDistance = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        minimumDistance++;

        while (!queue.isEmpty()) {

            int queueSize = queue.size();

            for (int i = 0; i < queueSize; i++) {

                Integer node = queue.poll();
                List<Integer> childrenNodes = graph.get(node);

                for (Integer childNode : childrenNodes) {

                    if (childNode == target) {
                        return minimumDistance;
                    }

                    if (!visited[childNode]) {

                        queue.offer(childNode);
                        visited[childNode] = true;

                    }
                }
            }

            minimumDistance++;
        }
        return -1;
    }

}