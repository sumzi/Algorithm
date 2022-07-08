function solution(n) {
  let i = 1,
    j = 1,
    sum = 1,
    answer = 0;
  while (i <= n) {
    if (sum === n) {
      answer++;
      sum -= i;
      i++;
    } else if (sum < n) {
      j++;
      sum += j;
    } else {
      sum -= i;
      i++;
    }
  }
  return answer;
}
