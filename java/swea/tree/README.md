# Tree

## **1231. 중위순회**

> 트리를 in-order 형식으로 순회하며 각 노드의 데이터를 출력하시오.

### ✏️ **문제 풀이**
- 정점개수를 입력받아 해당 정점의 알파벳, 해당 정점의 왼쪽 자식, 오른쪽 자식의 정접번호를 배열에 저장한다.
- 루트 정점인 1부터 inOrder메서드를 호출한다.
- 왼쪽 자식 여부를 확인후 있다면 호출, 현재 정점의 알파벳을 출력하고, 오른쪽 자식 여부를 확인후 있다면 호출하는 과정을 반복한다.


### 💻 **소스 코드**
```java
import java.io.*;
import java.util.*;

public class Solution1231 {
    static int n, m;
    static String[] alpha;
    static int[][] tree;

    public static void inOrder(int x) {
        if (tree[x][0] != 0)
            inOrder(tree[x][0]);
        System.out.print(alpha[x]);
        if (tree[x][1] != 0)
            inOrder(tree[x][1]);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int t = 1; t <= 10; t++) {
            n = Integer.parseInt(br.readLine());
            alpha = new String[n + 1];
            tree = new int[n + 1][2];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                m = Integer.parseInt(st.nextToken());
                alpha[m] = st.nextToken();
                int cnt = 0;
                while (st.hasMoreTokens()) {
                    tree[m][cnt++] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.print("#" + t + " ");
            inOrder(1);
            System.out.println();
        }
    }
}

```
<br>

## **1233. 사칙연산 유효성 검사**

> 사칙연산 +,-,*,/ 와 양의 정수로만 구성된 임의의 이진 트리가 주어질 때, 이식의 유효성을 검사하는 프로그램을 작성하여라.

### ✏️ **문제 풀이**
- 각 정점 갯수만큼 for문을 돌리며 해당 정점에 대한 정보를 배열에 저장한다.
- 사칙연산이 가능하기 위해서는 마지막 노드인 리프 노드만 숫자 데이터이고, 나머지 노드는 모두 사칙연산인 연산자 데이터를 가지고 있다면 유효하다.
- 루트 노드인 1번부터 check메서드를 호출하며 왼쪽 자식 노드와 오른쪽 자식 노드를 검사한다.
    - 현재 정점이 자식노드를 가지고 있다면 연산자 데이터가 저장되어야한다. 연산자 데이터가 맞다면 두 자식을 &&해서 return 한다. 만약 숫자 데이터면 return false 한다.
    - 현재 정점이 리프노드라면 숫자데이터가 저장되어야한다. 숫자 데이터가 맞다면 return true한다. 만약 연산자 데이터라면 return false한다.


### 💻 **소스 코드**
```java
import java.util.*;

public class Solution1233 {
    static int n;
    static char[] data;

    public static boolean check(int x) {
        if (x > n)
            return true;
        if (x * 2 <= n || x * 2 + 1 <= n) {
            if (Character.isDigit(data[x])) {
                return false;
            } else {
                return check(x * 2) && check(x * 2 + 1);
            }
        } else {
            if (Character.isDigit(data[x])) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {

            n = sc.nextInt();
            sc.next();
            data = new char[n + 1];
            for (int j = 1; j <= n; j++) {
                String[] s = sc.nextLine().split(" ");
                data[j] = s[1].charAt(0);
            }
            System.out.println("#" + (i + 1) + " " + (check(1) ? 1 : 0));
        }
    }
}
```

### 🤔 **후기**
- Scanner가 가지고 있는 메서드에서 nextInt() 를 사용하고 nextLine()를 사용할때, nextLine()이 다음 한줄을 입력 받는 것이 아니라 앞서 nextInt()가 입력받고 남은 개행문자를 입력받아 오류가 발생했었다. 그래서 nextInt()를 사용하고 다음 next()를 해줌으로 이 문제를 해결할 수 있었다. 
- 자바 문자열을 좀 더 공부해야겠다. 

<br>

## **1232. 사칙연산**

> 사칙연산 +,-,*,/와 양의 정수로만 구성된 임의의 이진트리가 주어질 때, 이를 계산한 결과를 출력하는 프로그램을 작성하라.

### ✏️ **문제 풀이**
- 정점의 갯수만큼 for를 사용하여 자식 정점 데이터가 있다면 Node를 생성할때 자식정점 정보와, 해당 연산자 정보를 저장한다. 자식이 없는 리프노드라면 숫자 정보를 저장한다.
- 루트 정점인 1를 check메서드로 호출하며 현재 정점이 연산자라면 각 자식정점을 연산하여 return 해준다.
- 현재 정점이 숫자라면 return 숫자를 해준다.
- 최종 결과값이 정수로 떨어지지 않으면 (int)형변환하여 출력한다.

### 💻 **소스 코드**
```java
import java.io.*;
import java.util.*;

class Node {
    public String op;
    public int num, left, right;

    public Node(String op, int left, int right) {
        this.op = op;
        this.left = left;
        this.right = right;
    }

    public Node(int num) {
        this.op = ".";
        this.num = num;
    }
}

public class Solution1232 {
    static int n;
    static String m;
    static Node[] node = new Node[1001];

    public static double check(int x) {
        if (node[x].op.equals("+")) {
            return check(node[x].left) + check(node[x].right);
        } else if (node[x].op.equals("-")) {
            return check(node[x].left) - check(node[x].right);
        } else if (node[x].op.equals("*")) {
            return check(node[x].left) * check(node[x].right);
        } else if (node[x].op.equals("/")) {
            return check(node[x].left) / check(node[x].right);
        } else {
            return node[x].num;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 1; i <= 10; i++) {
            n = Integer.parseInt(br.readLine());

            for (int j = 1; j <= n; j++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                if (st.countTokens() > 1) {
                    node[j] = new Node(st.nextToken(), Integer.parseInt(st.nextToken()),
                            Integer.parseInt(st.nextToken()));
                } else {
                    node[j] = new Node(Integer.parseInt(st.nextToken()));
                }
            }
            System.out.println("#" + i + " " + (int) check(1));
        }
    }
}

```