package baekjoon.bruteforcing2;

import java.util.*;
import java.io.*;

/**
 * hashmap x 시간초과
 * 
 */
public class Main7453 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][4];
        int[] list = new int[n * n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 4; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                list[idx++] = arr[i][0] + arr[j][1];
            }
        }
        Arrays.sort(list);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x = arr[i][2] + arr[j][3];
                int low = lowerBound(list, -x);
                int up = upperBound(list, -x);
                ans += up - low;
            }

        }
        System.out.println(ans);
    }

    private static int upperBound(int[] list, int x) {
        int l = 0, r = list.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (list[mid] <= x) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    private static int lowerBound(int[] list, int x) {
        int l = 0, r = list.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (list[mid] >= x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
