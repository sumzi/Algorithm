package swea;
import java.util.Scanner;

public class Solution9229 {


	static int t, n, m, ans;
	static int[] arr;

	public static void check(int x, int y, int z) {
		if (y == 2) {
			if (z <= m) {
				ans = Math.max(ans, z);
			}
			return;
		}
		if (x == n)
			return;
		check(x + 1, y, z);
		check(x + 1, y + 1, z + arr[x]);

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			n = sc.nextInt();
			m = sc.nextInt();
			arr = new int[n];
			ans = -1;
			for (int j = 0; j < n; j++) {
				arr[j] = sc.nextInt();
			}
			check(0, 0, 0);
			System.out.println("#" + (i + 1) + " " + ans);
		}

	}

}