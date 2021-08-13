package baekjoon;

import java.util.*;
import java.io.*;

public class Main2961 {
    static int n, ans = Integer.MAX_VALUE;
    static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            list.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
        }
        check(0, 1, 0);
        System.out.println(ans);
    }

    public static void check(int cnt, int s, int c) {
        if (cnt == n) {
            if (s == 1 && c == 0)
                return;
            ans = Math.min(ans, Math.abs(s - c));
            return;
        }
        check(cnt + 1, s, c);
        int[] tmp = list.get(cnt);
        check(cnt + 1, s * tmp[0], c + tmp[1]);
    }
}