package baekjoon.divide_and_conquer;

import java.util.*;
import java.io.*;

public class Main10816 {
    static int[] arr;
    static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(st.nextToken());
            sb.append(upperBound(x) - lowerBound(x)).append(" ");
        }
        System.out.println(sb);
    }

    public static int lowerBound(int x) {
        int l = 0;
        int r = n;
        while (l < r) {
            int mid = (l + r) / 2;
            if (x <= arr[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static int upperBound(int x) {
        int l = 0;
        int r = n;
        while (l < r) {
            int mid = (l + r) / 2;
            if (x < arr[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
