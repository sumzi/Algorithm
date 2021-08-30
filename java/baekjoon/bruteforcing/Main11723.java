package baekjoon.bruteforcing;

import java.util.*;
import java.io.*;

public class Main11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();
        int m = Integer.parseInt(br.readLine());
        int n = 0, x;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String tmp = st.nextToken();
            if (tmp.equals("all")) {
                n = (1 << 21) - 1;
            } else if (tmp.equals("empty")) {
                n = 0;
            } else {
                x = Integer.parseInt(st.nextToken());
                if (tmp.equals("add")) {
                    n |= (1 << x);
                } else if (tmp.equals("remove")) {
                    n &= ~(1 << x);
                } else if (tmp.equals("check")) {
                    sb.append((n & (1 << x)) != 0 ? 1 : 0).append('\n');
                } else if (tmp.equals("toggle")) {
                    n ^= (1 << x);
                }
            }
        }
        System.out.println(sb);
    }
}