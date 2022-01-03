function solution(d, budget) {
  let total = 0;
  let answer = 0;
  d.sort((a, b) => a - b);
  for (let i = 0; i < d.length; i++) {
    if (total + d[i] <= budget) {
      total += d[i];
      answer++;
    } else break;
  }
  return answer;
}
