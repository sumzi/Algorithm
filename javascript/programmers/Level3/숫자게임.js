function solution(A, B) {
  let answer = 0;
  A.sort((a, b) => b - a);
  B.sort((a, b) => b - a);
  const n = A.length;
  let a = 0,
    b = 0;
  while (a < n) {
    if (A[a] < B[b]) {
      answer++;
      a++;
      b++;
    } else if (A[a] >= B[b]) {
      a++;
    }
  }
  return answer;
}
