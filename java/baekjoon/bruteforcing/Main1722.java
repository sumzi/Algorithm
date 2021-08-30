package baekjoon.Brute_Force;

import java.io.*;
import java.util.*;

public class Main1722 {
    static int n;
    static long[] dp = new long[21];
    static int[] arr;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp[0] = 1;
        for (int i = 1; i < 21; i++) {
            dp[i] = dp[i - 1] * i;
        }
        n = Integer.parseInt(br.readLine());
        check = new boolean[n + 1];
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        if (st.nextToken().equals("1")) {
            long m = Long.parseLong(st.nextToken());
            for (int i = 0; i < n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (check[j])
                        continue;
                    if (dp[n - i - 1] < m) {
                        m -= dp[n - i - 1];
                    } else {
                        arr[i] = j;
                        check[j] = true;
                        break;
                    }
                }
            }
            for(int i=0; i<n; i++) {
                System.out.print(arr[i] + " ");
            }
        } else {
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            long ans = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < arr[i]; j++) {
                    if (!check[j]) {
                        ans += dp[n - i - 1];
                    }
                }
                check[arr[i]] = true;
            }
            System.out.println(ans);
        }
    }
}