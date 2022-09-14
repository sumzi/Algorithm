function solution(n, s) {
  const value = Math.floor(s / n);
  if (!value) return [-1];
  const answer = new Array(n).fill(value);
  for (let i = 0; i < s % n; i++) {
    answer[n - i - 1]++;
  }
  answer.sort();
  return answer;
}
console.log(solution(2, 9));
