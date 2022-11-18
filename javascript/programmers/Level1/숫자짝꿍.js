function solution(X, Y) {
  const result = [];
  const number = Array(10).fill(0);
  [...X].forEach((n) => number[+n]++);
  [...Y].forEach((n) => {
    const i = +n;
    if (number[i] > 0) {
      result.push(i);
      number[i]--;
    }
  });
  if (result.length === 0) return "-1";
  result.sort((a, b) => b - a);
  const answer = result.join("");
  if (Number(answer) === 0) return "0";
  return answer;
}
