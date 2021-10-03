package baekjoon.graph;

import java.util.*;

public class Main1753 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int INF = Integer.MAX_VALUE;
        int v = sc.nextInt();
        int e = sc.nextInt();
        int start = sc.nextInt();
        int[] cost = new int[v + 1];
        Arrays.fill(cost, INF);
        cost[start] = 0;
        ArrayList<int[]>[] adj = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            adj[a].add(new int[] { b, c });
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });
        q.add(new int[] { start, 0 });
        while (!q.isEmpty()) {
            int[] x = q.poll();
            if (cost[x[0]] < x[1])
                continue;
            for (int[] nx : adj[x[0]]) {
                if (cost[nx[0]] > cost[x[0]] + nx[1]) {
                    cost[nx[0]] = cost[x[0]] + nx[1];
                    q.add(new int[] { nx[0], cost[nx[0]] });
                }
            }
        }
        for (int i = 1; i < v + 1; i++) {
            System.out.println(cost[i] == INF ? "INF" : cost[i]);
        }
    }
}
