package swea;

import java.util.*;
import java.io.*;

public class Solution3124 {
    static class Node implements Comparable<Node> {
        int no;
        int weight;

        Node(int no, int weight) {
            this.no = no;
            this.weight = weight;
        }

        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayList<Node>[] adj;
        boolean[] visited;
        PriorityQueue<Node> q;

        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            visited = new boolean[n + 1];
            adj = new ArrayList[n + 1];
            for (int j = 1; j <= n; j++) {
                adj[j] = new ArrayList<>();
            }
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                adj[a].add(new Node(b, c));
                adj[b].add(new Node(a, c));
            }
            q = new PriorityQueue<>();
            q.add(new Node(1, 0));
            long ans = 0;
            while (!q.isEmpty()) {
                Node cur = q.poll();
                if (visited[cur.no])
                    continue;
                visited[cur.no] = true;
                ans += cur.weight;
                if (--n == 0)
                    break;
                visited[cur.no] = true;
                for (Node next : adj[cur.no]) {
                    if (!visited[next.no])
                        q.add(next);
                }
            }
            System.out.println("#" + i + " " + ans);
        }
    }
}
