package baekjoon.divide_and_conquer;

import java.util.*;
import java.io.*;

public class Main11728 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        int[] b = new int[m];
        int sn = 0, sm = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        Arrays.sort(b);
        while (true) {
            if (sn == n && sm == m) {
                break;
            } else if (sn == n) {
                for (int i = sm; i < m; i++) {
                    sb.append(b[i] + " ");
                }
                break;
            } else if (sm == m) {
                for (int i = sn; i < n; i++) {
                    sb.append(a[i] + " ");
                }
                break;
            } else {
                if (a[sn] < b[sm]) {
                    sb.append(a[sn] + " ");
                    sn++;
                } else {
                    sb.append(b[sm] + " ");
                    sm++;
                }
            }
        }
        System.out.println(sb);
    }
}