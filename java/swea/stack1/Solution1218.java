package swea.stack1;

import java.util.Scanner;

public class Solution1218 {
    static int n,a,b,c,d;
    static String s;
    static boolean flag;
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        for (int i = 1; i < 11; i++) {
            n=sc.nextInt();
            s=sc.next();
            a=b=c=d=0;
            flag=false;
            for (int j = 0; j < n; j++) {
                char m = s.charAt(j);
                if (m=='(' | m==')'){
                    a+=(m=='('?1:-1);
                    if (a<0){
                        flag=true;
                        break;
                    }
                }else if(m=='[' | m==']'){
                    b+=(m=='['?1:-1);
                    if (b<0){
                        flag=true;
                        break;
                    }
                }else if(m=='{' | m=='}'){
                    c+=(m=='{'?1:-1);
                    if (c<0){
                        flag=true;
                        break;
                    }
                }else if(m=='<' | m=='>'){
                    d+=(m=='<'?1:-1);
                    if (d<0){
                        flag=true;
                        break;
                    }
                }
            }
            if (flag) {
                System.out.printf("#%d %d%n",i,0);
            }
            else if (a==0 &&b==0&&c==0&&d==0){
                System.out.printf("#%d %d%n",i,1);
            }else{
                System.out.printf("#%d %d%n",i,0);
            }
        }
    }
}
