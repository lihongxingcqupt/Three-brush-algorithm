package dp;

/**
 * @Author lihongxing
 * @Date 2023/8/26 15:07
 */
import java.util.*;

public class _2 {
    static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 节点数目
        int m = scanner.nextInt(); // 边的数目

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            graph.get(u - 1).add(new Edge(v, w)); // 添加边
            graph.get(v - 1).add(new Edge(u, w)); // 无向图需要添加双向边
        }

        int d = scanner.nextInt(); // 未联通的节点数目
        Set<Integer> disconnectedNodes = new HashSet<>();
        for (int i = 0; i < d; i++) {
            int u = scanner.nextInt() - 1;
            int v = scanner.nextInt() - 1;
            disconnectedNodes.add(u);
            disconnectedNodes.add(v);
        }

        int A = scanner.nextInt() - 1; // 起点 A
        int B = scanner.nextInt() - 1; // 终点 B

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[A] = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(node -> dist[node]));
        pq.offer(A);

        while (!pq.isEmpty()) {
            int curr = pq.poll();

            if (curr == B) {
                break; // 已经到达终点 B，可以结束循环
            }

            for (Edge edge : graph.get(curr)) {
                int next = edge.to;
                int weight = edge.weight;

                if (disconnectedNodes.contains(next)) {
                    continue; // 忽略与未联通节点的边
                }

                if (dist[curr] + weight < dist[next]) {
                    dist[next] = dist[curr] + weight;
                    pq.offer(next);
                }
            }
        }

        System.out.println(dist[B]);
    }
}

