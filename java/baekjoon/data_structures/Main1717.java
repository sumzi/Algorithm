package baekjoon.data_structures;

import java.util.*;
import java.io.*;

public class Main1717 {
    static int[] arr;

    public static int find(int x) {
        if (arr[x] == x) {
            return x;
        }
        arr[x] = find(arr[x]);
        return arr[x];
    }

    public static void merge(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y)
            return;
        if (x < y)
            arr[y] = x;
        else
            arr[x] = y;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int t = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (t == 0) {
                merge(a, b);
            } else {
                System.out.println(find(a) == find(b) ? "YES" : "NO");
            }
        }
    }
}
