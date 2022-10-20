function solution(arr1, arr2) {
  const n = arr1.length;
  const m = arr2[0].length;
  const answer = Array.from(Array(n), () => Array(m).fill(0));
  for (let i = 0; i < n; i++) {
    for (let j = 0; j < m; j++) {
      let sum = 0;
      arr1[i].forEach((cur, idx) => {
        sum += cur * arr2[idx][j];
      });
      answer[i][j] = sum;
    }
  }
  return answer;
}
