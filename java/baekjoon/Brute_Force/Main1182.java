package baekjoon.Brute_Force;

import java.io.*;
import java.util.*;

public class Main1182 {
    static int n, s, ans;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        subset(0, 0);
        if (s == 0)
            ans--;
        System.out.println(ans);
    }

    public static void subset(int idx, int sum) {
        if (idx == n) {
            if (sum == s) {
                ans++;
            }
            return;
        }
        subset(idx + 1, sum);
        subset(idx + 1, sum + arr[idx]);
    }
}