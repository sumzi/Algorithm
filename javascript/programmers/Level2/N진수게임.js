function solution(n, t, m, p) {
  let answer = "";
  let num = 0;
  let numbers = "";
  while (numbers.length < t * m) {
    numbers += num.toString(n);
    num++;
  }
  for (let i = p - 1; i < t * m; i += m) {
    answer += numbers[i];
  }
  return answer.toUpperCase();
}
