function solution(N, road, K) {
  const d = Array.from(Array(N + 1), () => Array(N + 1).fill(Infinity));
  for (let i = 1; i <= N; i++) {
    d[i][i] = 0;
  }
  road.forEach(([a, b, c]) => {
    d[a][b] = Math.min(d[a][b], c);
    d[b][a] = Math.min(d[b][a], c);
  });

  for (let k = 1; k <= N; k++) {
    for (let i = 1; i <= N; i++) {
      for (let j = 1; j <= N; j++) {
        if (d[i][k] + d[k][j] < d[i][j]) {
          d[i][j] = d[i][k] + d[k][j];
        }
      }
    }
  }
  let answer = 0;
  for (let i = 1; i <= N; i++) {
    if (d[1][i] <= K) answer++;
  }
  return answer;
}
