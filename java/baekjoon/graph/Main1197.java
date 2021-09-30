package baekjoon.graph;

import java.util.*;

public class Main1197 {
    static class Data implements Comparable<Data> {
        int no;
        int cost;

        Data(int no, int cost) {
            this.no = no;
            this.cost = cost;
        }

        @Override
        public int compareTo(Data o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Data>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            adj[a].add(new Data(b, c));
            adj[b].add(new Data(a, c));
        }
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<Data> q = new PriorityQueue<>();
        q.add(new Data(1, 0));
        long ans = 0;
        while (!q.isEmpty()) {
            Data x = q.poll();
            if (visited[x.no])
                continue;
            visited[x.no] = true;
            ans += x.cost;
            n--;
            if (n == 0) {
                System.out.println(ans);
                break;
            }
            for (int i = 0; i < adj[x.no].size(); i++) {
                Data nx = adj[x.no].get(i);
                if (!visited[nx.no]) {
                    q.add(new Data(nx.no, nx.cost));
                }
            }
        }
    }
}
