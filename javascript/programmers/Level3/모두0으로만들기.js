function solution(a, edges) {
  const sum = a.reduce((acc, cur) => acc + cur, 0);
  if (sum !== 0) return -1;
  const n = a.length;
  const visited = Array(n).fill(false);
  const arr = Array.from(Array(n), () => []);
  const q = [[0, null]];
  let answer = 0n;

  edges.forEach(([x, y]) => {
    arr[x].push(y);
    arr[y].push(x);
  });

  while (q.length) {
    const [x, y] = q.pop();
    if (visited[x]) {
      answer += BigInt(Math.abs(a[x]));
      a[y] += a[x];
      a[x] = 0;
      console.log(x, y, a);
      continue;
    }
    visited[x] = true;
    q.push([x, y]);
    arr[x].forEach((nx) => {
      if (!visited[nx]) {
        q.push([nx, x]);
      }
    });
  }
  return answer;
}
