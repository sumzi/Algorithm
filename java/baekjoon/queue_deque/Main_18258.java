package java.baekjoon.queue_deque;

import java.util.*;
import java.io.*;

public class Main_18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Deque<Integer> q = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()){
                case "push":
                    int m =Integer.parseInt(st.nextToken());
                    q.add(m);
                    break;
                case "pop":
                    sb.append(q.isEmpty()?"-1\n":q.poll()+"\n");
                    break;
                case "size":
                    sb.append(q.size()+"\n");
                    break;
                case "empty":
                    sb.append(q.isEmpty()?"1\n":"0\n");
                    break;
                case "front":
                    sb.append(q.isEmpty()?"-1\n":q.getFirst()+"\n");
                    break;
                case "back":
                    sb.append(q.isEmpty()?"-1\n":q.getLast()+"\n");
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
