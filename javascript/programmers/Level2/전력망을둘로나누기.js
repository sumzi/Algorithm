function solution(n, wires) {
  let answer = n;
  const adj = Array.from(Array(n + 1), () => []);
  let visited = Array(n + 1).fill(false);

  wires.forEach(([a, b], i) => {
    adj[a].push([b, i]);
    adj[b].push([a, i]);
  });
  const dfs = (cur, idx) => {
    visited[cur] = true;
    let cnt = 1;
    adj[cur].forEach(([next, i]) => {
      if (idx !== i && !visited[next]) {
        cnt += dfs(next, idx);
      }
    });
    return cnt;
  };

  wires.forEach((_, i) => {
    visited = Array(n + 1).fill(false);
    const tmp = [];
    for (let j = 1; j <= n; j++) {
      if (!visited[j]) tmp.push(dfs(j, i));
    }
    answer = Math.min(answer, Math.abs(tmp[0] - tmp[1]));
  });
  return answer;
}

console.log(
  solution(9, [
    [1, 3],
    [2, 3],
    [3, 4],
    [4, 5],
    [4, 6],
    [4, 7],
    [7, 8],
    [7, 9],
  ])
);
