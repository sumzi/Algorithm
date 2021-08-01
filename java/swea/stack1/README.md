# Stack1

## **1217. 거듭 제곱**

> 두 개의 숫자 N,M이 주어질 때, N의 M 거듭제곱 값을 구하는 프로그램을 재귀호출을 이용하여 구현해 보아라.

✏️ **문제 풀이**
- 재귀 함수를 구현한다. 탈출 조건으로 계산할 횟수가 1번 남았을 때 N를 return 한다.


✏️ **소스 코드**
```java
import java.util.Scanner;

public class Solution1217 {
    static int n,m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i < 11; i++) {
            int z=sc.nextInt();
            n=sc.nextInt();
            m=sc.nextInt();
            System.out.printf("#%d %d%n",i,recursion(n,m));
        }
    } 
    public static int recursion(int x,int y){
        if (y==1) return x;
        return x*recursion(x,y-1);
    }
}
```

## **1218. 괄호 짝짓기**

> 4종류의 괄호문자들 '()','[]','{}','<>'로 이루어진 문자열이 주어진다. 이 문자열에 사용된 괄호들의 짝이 모두 맞는지 판별하는 프로그램을 작성한다.

✏️ **문제 풀이**
- 각 괄호문자에 대한 변수 a,b,c,d를 만들고 0으로 초기화한다.
- 문자열 길이만큼 for문을 사용하여 현재 인덱스의 문자를 비교한다. 열린 괄호라면 각 괄호변수에 +1, 닫힌 괄호라면 -1를 해준다.
- 한번이라도 각 괄호변수가 0보다 작다면 flag에 true(유효성 0을 의미), flag가 false이고 각 변수가 모두 0인 경우에 유효성 1을 표시하고, 하나라도 0이 아닌 경우는 0을 표시한다.


✏️ **소스 코드**
```java
import java.util.Scanner;

public class Solution1218 {
    static int n, a, b, c, d;
    static String s;
    static boolean flag;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i < 11; i++) {
            n = sc.nextInt();
            s = sc.next();
            a = b = c = d = 0;
            flag = false;
            for (int j = 0; j < n; j++) {
                char m = s.charAt(j);
                if (m == '(' | m == ')') {
                    a += (m == '(' ? 1 : -1);
                    if (a < 0) {
                        flag = true;
                        break;
                    }
                } else if (m == '[' | m == ']') {
                    b += (m == '[' ? 1 : -1);
                    if (b < 0) {
                        flag = true;
                        break;
                    }
                } else if (m == '{' | m == '}') {
                    c += (m == '{' ? 1 : -1);
                    if (c < 0) {
                        flag = true;
                        break;
                    }
                } else if (m == '<' | m == '>') {
                    d += (m == '<' ? 1 : -1);
                    if (d < 0) {
                        flag = true;
                        break;
                    }
                }
            }
            if (flag) {
                System.out.printf("#%d %d%n", i, 0);
            } else if (a == 0 && b == 0 && c == 0 && d == 0) {
                System.out.printf("#%d %d%n", i, 1);
            } else {
                System.out.printf("#%d %d%n", i, 0);
            }
        }
    }
}

```

## **1219. 길찾기**

> 길이 주어질 때 A도시에서 B도시로 가는 길이 존재하는지 알아내는 프로그램을 작성하여라.

✏️ **문제 풀이**
- 출발전은 0, 도착점은 99로 표현한다.
- 길 중간에 중간에는 최대 2개의 갈림길이 존재하고, 모든 길은 단 방향이다. 2차원 배열을 사용하여 길이 존재하면 해당배열에 1로 표시한다.(없으면 0)
- dfs()를 이용하여 방문한 정점은 1->0으로 표시하고 다시 방문하지 않도록 한다.
- dfs(int x) 메소드에서 인수값으로 받은 정점x와 연결되어 있는 정점을 찾아가면서 정점99에 도달했을 경우 flag값을 true해준다.
- flag 값이 true인 경우 1을 출력하고 false 이면 0을 출력한다.


✏️ **소스 코드**
```java
import java.util.Scanner;

public class Solution1219 {
    static int[][] adj;
    static int n,m;
    static boolean flag;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i < 11; i++) {
            n=sc.nextInt();
            m=sc.nextInt();
            adj=new int[100][100];
            for (int j = 0; j < m; j++) {
                int x=sc.nextInt();
                int y=sc.nextInt();
                adj[x][y]=1;
            }
            flag=false;
            dfs(0);
            System.out.printf("#%d %d%n",i,flag?1:0);
        }
    }
    public static void dfs(int x){
        if(x==99){
            flag=true;
            return;
        } 
        for (int i = 0; i < 100; i++) {
            if (adj[x][i]==1){
                adj[x][i]=0;
                dfs(i);
            }
        }
    }
}

```

