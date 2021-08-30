package baekjoon.bruteforcing;

import java.util.*;
import java.io.*;

public class Main10973 {
    static int n;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        if (nextPermutation()) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
        } else {
            System.out.println(-1);
        }
    }

    public static void swap(int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

    public static boolean nextPermutation() {
        int i = n - 1;
        while (i > 0 && arr[i - 1] <= arr[i])
            i--;
        if (i <= 0)
            return false;
        int j = n - 1;
        while (arr[j] >= arr[i - 1])
            j--;
        swap(i - 1, j);
        j = n - 1;
        while (i < j) {
            swap(i, j);
            i++;
            j--;
        }
        return true;
    }
}