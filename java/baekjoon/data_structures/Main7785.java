package baekjoon.data_structures;

import java.io.*;
import java.util.*;

public class Main7785 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        HashMap<String, String> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            map.put(st.nextToken(), st.nextToken());
        }
        ArrayList<String> list = new ArrayList<>();
        for (String name : map.keySet()) {
            if (map.get(name).equals("enter")) {
                list.add(name);
            }
        }
        StringBuilder sb = new StringBuilder();
        Collections.sort(list, Collections.reverseOrder());
        for (String name : list) {
            sb.append(name + "\n");
        }
        System.out.println(sb);
    }
}
