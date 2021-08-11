package baekjoon.greedy;

import java.util.*;

public class Main2875 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int ans = Math.min(n / 2, m);
        int tmp = (n - ans * 2) + m - ans;
        if (tmp < k) {
            k -= tmp;
            while (k > 0) {
                ans -= 1;
                k -= 3;
            }
        }
        System.out.println(ans);
    }
}
