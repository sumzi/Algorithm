package baekjoon;

import java.util.*;
import java.io.*;

public class Main2491 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int prev = 0;
        int ans = 0;
        int cnt = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(st.nextToken());
            arr[i] = cur;
            if (prev <= cur) {
                cnt++;
            } else {
                ans = Math.max(ans, cnt);
                cnt = 1;
            }
            prev = cur;
        }
        ans = Math.max(ans, cnt);
        prev = 0;
        cnt = 0;
        for (int i = n - 1; i > -1; i--) {
            if (prev <= arr[i]) {
                cnt++;
            } else {
                ans = Math.max(ans, cnt);
                cnt = 1;
            }
            prev = arr[i];
        }
        ans = Math.max(ans, cnt);
        System.out.println(ans);
    }
}