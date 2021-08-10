package baekjoon.greedy;

import java.io.*;
import java.util.*;

public class Main1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st, st2;
        st = new StringTokenizer(br.readLine(), "-");
        List<Integer> list = new ArrayList<>();
        while (st.hasMoreTokens()) {
            st2 = new StringTokenizer(st.nextToken(), "+");
            int sum = 0;
            while (st2.hasMoreTokens()) {
                sum += Integer.parseInt(st2.nextToken());
            }
            list.add(sum);
        }
        int ans = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            ans -= list.get(i);
        }
        System.out.println(ans);
    }
}
