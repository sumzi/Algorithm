package java.baekjoon.queue_deque;

import java.io.*;
import java.util.*;

public class Main_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        int n,m;
        while (t-- > 0) {
            LinkedList<int[]> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());
            m=Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                int x =Integer.parseInt(st.nextToken());
                q.offer(new int[] {i,x});
                arr[i]=x;
            }
            Arrays.sort(arr,Collections.reverseOrder());
            int ans=0;
            while(!q.isEmpty()){
                int[] x =q.poll();
                if (arr[ans]==x[1]){
                    ans++;
                    if (x[0]==m){
                        break;
                    }
                }else{
                    q.offer(x);
                }
            }
            System.out.println(ans);
        }
    }
}
