package baekjoon.graph;

import java.util.*;

public class Main11779 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int INF = Integer.MAX_VALUE;

        int[] cost = new int[n + 1];
        int[] visited = new int[n + 1];
        Arrays.fill(cost, INF);
        ArrayList<int[]>[] adj = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            adj[a].add(new int[] { b, c });
        }

        int s = sc.nextInt();
        int e = sc.nextInt();

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });
        q.add(new int[] { s, 0 });
        cost[s] = 0;
        while (!q.isEmpty()) {
            int[] x = q.poll();
            if (cost[x[0]] < x[1])
                continue;
            for (int[] nx : adj[x[0]]) {
                if (cost[nx[0]] > cost[x[0]] + nx[1]) {
                    cost[nx[0]] = cost[x[0]] + nx[1];
                    visited[nx[0]] = x[0];
                    q.add(new int[] { nx[0], cost[nx[0]] });
                }
            }
        }
        Stack<Integer> ans = new Stack<>();
        int idx = e;
        while (idx != 0) {
            ans.add(idx);
            idx = visited[idx];
        }

        System.out.println(cost[e]);
        System.out.println(ans.size());
        while (!ans.isEmpty())
            System.out.print(ans.pop() + " ");
    }
}
