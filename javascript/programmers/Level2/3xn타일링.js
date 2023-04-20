function solution(n) {
  const dp = Array(n / 2 + 1).fill(0);
  dp[0] = 1;
  dp[1] = 3;
  for (let i = 2; i <= n / 2; i++) {
    dp[i] += dp[i - 1] * 3;
    for (let j = 2; j <= i; j++) {
      dp[i] += dp[i - j] * 2;
    }
    dp[i] %= 1000000007;
  }
  return dp[n / 2];
}
