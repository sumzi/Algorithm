package baekjoon.greedy;

import java.util.*;

public class Main11047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = sc.nextInt();
        }
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            ans += k / coin[i];
            k = k % coin[i];
            if (k == 0)
                break;
        }
        System.out.println(ans);
    }
}
