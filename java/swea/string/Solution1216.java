package swea.string;

import java.util.Scanner;

public class Solution1216 {
    static int n, ans, l, r;
	static char[][] arr;
	static boolean flag;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			n = sc.nextInt();
			arr = new char[100][100];
			for (int j = 0; j < 100; j++) {
				arr[j] = sc.next().toCharArray();
			}
			ans = 0;
			for (int a = 0; a < 100; a++) {
				for(int b = 1;b<100;b++){
					for (int c = 0; c < 100-b; c++) {
						flag=true;
						l=c;
						r=c+b;
						while(l<r){
							if(arr[a][l++]!=arr[a][r--]){
								flag=false;
								break;
							}
						}
						if(flag) ans=Math.max(ans, b);
						flag=true;
						l=c;
						r=c+b;
						while(l<r){
							if(arr[l++][a]!=arr[r--][a]){
								flag=false;
								break;
							}
						}
						if(flag) ans=Math.max(ans, b);
					}
				}
			}
			System.out.printf("#%d %d%n",n,ans+1);
		}
	}
}
