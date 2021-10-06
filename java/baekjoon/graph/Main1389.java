package baekjoon.graph;

import java.util.*;

public class Main1389 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int INF = 100000000;
        int[][] arr = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            Arrays.fill(arr[i], INF);
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = arr[b][a] = 1;
        }
        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }
        int num = 1;
        int ans = INF;
        for (int i = 1; i < n + 1; i++) {
            int cnt = 0;
            for (int j = 1; j < n + 1; j++) {
                if (i == j)
                    continue;
                cnt += arr[i][j];
            }
            if (ans > cnt) {
                ans = cnt;
                num = i;
            }
        }
        System.out.println(num);
    }
}
