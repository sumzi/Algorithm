package baekjoon.graph;

import java.util.*;

public class Main1507 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        boolean[][] del = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        boolean flag = false;
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (k == i)
                    continue;
                for (int j = 0; j < n; j++) {
                    if (flag)
                        break;
                    if (i == j || j == k)
                        continue;
                    // 플로이드 성립 아님
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        System.out.println(-1);
                        flag = true;
                    }
                    // 모든 경로를 최소의 도로로 커버해야하므로 k를 거쳐가는 도로를 선택
                    if (arr[i][j] == arr[i][k] + arr[k][j]) {
                        del[i][j] = true;
                    }
                }
            }
        }
        if (!flag) {
            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (!del[i][j])
                        ans += arr[i][j];
                }
            }
            System.out.println(ans);
        }
    }
}
