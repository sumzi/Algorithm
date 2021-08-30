package baekjoon.Brute_Force;

import java.util.*;
import java.io.*;

public class Main6603 {
    static int[] input = new int[6];
    static int[] arr;
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            if (st.countTokens() == 1)
                break;
            n = Integer.parseInt(st.nextToken());
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            tracking(0, 0);
            System.out.println();
        }
    }

    public static void tracking(int cur, int cnt) {
        if (cnt == 6) {
            for (int i : input) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        for (int i = cur; i < n; i++) {
            input[cnt] = arr[i];
            tracking(i + 1, cnt + 1);
        }
    }
}