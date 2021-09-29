package baekjoon.graph;

import java.util.*;
import java.io.*;

public class Main1516 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] cnt = new int[n + 1];
        int[] time = new int[n + 1];
        int[] ans = new int[n + 1];
        ArrayList<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int a = 1; a <= n; a++) {
            st = new StringTokenizer(br.readLine());
            time[a] = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                int b = Integer.parseInt(st.nextToken());
                if (b > 0) {
                    adj[b].add(a);
                    cnt[a]++;
                }
            }
        }
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (cnt[i] == 0) {
                ans[i] = time[i];
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int x = q.poll();
            for (int i = 0; i < adj[x].size(); i++) {
                int nx = adj[x].get(i);
                ans[nx] = Math.max(ans[nx], ans[x] + time[nx]);
                if (--cnt[nx] == 0) {
                    q.add(nx);
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.println(ans[i]);
        }
    }
}
