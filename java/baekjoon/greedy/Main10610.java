package baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Main10610 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = s.length();
        Integer[] arr = new Integer[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s.charAt(i) + "");
            sum += arr[i];
        }
        Arrays.sort(arr, (i1, i2) -> i2 - i1);

        if (arr[n - 1] != 0 || sum % 3 != 0) {
            System.out.println(-1);
        } else {
            for (Integer i : arr) {
                System.out.print(i);
            }
        }
    }
}
