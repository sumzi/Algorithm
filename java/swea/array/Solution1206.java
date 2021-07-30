package swea.array;

import java.util.Scanner;

public class Solution1206 {
    static int n,ans;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i < 11; i++) {
            n=sc.nextInt();
            arr=new int[n];
            for (int j = 0; j < n; j++) {
                arr[j]=sc.nextInt();
            }
            int num=2;
            ans=0;
            while(num<n-2){
                int cur=arr[num];
                int tmp=Math.max(Math.max(arr[num-2],arr[num-1]), Math.max(arr[num+2],arr[num+1]));
                if (cur>tmp){
                    ans+=(cur-tmp);
                    num+=2;
                }else{
                    num++;
                }
            }
            System.out.printf("#%d %d%n",i,ans);
        }
        sc.close();
    }
}
