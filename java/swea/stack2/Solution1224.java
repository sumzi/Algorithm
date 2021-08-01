package swea.stack2;

import java.util.Scanner;
import java.util.Stack;

public class Solution1224 {
    static int n;
    static String s, ns;
    static char c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> st = new Stack<>();
        Stack<Integer> num = new Stack<>();

        for (int i = 0; i < 10; i++) {
            n = sc.nextInt();
            s = sc.next();
            ns = "";
            for (int j = 0; j < s.length(); j++) {
                c = s.charAt(j);

                if (0 <= c - 48 && c - 48 < 10) {
                    ns += c;
                }else{
                    if(st.isEmpty()){
                        st.push(c);
                    }else{
                        if(c == '(') {
                            st.push(c);
                        } else if (c == ')') {
                            while (st.peek() != '(') {
                                ns += st.pop();
                            }
                            st.pop();
                        }
                        else if (check(st.peek())<=check(c)){
                            st.push(c);
                        }else{
                            while(!st.isEmpty() && check(c)<check(st.peek())){
                                ns+=st.pop();
                            }
                            st.push(c);
                        }
                    }
                }
            }
            while(!st.isEmpty()){
                ns+=st.pop();
            }
            for (int j = 0; j < ns.length(); j++) {
                c=ns.charAt(j);
                if(0<=c-48 && c-48<10){
                    num.push(c-48);
                }else{
                    int a=num.pop();
                    int b=num.pop();
                    if(c=='*'){
                        num.push(a*b);
                    }else{
                        num.push(a+b);
                    }
                }
            }
            System.out.printf("#%d %d%n",i+1,num.pop());
        }
    }
    public static int check(char a){
        if(a=='*')return 2;
        if(a=='+')return 1;
        return 0;
    }
}
