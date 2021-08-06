package swea;

import java.util.*;


public class Solution3499 {
    static int t, n;
	static String[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			n = sc.nextInt();
			arr = new String[n];
			for (int j = 0; j < n; j++) {
				arr[j] = sc.next();
			}
			int num1 = 0;
			int num2 = n / 2;
			if (n % 2 != 0)
				num2++;
			System.out.print("#" + (i + 1) + " ");
			for (int j = 0; j < n / 2; j++) {
				System.out.print(arr[num1++] + " ");
				System.out.print(arr[num2++] + " ");
			}
			if (n % 2 != 0)
				System.out.print(arr[num1]);
			System.out.println();
		}
	}
}
