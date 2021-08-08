package swea.tree;

import java.io.*;
import java.util.*;

class Node {
    public String op;
    public int num, left, right;

    public Node(String op, int left, int right) {
        this.op = op;
        this.left = left;
        this.right = right;
    }

    public Node(int num) {
        this.op = ".";
        this.num = num;
    }
}

public class Solution1232 {
    static int n;
    static String m;
    static Node[] node = new Node[1001];

    public static double check(int x) {
        if (node[x].op.equals("+")) {
            return check(node[x].left) + check(node[x].right);
        } else if (node[x].op.equals("-")) {
            return check(node[x].left) - check(node[x].right);
        } else if (node[x].op.equals("*")) {
            return check(node[x].left) * check(node[x].right);
        } else if (node[x].op.equals("/")) {
            return check(node[x].left) / check(node[x].right);
        } else {
            return node[x].num;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 1; i <= 10; i++) {
            n = Integer.parseInt(br.readLine());

            for (int j = 1; j <= n; j++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                if (st.countTokens() > 1) {
                    node[j] = new Node(st.nextToken(), Integer.parseInt(st.nextToken()),
                            Integer.parseInt(st.nextToken()));
                } else {
                    node[j] = new Node(Integer.parseInt(st.nextToken()));
                }
            }
            System.out.println("#" + i + " " + (int) check(1));
        }
    }
}