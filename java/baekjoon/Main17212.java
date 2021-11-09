package baekjoon;

import java.util.*;

public class Main17212 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = { 1, 2, 5, 7 };
        int n = sc.nextInt();
        int[] d = new int[n + 1];
        Arrays.fill(d, 1000000);
        d[0] = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = arr[i]; j <= n; j++) {
                d[j] = Math.min(d[j], d[j - arr[i]] + 1);
            }
        }
        System.out.println(d[n]);
    }
}
