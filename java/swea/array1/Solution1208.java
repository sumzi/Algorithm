package swea.array1;

import java.util.Arrays;
import java.util.Scanner;
public class Solution1208 {
    static int n;
	static int[] arr=new int[100];
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			n=sc.nextInt();
			for (int j = 0; j < 100; j++) {
				arr[j]=sc.nextInt();
			}
			Arrays.sort(arr);
			for (int j = 0; j < n; j++) {
				if (arr[99]-arr[0]<2) {
					break;
				}
				arr[99]--;
				arr[0]++;
				Arrays.sort(arr);
			}
			System.out.printf("#%d %d%n",i+1,arr[99]-arr[0]);
		}

	}
}
