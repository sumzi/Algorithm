package baekjoon.greedy;

import java.io.*;
import java.util.*;

public class Main11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int sum = 0;
        int ans = 0;
        for (int i : arr) {
            sum += i;
            ans += sum;
        }
        System.out.println(ans);
    }
}
