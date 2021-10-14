package baekjoon.bruteforcing2;

import java.util.*;
import java.io.*;

public class Main2470 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        String ans = "";
        int min = 2000000001;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int sum = arr[l] + arr[r];
            if (min > Math.abs(sum)) {
                ans = arr[l] + " " + arr[r];
                min = Math.abs(sum);

                if (sum == 0)
                    break;
            }
            if (sum < 0) {
                l++;
            } else {
                r--;
            }
        }
        System.out.println(ans);
    }
}
