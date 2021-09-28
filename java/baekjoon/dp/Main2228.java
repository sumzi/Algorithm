package baekjoon.dp;

import java.util.*;

public class Main2228 {
    static int n, m;
    static int[] sum;
    static int[][] dp;
    static boolean[][] visited;
    static int min = -32768 * 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sum = new int[n + 1];
        dp = new int[n + 1][m + 1]; // n인덱스까지 앞으로 만들수있는 구간의 개수 의 최대합
        visited = new boolean[n + 1][m + 1]; // 방문여부

        for (int i = 1; i <= n; i++) {
            sum[i] += sum[i - 1] + sc.nextInt();
            Arrays.fill(dp[i], min); // min으로 초기화
        }
        System.out.println(divide(n, m));
    }

    public static int divide(int idx, int cnt) {
        // idx: 현재 인덱스
        // cnt: 나눌 구간의 수
        if (cnt == 0) // 나눌 구간이 없으면 종료
            return 0;
        if (idx <= 0) // 인덱스가 0보다 작거나 같으면 종료
            return min;
        if (visited[idx][cnt]) // 이미 방문했으면
            return dp[idx][cnt];

        visited[idx][cnt] = true;

        // idx가 구간에 포함되지 않는 경우,
        dp[idx][cnt] = divide(idx - 1, cnt);
        for (int i = 1; i <= idx; i++) {
            // 인접하지 않는 범위에서 cnt-1개의 구간의 합의 최댓값 구함
            dp[idx][cnt] = Math.max(dp[idx][cnt], divide(i - 2, cnt - 1) + sum[idx] - sum[i - 1]);
        }
        return dp[idx][cnt];
    }
}
