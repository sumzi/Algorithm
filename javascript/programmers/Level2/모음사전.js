function solution(word) {
  const dp = [781, 156, 31, 6, 1];
  const alpha = { A: 0, E: 1, I: 2, O: 3, U: 4 };
  let answer = 0;
  [...word].forEach((cur, i) => {
    answer += alpha[cur] * dp[i] + 1;
  });
  return answer;
}
