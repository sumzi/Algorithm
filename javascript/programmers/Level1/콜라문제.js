function solution(a, b, n) {
  let answer = 0;
  while (n >= a) {
    const x = Math.floor(n / a);
    const y = n % a;
    answer += x * b;
    n = x * b + y;
  }
  return answer;
}
