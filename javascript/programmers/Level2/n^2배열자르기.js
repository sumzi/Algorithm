function solution(n, left, right) {
  const answer = [];
  for (let i = left; i <= right; i++) {
    const a = Math.ceil(i / n);
    const b = (i % n) + 1;
    if (a >= b) answer.push(a);
    else answer.push(b);
  }
  return answer;
}
