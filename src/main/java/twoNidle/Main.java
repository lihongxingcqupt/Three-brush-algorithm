import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        // 构建树的邻接表表示
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        // 使用队列进行BFS
        Queue<Integer> queue = new LinkedList<>();
        int[] colors = new int[n + 1];

        // 根节点从1号开始，初始化为红色
        queue.add(1);
        colors[1] = 1;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            // 遍历该节点的邻居节点
            for (int neighbor : tree.get(node)) {
                if (colors[neighbor] != 0) {
                    continue;
                }

                // 找到一个可用的颜色
                for (int color = 1; color <= 3; color++) {
                    if (colors[node] != color && colors[parent(node, tree)] != color) {
                        colors[neighbor] = color;
                        queue.add(neighbor);
                        break;
                    }
                }
            }
        }

        // 输出染色结果
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            char colorChar = getColorChar(colors[i]);
            result.append(colorChar);
        }

        System.out.println(result.toString());
    }

    private static int parent(int node, List<List<Integer>> tree) {
        for (int neighbor : tree.get(node)) {
            return neighbor;
        }
        return -1;
    }

    private static char getColorChar(int color) {
        return (color == 1) ? 'R' : (color == 2) ? 'G' : 'B';
    }
}
