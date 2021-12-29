function solution(n) {
  const prime = Array(n + 1).fill(1);
  prime[0] = prime[1] = 0;
  for (let i = 2; i <= n; i++) {
    for (let j = i + i; j <= n; j += i) {
      prime[j] = 0;
    }
  }
  return prime.reduce((acc, cur) => acc + cur, 0);
}
