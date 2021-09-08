package baekjoon;

import java.util.*;
import java.io.*;

public class Main1766 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] cnt = new int[n + 1];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n + 1; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj.get(a).add(b);
            cnt[b]++;
        }
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 1; i < n + 1; i++) {
            if (cnt[i] == 0) {
                q.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int x = q.poll();
            sb.append(x + " ");

            for (int i = 0; i < adj.get(x).size(); i++) {
                int nx = adj.get(x).get(i);
                cnt[nx]--;
                if (cnt[nx] == 0) {
                    q.add(nx);
                }
            }
        }
        System.out.println(sb);
    }
}
