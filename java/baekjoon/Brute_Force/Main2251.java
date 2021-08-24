package baekjoon.Brute_Force;

import java.util.*;
import java.io.*;

public class Main2251 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] water = new int[3];
        water[0] = sc.nextInt();
        water[1] = sc.nextInt();
        water[2] = sc.nextInt();
        boolean[][][] visited = new boolean[water[0] + 1][water[1] + 1][water[2] + 1];
        int[] nx = new int[3];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, 0, water[2] });
        visited[0][0][water[2]] = true;
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int[] x = q.poll();
            if (x[0] == 0) {
                ans.add(x[2]);
            }
            for (int i = 0; i < 3; i++) {
                if (x[i] == 0)
                    continue;
                for (int j = 0; j < 3; j++) {
                    if (i == j)
                        continue;
                    nx[0] = x[0];
                    nx[1] = x[1];
                    nx[2] = x[2];
                    if (water[j] - nx[j] >= nx[i]) {
                        nx[j] += nx[i];
                        nx[i] = 0;
                    } else {
                        int tmp = water[j] - nx[j];
                        nx[j] = water[j];
                        nx[i] -= tmp;
                    }
                    if (!visited[nx[0]][nx[1]][nx[2]]) {
                        visited[nx[0]][nx[1]][nx[2]] = true;
                        q.add(new int[] { nx[0], nx[1], nx[2] });
                    }
                }

            }
        }
        Collections.sort(ans);
        for (Integer i : ans) {
            System.out.print(i+" ");
        }
    }
}