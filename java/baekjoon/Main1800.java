package baekjoon;

import java.io.*;
import java.util.*;

public class Main1800 {
    static int n, p, k;
    static boolean[][] visited;
    static ArrayList<Node>[] adj;

    static class Node {
        int no;
        int price;

        Node(int no, int price) {
            this.no = no;
            this.price = price;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        adj = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[a].add(new Node(b, c));
            adj[b].add(new Node(a, c));
        }
        int ans = Integer.MAX_VALUE;
        int l = 0;
        int r = 1000000;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (check(mid)) {
                ans = Math.min(ans, mid);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    public static boolean check(int x) {
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[n + 1][k + 1];
        q.add(new int[] { 1, k });
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int cur = tmp[0];
            int cnt = tmp[1];
            if (cur == n) {
                return true;
            }
            for (Node next : adj[cur]) {
                if (next.price <= x) {
                    if (!visited[next.no][cnt]) {
                        visited[next.no][cnt] = true;
                        q.add(new int[] { next.no, cnt });
                    }
                } else {
                    if (cnt > 0 && !visited[next.no][cnt - 1]) {
                        visited[next.no][cnt - 1] = true;
                        q.add(new int[] { next.no, cnt - 1 });
                    }
                }
            }

        }

        return false;
    }
}
