package baekjoon;
import java.util.*;
import java.io.*;

public class Main1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int sum = 0;
        int ans = -1000;
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (tmp+sum<tmp){
                sum=tmp;
            }else{
                sum+=tmp;
            }
            if (sum>ans){
                ans=sum;
            }
        }
        System.out.println(ans);
    }
}
