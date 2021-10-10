package baekjoon.bruteforcing2;

import java.util.*;

public class Main1806 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int ans = n + 1;
        int l = 0, r = 0;
        int sum = arr[0];
        while (l <= r && r < n) {
            if (sum < s) {
                r++;
                sum += arr[r];
            } else if (sum == s) {
                ans = Math.min(ans, r - l + 1);
                r++;
                sum += arr[r];
            } else if (sum > s) {
                ans = Math.min(ans, r - l + 1);
                sum -= arr[l];
                l++;
                if (l > r && l < n) {
                    r = l;
                    sum = arr[l];
                }
            }
        }

        System.out.println(ans == n + 1 ? 0 : ans);
    }
}
