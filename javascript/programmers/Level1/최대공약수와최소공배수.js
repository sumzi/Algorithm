function solution(n, m) {
  const gcd = (a, b) => {
    if (b === 0) return a;
    return gcd(b, a % b);
  };
  const result = gcd(n, m);
  return [result, (n * m) / result];
}
