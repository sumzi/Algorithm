package swea;

import java.util.*;
import java.io.*;

public class Solution2112 {
    static int D, W, K, ans;
    static int[][] arr, arr2;

    public static boolean check(int[][] arr) {
        for (int i = 0; i < W; i++) {
            int num = 0;
            int cnt = 1;
            for (int j = 0; j < D - 1; j++) {
                if (arr[j][i] == arr[j + 1][i]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                num = Math.max(num, cnt);
            }
            if (K > num)
                return false;
        }
        return true;
    }

    public static void solution(int idx, int cnt) {
        if (cnt >= ans)
            return;

        if (idx == D) {
            if (check(arr)) {
                ans = Math.min(ans, cnt);
            }
            return;
        }
        // 그냥 넘김
        solution(idx + 1, cnt);
        // A로 변경
        for (int i = 0; i < W; i++) {
            arr[idx][i] = 0;
        }
        solution(idx + 1, cnt + 1);
        // B로 변경
        for (int i = 0; i < W; i++) {
            arr[idx][i] = 1;
        }
        solution(idx + 1, cnt + 1);

        for (int i = 0; i < W; i++) {
            arr[idx][i] = arr2[idx][i];
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        for (int i = 1; i <= tc; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new int[D][W];
            arr2 = new int[D][W];

            for (int j = 0; j < D; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < W; k++) {
                    arr[j][k] = arr2[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            if (K == 1 || check(arr)) {
                ans = 0;
            } else {
                ans = K;
                solution(0, 0);
            }
            System.out.println("#" + i + " " + ans);
        }
    }

}