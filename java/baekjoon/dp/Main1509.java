package baekjoon.dp;

import java.util.*;

public class Main1509 {
    static String s;
    static int[][] d1;
    static int[] d2;
    static int max = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.next();
        int n = s.length();
        d1 = new int[n][n];
        d2 = new int[n + 1];
        for (int i = 0; i < n; i++) {
            d1[i][i] = 1;
        }
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                d1[i][i + 1] = 1;
            }
        }
        for (int i = 2; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                int k = i + j;
                if (s.charAt(j) == s.charAt(k) && d1[j + 1][k - 1] == 1) {
                    d1[j][k] = 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            d2[i + 1] = max;
            for (int j = 0; j <= i; j++) {
                if (d1[j][i] == 1) {
                    d2[i + 1] = Math.min(d2[i + 1], d2[j] + 1);
                }
            }
        }
        System.out.println(d2[n]);
    }
}