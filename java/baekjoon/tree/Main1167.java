package baekjoon.tree;

import java.util.*;

public class Main1167 {
    static class Node {
        int no, weight;

        Node(int no, int weight) {
            this.no = no;
            this.weight = weight;
        }
    }

    static int n, m, ans;
    static ArrayList<Node>[] adj;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        adj = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 1; i < n + 1; i++) {
            int a = sc.nextInt();
            while (true) {
                int b = sc.nextInt();
                if (b == -1)
                    break;
                int c = sc.nextInt();
                adj[a].add(new Node(b, c));
            }
        }

        visited = new boolean[n + 1];
        dfs(1, 0);
        visited = new boolean[n + 1];
        dfs(m, 0);
        System.out.println(ans);
    }

    public static void dfs(int cur, int num) {
        if (num > ans) {
            ans = num;
            m = cur;
        }
        visited[cur] = true;
        for (Node next : adj[cur]) {
            if (!visited[next.no]) {
                dfs(next.no, next.weight + num);
                visited[next.no] = true;
            }
        }
    }
}