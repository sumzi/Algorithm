package baekjoon.greedy;

import java.io.*;
import java.util.*;

public class Main1931 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0]; // 음수면 자리가 그대로 유지
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
        int ans = 0;
        int end = 0;
        for (int[] i : arr) {
            if (end <= i[0]) {
                ans++;
                end = i[1];
            }
        }
        System.out.println(ans);
    }
}
