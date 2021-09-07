package baekjoon.binary_search;

import java.util.Scanner;

public class Main2805 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long m = sc.nextInt();
        long[] arr = new long[n];
        long l = 1;
        long r = 1;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            r = Math.max(r, arr[i]);
        }
        long ans = 0;
        while (l <= r) {
            long mid = (l + r) / 2;
            long num = 0;
            for (int i = 0; i < n; i++) {
                long tree = arr[i] - mid;
                if (tree > 0)
                    num += tree;
            }
            if (m <= num) {
                l = mid + 1;
                ans = Math.max(ans, mid);
            } else {
                r = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
