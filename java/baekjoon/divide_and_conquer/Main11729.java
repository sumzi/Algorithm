package baekjoon.divide_and_conquer;

import java.util.ArrayList;
import java.util.Scanner;

public class Main11729 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        sb.append((int) (Math.pow(2, k) - 1)).append("\n");
        hanoi(k, 1, 3, 2);
        System.out.println(sb);
    }

    public static void hanoi(int n, int s, int e, int m) {
        if (n == 1) {
            sb.append(s + " " + e + "\n");
        } else {
            hanoi(n - 1, s, m, e);
            sb.append(s + " " + e + "\n");
            hanoi(n - 1, m, e, s);
        }
    }
}