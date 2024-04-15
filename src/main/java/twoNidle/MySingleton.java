//package twoNidle;
//
///**
// * @Author lihongxing
// * @Date 2023/10/17 15:21
// */
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class _3_9_10 {
//
//    public static void main(String[] args) {
//        int[][] references = {{1, 2}, {2, 3}, {3, 1}, {4, 5}};
//
//        Map<Integer, List<Integer>> graph = buildGraph(references);
//        List<List<Integer>> circularReferences = findCircularReferences(graph);
//
//        System.out.println("Circular References: " + circularReferences);
//    }
//
//    // 构建图
//    private static Map<Integer, List<Integer>> buildGraph(int[][] references) {
//        Map<Integer, List<Integer>> graph = new HashMap<>();
//
//        for (int[] reference : references) {
//            int from = reference[0];
//            int to = reference[1];
//
//            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
//        }
//
//        return graph;
//    }
//
//    // 查找循环引用
//    private static List<List<Integer>> findCircularReferences(Map<Integer, List<Integer>> graph) {
//        List<List<Integer>> result = new ArrayList<>();
//        Map<Integer, Boolean> visited = new HashMap<>();
//
//        for (int node : graph.keySet()) {
//            if (!visited.containsKey(node)) {
//                List<Integer> path = new ArrayList<>();
//                if (hasCycle(graph, node, visited, path)) {
//                    result.add(path);
//                }
//            }
//        }
//
//        return result;
//    }
//
//    private static boolean hasCycle(Map<Integer, List<Integer>> graph, int node, Map<Integer, Boolean> visited, List<Integer> path) {
//        visited.put(node, true);
//        path.add(node);
//
//        if (graph.containsKey(node)) {
//            for (int neighbor : graph.get(node)) {
//                if (!visited.containsKey(neighbor)) {
//                    if (hasCycle(graph, neighbor, visited, path)) {
//                        return true;
//                    }
//                } else if (path.contains(neighbor)) {
//                    // 找到循环引用
//                    int startIndex = path.indexOf(neighbor);
//                    List<Integer> cycle = new ArrayList<>(path.subList(startIndex, path.size()));
//                    return true;
//                }
//            }
//        }
//
//        path.remove(path.size() - 1);
//        return false;
//    }
//}
//
