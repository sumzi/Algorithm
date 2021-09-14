package baekjoon.data_structures;

import java.util.*;
import java.io.*;

public class Main12767 {
    static class Node {
        int no;
        Node left = null;
        Node right = null;

        Node(int no) {
            this.no = no;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;
        ArrayList<Integer> list;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            Node root = new Node(Integer.parseInt(st.nextToken()));
            list = new ArrayList<>();
            sb = new StringBuilder();

            for (int j = 0; j < k - 1; j++) {
                int x = Integer.parseInt(st.nextToken());
                int idx = 1;
                Node cur = root;
                while (true) {
                    if (cur.no < x) {
                        idx = idx * 2 + 1;
                        if (cur.right == null) {
                            cur.right = new Node(x);
                            list.add(idx);
                            break;
                        } else {
                            cur = cur.right;
                        }
                    } else {
                        idx = idx * 2;
                        if (cur.left == null) {
                            cur.left = new Node(x);
                            list.add(idx);
                            break;
                        } else {
                            cur = cur.left;
                        }
                    }
                }
            }
            Collections.sort(list);
            for (Integer no : list) {
                sb.append(no);
            }
            String s = sb.toString();
            if (!set.contains(s)) {
                set.add(s);
            }
        }
        System.out.println(set.size());
    }
}
