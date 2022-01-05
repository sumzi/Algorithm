function solution(arr, divisor) {
  const answer = arr.filter((val) => val % divisor === 0);
  if (answer.length === 0) return [-1];
  return answer.sort((a, b) => a - b);
}
