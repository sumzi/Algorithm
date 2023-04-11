function solution(n, roads, sources, destination) {
  const dp = Array(n + 1).fill(Infinity);
  const adj = Array.from(Array(n + 1), () => []);
  const q = [[destination, 0]];
  dp[destination] = 0;
  roads.forEach(([a, b]) => {
    adj[a].push(b);
    adj[b].push(a);
  });

  while (q.length) {
    const [x, y] = q.shift();
    for (let nx of adj[x]) {
      if (y + 1 < dp[nx]) {
        q.push([nx, y + 1]);
        dp[nx] = y + 1;
      }
    }
  }
  return sources.map((source) => (dp[source] === Infinity ? -1 : dp[source]));
}
