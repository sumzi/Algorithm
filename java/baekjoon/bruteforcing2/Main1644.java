package baekjoon.bruteforcing2;

import java.util.*;

public class Main1644 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        boolean[] prime = new boolean[n + 1];
        for (int i = 2; i < n + 1; i++) {
            for (int j = i + i; j < n + 1; j += i) {
                prime[j] = true;
            }
        }
        for (int i = 2; i < n + 1; i++) {
            if (!prime[i])
                arr.add(i);
        }
        int m = arr.size();
        arr.add(0);
        int sum = arr.get(0);
        int l = 0, r = 0;
        int cnt = 0;
        while (l <= r && r < m) {
            if (sum < n) {
                sum += arr.get(++r);
            } else if (sum == n) {
                cnt++;
                sum += arr.get(++r);
            } else if (sum > n) {
                sum -= arr.get(l++);
                if (l > r && l < m) {
                    r = l;
                    sum = arr.get(l);
                }
            }
        }
        System.out.println(cnt);
    }
}
