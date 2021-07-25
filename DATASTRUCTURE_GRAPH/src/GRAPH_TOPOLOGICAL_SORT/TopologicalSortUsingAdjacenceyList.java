package GRAPH_TOPOLOGICAL_SORT;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TopologicalSortUsingAdjacenceyList {

    public static void main(String[] args) {

        TopologicalSortAdjacenceyList a = new TopologicalSortAdjacenceyList(6);

        a.addEdge(0, 1);
        a.addEdge(0, 2);
        a.addEdge(1, 3);
        a.addEdge(1, 4);
        a.addEdge(2, 4);
        a.addEdge(3, 5);
        a.addEdge(4, 5);

        System.out.println(a.topologicalSort());

    }

}

class TopologicalSortAdjacenceyList {

    private List<List<Integer>> graph;
    private Map<Integer, Integer> incomingDegree;
    private Queue<Integer> queue;

    TopologicalSortAdjacenceyList(int nodes) {

        graph = new ArrayList<>();
        incomingDegree = new HashMap<>();
        queue = new LinkedList<>();

        for (int i = 0; i < nodes; i++) {
            graph.add(i, new ArrayList<Integer>());
            incomingDegree.put(i, 0);
        }
    }

    public void addEdge(int a, int b) {

        graph.get(a).add(b);
        incomingDegree.put(b, incomingDegree.get(b) + 1);

    }

    public List<Integer> topologicalSort() {

        for (Map.Entry<Integer, Integer> entry : incomingDegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {

            Integer node = queue.poll();
            result.add(node);

            List<Integer> childrenList = graph.get(node);

            for (int child : childrenList) {
                incomingDegree.put(child, incomingDegree.get(child) - 1);

                if (incomingDegree.get(child) == 0) {
                    queue.add(child);

                }
            }
        }

        if (result.size() != graph.size()) {
            System.out.println("Cycle in graph");
            return new ArrayList<>();
        }

        return result;
    }

}