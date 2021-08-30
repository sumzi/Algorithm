package baekjoon;

import java.util.Scanner;

public class Main2477 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int width=0,height=0;
        int[] arr =new int[6];
        int k=sc.nextInt();
        int w=0,h=0;
        for (int i = 0; i < 6; i++) {
            sc.nextInt();
            arr[i]=sc.nextInt();
            if(i%2==0){
                width=Math.max(width, arr[i]);
            }else{
                height=Math.max(height, arr[i]);
            }
        }
        for (int i = 0; i < 6; i++) {
            if(i%2==0){ // 짝수
                if(height==arr[(i+1)%6]+arr[(i+5)%6]){
                    w=arr[i];
                }
            }else{
                if(width==arr[(i+1)%6]+arr[(i+5)%6]){
                    h=arr[i];
                }
            }
        }
        System.out.println((width*height-w*h)*k);
    }
}