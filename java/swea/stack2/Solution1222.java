package swea.stack2;

import java.util.Scanner;

public class Solution1222 {
    static int n;
    static String s;
    static char arr[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            n=sc.nextInt();
            s=sc.next();
            int ans=0;
            for (int j = 0; j < s.length(); j++) {
                if (j%2==0){
                    ans+=((int)s.charAt(j)-48);
                }
            }
            System.out.printf("#%d %d%n",i+1,ans);
        }
    }
}