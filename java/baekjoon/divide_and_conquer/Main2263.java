package baekjoon.divide_and_conquer;

import java.util.*;
import java.io.*;

public class Main2263 {
    static int[] in, post, position;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        in = new int[n];
        post = new int[n];
        position = new int[n + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            in[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            post[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n; i++) {
            position[in[i]] = i;
        }
        preorder(0, n - 1, 0, n - 1);
        System.out.println(sb);
    }

    public static void preorder(int is, int ie, int ps, int pe) {
        if (is > ie || ps > pe)
            return;
        int root = post[pe];
        sb.append(root + " ");
        int idx = position[root];
        int tmp = idx - is;
        preorder(is, idx - 1, ps, ps + tmp - 1);
        preorder(idx + 1, ie, ps + tmp, pe - 1);
    }
}
