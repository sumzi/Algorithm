function solution(sequence, k) {
  const n = sequence.length;
  const answer = [0, n - 1];
  let sum = sequence[0];
  let start = 0,
    end = 0;
  while (start <= end) {
    if (k === sum) {
      if (answer[1] - answer[0] > end - start) {
        answer[0] = start;
        answer[1] = end;
      }
    }
    if (k <= sum) {
      sum -= sequence[start++];
    } else {
      sum += sequence[++end];
      if (end === n) break;
    }
  }
  return answer;
}
