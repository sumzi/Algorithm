package swea;

import java.util.*;
import java.io.*;

public class Solution3234 {
    static int t, ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            ans = 0;
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] num = new int[n];
            for (int j = 0; j < n; j++) {
                num[j] = Integer.parseInt(st.nextToken());
            }
            tracking(0, 0, 0, new boolean[n], num, n);
            System.out.println(ans);
        }
    }

    public static void tracking(int l, int r, int cnt, boolean[] check, int[] number, int n) {
        if (cnt == n) {
            ans++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (check[i])
                continue;
            check[i] = true;
            tracking(l + number[i], r, cnt + 1, check, number, n);
            if (r + number[i] <= l)
                tracking(l, r + number[i], cnt + 1, check, number, n);
            check[i] = false;
        }
    }
}