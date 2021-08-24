package swea;

import java.util.*;
import java.io.*;

public class Solution3289 {
    static int[] p;

    public static int FindSet(int x) {
        if (x == p[x])
            return x;
        return p[x] = FindSet(p[x]);
    }

    public static void Union(int x, int y) {
        x = FindSet(x);
        y = FindSet(y);
        if (x == y)
            return;
        p[y] = x;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;
        int t = Integer.parseInt(br.readLine());
        int n, m, a, b, c;
        
        for (int j = 0; j < t; j++) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            p = new int[n + 1];
            for (int i = 1; i < n + 1; i++) {
                p[i] = i;
            }
            sb = new StringBuilder();
            sb.append("#").append(j+1).append(" ");
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());
                if (a == 0) {
                    Union(b, c);
                } else {
                    if (FindSet(b) == FindSet(c)) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }
                }
            }
            System.out.println(sb);
        }
    }
}