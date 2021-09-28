package baekjoon.dp;

import java.util.Scanner;

public class Main2240 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int w = sc.nextInt();
        int[] arr = new int[t + 1];
        // 1~t초까지 자두나무 위치를 저장
        for (int i = 1; i < t + 1; i++) {
            arr[i] = sc.nextInt();
        }
        // dp[자두나무 위치][떨어지는 시간][최대 움직일 수 있는 횟수]
        int[][][] dp = new int[3][t + 1][w + 2];
        for (int i = 1; i < t + 1; i++) {
            for (int j = 1; j < w + 2; j++) {
                if (arr[i] == 1) { // 위치가 1일때
                    // 움직이지 않고 같은 위치에서 받는 경우
                    dp[1][i][j] = Math.max(dp[1][i - 1][j], dp[2][i - 1][j - 1]) + 1;
                    // 움직여서 다른 위치의 자두를 받는 경우
                    dp[2][i][j] = Math.max(dp[2][i - 1][j], dp[1][i - 1][j - 1]);
                } else {
                    if (i == 1 && j == 1)
                        // 처음에 1에서 떨어짐
                        continue;
                    dp[1][i][j] = Math.max(dp[1][i - 1][j], dp[2][i - 1][j - 1]);
                    dp[2][i][j] = Math.max(dp[2][i - 1][j], dp[1][i - 1][j - 1]) + 1;
                }
            }
        }
        int ans = 0;
        for (int i = 1; i < w + 2; i++) {
            // 움직일수있는 수만큼 자두나무1,2 모두 비교
            ans = Math.max(ans, Math.max(dp[1][t][i], dp[2][t][i]));
        }
        System.out.println(ans);
    }
}
