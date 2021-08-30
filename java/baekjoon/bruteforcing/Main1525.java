package baekjoon.bruteforcing;

import java.util.*;
import java.io.*;

public class Main1525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Queue<String> q = new LinkedList<>();
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < 3; i++) {
            sb.append(br.readLine().replace(" ", ""));
        }
        int idx = sb.indexOf("0");
        q.add(sb.toString()); // or offer()
        map.put(sb.toString(), 0);
        int ans = -1, x, y, nx, ny;
        String data, ndata;
        char c;
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };
        while (!q.isEmpty()) {
            data = q.poll();
            if (data.equals("123456780")) {
                ans = map.get("123456780");
            }
            idx = data.indexOf("0"); // String에서 해당 char 찾아 인덱스 출력
            x = idx / 3;
            y = idx % 3;
            for (int i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];
                if (0 <= nx && nx < 3 && 0 <= ny && ny < 3) {
                    // swap
                    sb = new StringBuilder(data);
                    c = sb.charAt(nx * 3 + ny); // next char 임시 c에 저장
                    sb.setCharAt(idx, c);
                    sb.setCharAt(nx * 3 + ny, '0');

                    ndata = sb.toString();
                    if (!map.containsKey(ndata)) {
                        map.put(ndata, map.get(data) + 1);
                        q.add(ndata);
                    }
                }
            }
        }
        System.out.println(ans);
    }
}