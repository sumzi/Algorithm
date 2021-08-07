package swea.tree;

import java.io.*;
import java.util.*;

public class Solution1231 {
    static int n, m;
    static String[] alpha;
    static int[][] tree;

    public static void inOrder(int x) {
        if (tree[x][0] != 0)
            inOrder(tree[x][0]);
        System.out.print(alpha[x]);
        if (tree[x][1] != 0)
            inOrder(tree[x][1]);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int t = 1; t <= 10; t++) {
            n = Integer.parseInt(br.readLine());
            alpha = new String[n + 1];
            tree = new int[n + 1][2];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                m = Integer.parseInt(st.nextToken());
                alpha[m] = st.nextToken();
                int cnt = 0;
                while (st.hasMoreTokens()) {
                    tree[m][cnt++] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.print("#" + t + " ");
            inOrder(1);
            System.out.println();
        }
    }
}
