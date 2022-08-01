function solution(info, edges) {
  const n = info.length;
  const visited = Array(1 << n).fill(false);
  const adj = Array.from(Array(n), () => Array());
  edges.forEach(([a, b]) => adj[a].push(b));

  const q = [[1, 0, 1]];
  visited[1] = true;
  let answer = 1;
  while (q.length > 0) {
    const [s, w, route] = q.shift();
    answer = Math.max(answer, s);
    for (i = 0; i < n; i++) {
      const tmp = route & (1 << i);
      if (tmp) {
        adj[i].forEach((next) => {
          let ns = s,
            nw = w;
          if (info[next]) nw++;
          else ns++;
          if (ns > nw) {
            const nRoute = route | (1 << next);
            if (!visited[nRoute]) {
              visited[nRoute] = true;
              q.push([ns, nw, nRoute]);
            }
          }
        });
      }
    }
  }
  return answer;
}
console.log(
  solution(
    [0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1],
    [
      [0, 1],
      [1, 2],
      [1, 4],
      [0, 8],
      [8, 7],
      [9, 10],
      [9, 11],
      [4, 3],
      [6, 5],
      [4, 6],
      [8, 9],
    ]
  )
);
