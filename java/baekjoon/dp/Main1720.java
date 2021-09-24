package baekjoon.dp;

import java.util.Scanner;

public class Main1720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] dp = new long[31];
        dp[1] = 1;
        dp[2] = 3;
        if (n == 1)
            System.out.println(1);
        else if (n == 2)
            System.out.println(3);
        else {
            for (int i = 3; i < 31; i++) {
                dp[i] = dp[i - 1] + dp[i - 2] * 2L;
            }
            if (n % 2 == 0) {
                System.out.println((dp[n] + dp[(n - 2) / 2] * 2 + dp[n / 2]) / 2);
            } else {
                System.out.println((dp[n] + dp[(n - 1) / 2]) / 2);
            }
        }

    }
}
