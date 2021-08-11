package baekjoon.greedy;

import java.util.*;

public class Main1744 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] ans = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        for (int i = 1; i < n + 1; i++) {
            ans[i] = ans[i - 1] + arr[i - 1];
            if (i > 1) {
                ans[i] = Math.max(ans[i], ans[i - 2] + (arr[i - 2] * arr[i - 1]));
            }
        }
        System.out.println(ans[n]);
    }
}
