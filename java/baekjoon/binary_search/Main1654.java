package baekjoon.binary_search;

import java.util.Scanner;

public class Main1654 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long[] arr = new long[n];
        long l = 1;
        long r = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            r = Math.max(r, arr[i]);
        }
        long ans = 0;
        while (l <= r) {
            long mid = (l + r) / 2;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                cnt += arr[i] / mid;
            }
            if (cnt >= k) {
                ans = Math.max(ans, mid);
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
