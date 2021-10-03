package baekjoon.graph;

import java.util.*;

public class Main1504 {
    static int n, e;
    static ArrayList<int[]>[] adj;
    static int INF = 200000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        e = sc.nextInt();
        adj = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            adj[a].add(new int[] { b, c });
            adj[b].add(new int[] { a, c });
        }
        int v1 = sc.nextInt();
        int v2 = sc.nextInt();

        int[] ans1 = dijkstra(1);
        int[] ans2 = dijkstra(v1);
        int[] ans3 = dijkstra(v2);
        long ans = Math.min(ans1[v1] + ans2[v2] + ans3[n], ans1[v2] + ans3[v1] + ans2[n]);
        System.out.println(ans < INF ? ans : -1);
    }

    public static int[] dijkstra(int start) {
        int[] cost = new int[n + 1];
        Arrays.fill(cost, INF);
        cost[start] = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });
        q.add(new int[] { start, 0 });

        while (!q.isEmpty()) {
            int[] x = q.poll();
            if (cost[x[0]] < x[1])
                continue;
            for (int[] nx : adj[x[0]]) {
                if (cost[nx[0]] > x[1] + nx[1]) {
                    cost[nx[0]] = x[1] + nx[1];
                    q.add(new int[] { nx[0], cost[nx[0]] });
                }
            }
        }
        return cost;
    }
}