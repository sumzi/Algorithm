package baekjoon.Brute_Force;

import java.util.*;

public class Main10819 {
    static int n;
    static int[] number;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        number = new int[n];
        for (int i = 0; i < n; i++) {
            number[i] = sc.nextInt();
        }
        Arrays.sort(number);
        int ans = 0;
        do {
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                sum += Math.abs(number[i] - number[i + 1]);
            }
            ans = Math.max(ans, sum);
        } while (np());
        System.out.println(ans);
    }

    public static boolean np() {
        int i = n - 1;
        while (i > 0 && number[i - 1] >= number[i])
            i--;
        if (i == 0)
            return false;
        int j = n - 1;
        while (number[i - 1] >= number[j])
            j--;
        swap(i - 1, j);
        j = n - 1;
        while (i < j) {
            swap(i++, j--);
        }
        return true;
    }

    public static void swap(int x, int y) {
        int tmp = number[x];
        number[x] = number[y];
        number[y] = tmp;
    }
}