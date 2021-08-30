package baekjoon.divide_and_conquer;

import java.util.*;
import java.io.*;

public class Main10815 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int l = 0;
            int r = n - 1;
            int x = Integer.parseInt(st.nextToken());
            boolean flag = false;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (arr[mid] == x) {
                    flag = true;
                    break;
                } else if (arr[mid] > x) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            sb.append(flag ? 1 : 0).append(" ");
        }
        System.out.println(sb);
    }
}