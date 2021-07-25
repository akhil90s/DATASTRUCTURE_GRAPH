package GRAPH_PROBLEMS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class All_Paths_From_Source_To_Target {

    public static void main(String[] args) {
        
        int[][] array = new int[][] {{1,2},{3},{1,3},{}};
        List<List<Integer>> result = allPathsSourceTarget(array);
        System.out.println(result);
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> result = new ArrayList<>();

        Queue<List<Integer>> queue = new LinkedList<>();

        queue.offer(Arrays.asList(0));
        int goalNode = graph.length - 1;

        while (!queue.isEmpty()) {
            List<Integer> path = queue.poll();
            int lastNode = path.get(path.size() - 1);

            if (lastNode == goalNode) {
                result.add(path);
            } else {
                int[] neighbours = graph[lastNode];

                for (int neighbour : neighbours) {
                    List<Integer> list = new ArrayList<>(path);
                    list.add(neighbour);
                    queue.offer(list);
                    
                }
            }
        }

        return result;
    }

}
