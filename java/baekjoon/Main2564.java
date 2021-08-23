package baekjoon;

import java.util.*;
import java.io.*;

public class Main2564 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());// 가로
        int y = Integer.parseInt(st.nextToken());// 세로
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == 1) {
                arr[i] = b;
            } else if (a == 2) {
                arr[i] = x + y + (x - b);
            } else if (a == 3) {
                arr[i] = x * 2 + y + (y - b);
            } else if (a == 4) {
                arr[i] = x + b;
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int tmp = Math.abs(arr[n] - arr[i]);
            ans += Math.min(tmp, (x * 2) + (y * 2) - tmp);
        }
        System.out.println(ans);
    }
}