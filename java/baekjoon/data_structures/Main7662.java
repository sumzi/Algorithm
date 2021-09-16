package baekjoon.data_structures;

import java.io.*;
import java.util.*;

public class Main7662 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            map.clear();
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                char a = st.nextToken().charAt(0);
                int b = Integer.parseInt(st.nextToken());
                if (a == 'I') {
                    map.put(b, map.getOrDefault(b, 0) + 1);

                } else {
                    if (map.isEmpty())
                        continue;
                    if (b == 1) {
                        int tmp = map.lastKey();
                        if (map.get(tmp) == 1)
                            map.remove(tmp);
                        else {
                            map.put(tmp, map.get(tmp) - 1);
                        }
                    } else {
                        int tmp = map.firstKey();
                        if (map.get(tmp) == 1)
                            map.remove(tmp);
                        else {
                            map.put(tmp, map.get(tmp) - 1);
                        }
                    }
                }
            }
            if (map.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(map.lastKey() + " " + map.firstKey());
            }
        }
    }
}