package swea.stack2;

import java.util.Scanner;
import java.util.Stack;

public class Solution1223 {
    static char c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> st = new Stack<>();
        Stack<Integer> num = new Stack<>();
        for (int i = 0; i < 10; i++) {
            int n = sc.nextInt();
            String s = sc.next();
            String tmp = ""; // 후위 표기식으로 바꾼 문자열
            for (int j = 0; j < s.length(); j++) {
                c = s.charAt(j);
                if (0 <= c - 48 && c - 48 < 10) {
                    tmp += c;
                } else {
                    if (c == '*') {
                        st.push(c);
                    } else {
                        while (!st.isEmpty() && st.peek() == '*') {
                            tmp += st.pop();
                        }
                        st.push(c);
                    }
                }
            }
            while (!st.isEmpty()) {
                tmp += st.pop();
            }
            for (int j = 0; j < tmp.length(); j++) {
                c = tmp.charAt(j);
                if (0 <= c - 48 && c - 48 < 10) {
                    num.push(c-48);
                }else{
                    int a = num.pop();
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
}