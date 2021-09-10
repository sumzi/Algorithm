package baekjoon.binary_search;

import java.util.Arrays;
import java.util.Scanner;

public class Main2110 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] loc = new int[n];
        for (int i = 0; i < n; i++) {
            loc[i] = sc.nextInt();
        }
        Arrays.sort(loc);
        int ans = 0;
        int l = 1;
        int r = loc[n - 1] - loc[0];
        while (l <= r) {
            int mid = (l + r) / 2;
            // check
            int cnt = 1;
            int idx = loc[0];
            for (int i = 0; i < n; i++) {
                if (idx + mid <= loc[i]) {
                    idx = loc[i];
                    cnt++;
                }
            }
            if (cnt >= c) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(ans);
    }
}