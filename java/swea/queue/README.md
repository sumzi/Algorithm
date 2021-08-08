# Queue

## **1225. 암호생성기**

> 다음 주어진 주건에 따라 n개의 수를 처리하면 8자리의 암호를 생성하시오.

✏️ **문제 풀이**
- 8개의 숫자를 입력 받아 queue에 저장(add)한다.
- for문을 1에서 5까지 돌리며 queue.poll()값에 해당 수를 감소시키며 0 보다 작아질때까지 반복한다.
- 숫자가 감소하여 0보다 작거나 같을 때 0을 add하며 break한다.

💻 **소스 코드**
```java
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution1225 {
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            q.clear();
            n = sc.nextInt();
            for (int j = 0; j < 8; j++) {
                q.add(sc.nextInt());
            }
            boolean flag = true;
            while (flag) {
                for (int k = 1; k < 6; k++) {
                    int x = q.poll();
                    if (x - k > 0) {
                        q.add(x - k);
                    } else {
                        q.add(0);
                        flag = false;
                        break;
                    }
                }
            }
            System.out.print("#" + n + " ");
            for (Integer a : q) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }
}
```

<br>

## **1226. 미로1**

> 주어진 미로의 출발점으로부터 도착지점까지 갈 수 있는 길이 있는지 판단하는 프로그램을 작성하라.

✏️ **문제 풀이**
- 16*16 행렬을 2차원 arr배열에 저장한다. (길:0, 벽:1)
- 시작점 2의 좌표를 queue에 add하고 시작점을 벽인 1로 변경한다.
- 시작점부터 시작하여 상하좌우로 for문을 돌리며 길인 0이면 queue에 해당 좌표를 저장하고 현재 위치값을 다시 방문하지 않도록 벽인 1로 변경한다.
- 만약 도착점인 3을 만난다면 boolean 값을 true로 변경하고 break한다.
- 시작점에서 도착점까지 도달이 가능하면 1을 출력하고, 불가능하다면 0을 출력한다.

💻 **소스 코드**
```java
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution1226 {
    static int n;
    static String s;
    static char[][] arr = new char[16][16];
    static int[] start;
    static int[] end;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            n = sc.nextInt();
            for (int j = 0; j < 16; j++) {
                s = sc.next();
                for (int k = 0; k < 16; k++) {
                    arr[j][k] = s.charAt(k);
                    if (arr[j][k] == '2') {
                        arr[j][k] = '1';
                        q.add(new int[] { j, k });
                    } else if (arr[j][k] == '3') {
                        end = new int[] { j, k };
                    }
                }
            }

            boolean flag = false;
            while (!q.isEmpty()) {
                int[] x = q.poll();
                if (x[0] == end[0] && x[1] == end[1]) {
                    flag = true;
                    break;
                }
                for (int j = 0; j < 4; j++) {
                    int nx = dx[j] + x[0];
                    int ny = dy[j] + x[1];
                    if (0 <= nx && nx < 16 && 0 <= ny && ny < 16 && arr[nx][ny] != '1') {
                        arr[nx][ny] = '1';
                        q.add(new int[] { nx, ny });
                    }
                }
            }
            System.out.printf("#%d %d%n", n, flag ? 1 : 0);
        }
    }
}
```
<br>

## **1227. 미로2**

> 주어진 미로의 출발점으로부터 도착지점까지 갈 수 있는 길이 있는지 판단하는 프로그램을 작성하라.

### ✏️ **문제 풀이**
- 100*100 행렬을 2차원 arr배열에 저장한다. (길:0, 벽:1)
- 시작점 2의 좌표를 queue에 add하고 시작점을 벽인 1로 변경한다.
- bfs(너비 우선 탐색)을 이용해 문제를 해결한다.
- 시작점부터 시작하여 상하좌우로 for문을 돌리며 길인 0이면 queue에 해당 좌표를 저장하고 현재 위치값을 다시 방문하지 않도록 벽인 1로 변경한다.
- 만약 도착점인 3을 만난다면 boolean 값을 true로 변경하고 break한다.
- 시작점에서 도착점까지 도달이 가능하면 1을 출력하고, 불가능하다면 0을 출력한다.

### 💻 **소스 코드**

```java
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution1227 {
    static int n, m = 100;
    static String s;
    static char[][] arr;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<int[]> q = new LinkedList<>();
        arr = new char[m][m];
        for (int i = 0; i < 10; i++) {
            n = sc.nextInt();
            for (int j = 0; j < m; j++) {
                s = sc.next();
                for (int k = 0; k < m; k++) {
                    arr[j][k] = s.charAt(k);
                    if (arr[j][k] == '2') {
                        arr[j][k] = '1';
                        q.add(new int[] { j, k });
                    }
                }
            }
            boolean flag = false;
            while (!q.isEmpty()) {
                int[] x = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = dx[j] + x[0];
                    int ny = dy[j] + x[1];
                    if (0 <= nx && nx < m && 0 <= ny && ny < m && arr[nx][ny] != '1') {
                        if (arr[nx][ny] == '3') {
                            flag = true;
                            break;
                        } else {
                            arr[nx][ny] = '1';
                            q.add(new int[] { nx, ny });
                        }
                    }
                }
            }
            System.out.printf("#%d %d%n", n, flag ? 1 : 0);
        }
    }
}
```

### 🤔 **후기**

- queue를 사용한 BFS(너비 우선 탐색)으로 문제를 해결했지만, DFS(깊이 우선 탐색)으로 풀어도 될 것 같다.
