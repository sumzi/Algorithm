package baekjoon.Brute_Force;

import java.util.Scanner;

public class Main9663 {
    static int n, ans;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];

        tracking(0);
        System.out.println(ans);
    }

    public static void tracking(int cur) {
        // n만큼 탐색했다면 ans++ 종료
        if (cur == n) {
            ans++;
            return;
        }
        for (int i = 0; i < n; i++) {
            arr[cur] = i;
            if (check(cur)) {
                tracking(cur + 1);
            }
        }
    }

    public static boolean check(int cur) {
        for (int i = 0; i < cur; i++) {
            if (arr[cur] == arr[i] || Math.abs(arr[cur] - arr[i]) == cur - i)
                return false;
        }
        return true;
    }
}