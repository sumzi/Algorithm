function solution(x, y, n) {
  if (x === y) return 0;
  const dp = Array(y + 1).fill(0);
  const q = [x];
  while (q.length) {
    const a = q.shift();
    for (const na of [a + n, a * 3, a * 2]) {
      if (na === y) return dp[a] + 1;
      else if (na > y) continue;
      else if (!dp[na]) {
        dp[na] = dp[a] + 1;
        q.push(na);
      }
    }
  }
  return -1;
}
