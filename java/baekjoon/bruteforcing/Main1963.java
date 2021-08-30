package baekjoon.bruteforcing;

import java.util.*;
import java.io.*;

public class Main1963 {
    static boolean[] check = new boolean[10000];
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 2; i < 10000; i++) {
            for (int j = i + i; j < 10000; j += i) {
                check[j] = true;
            }
        }

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            visited = new boolean[10000];
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[] { a, 0 });
            visited[a] = true;
            int ans = -1;
            while (!q.isEmpty()) {
                int[] x = q.poll();
                int cur = x[0];
                int cnt = x[1];
                if (cur == b) {
                    ans = cnt;
                    break;
                }
                for (int j = 0; j < 4; j++) {
                    for (int k = 0; k < 10; k++) {
                        if (j == 0 && k == 0)
                            continue;
                        int tmp = change(cur, j, k);
                        if (!check[tmp] && !visited[tmp]) {
                            visited[tmp] = true;
                            q.add(new int[] { tmp, cnt + 1 });
                        }
                    }
                }
            }
            System.out.println(ans == -1 ? "Impossible" : ans);
        }
    }

    public static int change(int num, int i, int j) {
        StringBuilder sb = new StringBuilder(String.valueOf(num));
        sb.setCharAt(i, (char) (j + '0'));
        return Integer.parseInt(sb.toString());
    }
}