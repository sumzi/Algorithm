function solution(land) {
  const n = land.length;
  const dp = Array.from(Array(n), () => Array(4).fill(0));
  dp[0] = land[0];
  for (let i = 0; i < n - 1; i++) {
    for (let j = 0; j < 4; j++) {
      for (let k = 0; k < 4; k++) {
        if (j != k) {
          dp[i + 1][k] = Math.max(dp[i + 1][k], dp[i][j] + land[i + 1][k]);
        }
      }
    }
  }
  return Math.max(...dp[n - 1]);
}
