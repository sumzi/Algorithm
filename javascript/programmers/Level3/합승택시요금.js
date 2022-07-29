function solution(n, s, a, b, fares) {
  const arr = Array.from(Array(n + 1), () => Array(n + 1).fill(Infinity));
  for (let i = 1; i <= n; i++) arr[i][i] = 0;
  fares.forEach(([c, d, f]) => {
    arr[c][d] = arr[d][c] = f;
  });
  for (let k = 1; k <= n; k++) {
    for (let i = 1; i <= n; i++) {
      for (let j = 1; j <= n; j++) {
        arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
      }
    }
  }
  let answer = Infinity;
  for (let i = 1; i <= n; i++) {
    answer = Math.min(arr[s][i] + arr[a][i] + arr[b][i], answer);
  }
  return answer;
}

console.log(
  solution(6, 4, 6, 2, [
    [4, 1, 10],
    [3, 5, 24],
    [5, 6, 2],
    [3, 1, 41],
    [5, 1, 24],
    [4, 6, 50],
    [2, 4, 66],
    [2, 3, 22],
    [1, 6, 25],
  ])
);
