package swea.string;

import java.util.Scanner;

public class Solution1213 {
    static int n,m,ans;
    static String s1,s2;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            n=sc.nextInt();
            s1=sc.next();
            s2=sc.next();
            m=s1.length();
            ans=0;
            for (int j = 0; j < s2.length()-m+1; j++) {
                if(s1.equals(s2.substring(j, j+m))){
                    ans++;
                }
            }
            System.out.printf("#%d %d%n",n,ans);
        }
    }
}