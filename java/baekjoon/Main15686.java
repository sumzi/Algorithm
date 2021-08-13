package baekjoon;

import java.util.*;
import java.io.*;

public class Main15686 {
    static List<int[]> h = new ArrayList<>();
    static List<int[]> c = new ArrayList<>();
    static boolean[] selected;
    static int n, m, ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 1) {
                    h.add(new int[] { i, j });
                } else if (tmp == 2) {
                    c.add(new int[] { i, j });
                }
            }
        }
        selected = new boolean[c.size()];
        comb(0, 0);
        System.out.println(ans);
    }

    public static void comb(int idx, int cnt) {
        if (idx == c.size()) {
            if (cnt == m) {
                int sum = 0;
                for (int[] x : h) {
                    int num = Integer.MAX_VALUE;
                    for (int i = 0; i < c.size(); i++) {
                        if (selected[i]) {
                            int y[] = c.get(i);
                            num = Math.min(num, Math.abs(x[0] - y[0]) + Math.abs(x[1] - y[1]));
                        }
                    }
                    sum += num;
                }
                ans = Math.min(ans, sum);
            }
            return;
        }
        comb(idx + 1, cnt);
        selected[idx] = true;
        comb(idx + 1, cnt + 1);
        selected[idx] = false;
    }
}