# Stack2

## **1222. 계산기1**

> 문자열로 이루어진 계산식이 주어질 때, 이 계산식을 후위 표기식으로 바꾸어 계산하는 프로그램을 작성하시오.

✏️ **문제 풀이**
- 문자열 계산식을 구성하는 연산자는 + 하나뿐이고, 피연자인 숫자는 0~9의 한자리 정수만 주어진다.
- 문자열을 받아 char 배열에 넣고 문자열 길이만큼 for문을 사용하여 정수는 한자리이므로 짝수 인덱스일때마다 ans변수에 더하는 방식으로 풀었다. 


✏️ **소스 코드**
```java
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
```

🤔 **후기**
- 후위 표기식을 바꾸고 스택을 사용하여 푸는 문제였는데 다른 방식을 풀어버렸다. 문제를 잘 읽어야겠다.


## **1223. 계산기2**

> 문자열로 이루어진 계산식이 주어질 때, 이 계산식을 후위 표기식으로 바꾸어 계산하는 프로그램을 작성하시오.

✏️ **문제 풀이**
- 문자열 계산식을 구성하는 연산자는 +, * 두 종류이며 피연산자인 숫자는 0~9 의 정수만 주어진다.
- 후위 표기식으로 바꾸기 위해 stack을 사용한다.
- 문자열 길이 만큼 for문을 사용하여 각 인덱스 문자가 숫자이면 새로운 문자열에 넣어주고, 연산자일때는 우선순위에 따라 stack 넣거나 새로운 문자열에 넣어준다. 
    - stack이 비었을 때 push한다.
    - stack이 비어있지 않고, 현재 연산자가 *일때 push한다.
    - stack이 비어있지 않고, 현재 연산자가 +이고 top 연산자가 *일때는 pop하고 push한다.
- 후위 표시식 계산 방법은 숫자일때는 stack에 넣고, 연산자일때는 stack에 있는 두 숫자를 pop하여 연산하여 다시 push한다.


✏️ **소스 코드**
```java
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
```

## **1224. 계산기3**

> 문자열로 이루어진 계산식이 주어질 때, 이 계산식을 후위 표기식으로 바꾸어 계산하는 프로그램을 작성하시오.

✏️ **문제 풀이**
- 문자열 계산식을 구성하는 연산자는 +, * 두 종류이며 문자열 중간에 괄호가 들어 갈 수 있다. 피연산자인 숫자는 0~9 의 정수만 주어진다.
- 후위 표기식으로 바꾸기 위해 stack을 사용한다.
- 문자열 길이 만큼 for문을 사용하여 각 인덱스 문자가 숫자이면 새로운 문자열에 넣어주고, 연산자일때는 우선순위에 따라 stack 넣거나 새로운 문자열에 넣어준다. 
    - 숫자일 경우는 바로 새로운 문자열에 더한다.
    - '(' 일 경우는 push한다.
    - ')' 일 경우는 stack에서 '('을 만날때까지 pop하고 새로운 문자열에 더한다.
    - +,* 일 경우 우선순위를 비교하여 앞에서 우선순위가 높을 경우는 push, 낮은 경우는 pop한 후 push한다.
- 후위 표시식 계산 방법은 숫자일때는 stack에 넣고, 연산자일때는 stack에 있는 두 숫자를 pop하여 연산하여 다시 push한다.


✏️ **소스 코드**
```java
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
```