package baekjoon.bruteforcing2;

import java.util.Scanner;

public class Main2003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int cnt = 0;
        int sum = arr[0];
        int l = 0, r = 0;
        while (l <= r && r < n) {
            if (sum < m) {
                r++;
                sum += arr[r];
            } else if (sum == m) {
                cnt++;
                r++;
                sum += arr[r];
            } else if (sum > m) {
                sum -= arr[l];
                l++;
                if (l > r && l < n) {
                    r = l;
                    sum = arr[l];
                }
            }
        }
        System.out.println(cnt);
    }
}
