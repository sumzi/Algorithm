function solution(board, skill) {
  const n = board.length;
  const m = board[0].length;
  const sum = Array.from(Array(n + 1), () => Array(m + 1).fill(0));
  skill.forEach(([type, r1, c1, r2, c2, degree]) => {
    if (type === 1) degree *= -1;
    sum[r1][c1] += degree;
    sum[r1][c2 + 1] += -degree;
    sum[r2 + 1][c1] += -degree;
    sum[r2 + 1][c2 + 1] += degree;
  });

  for (let i = 0; i < n + 1; i++) {
    for (let j = 1; j < m + 1; j++) {
      sum[i][j] += sum[i][j - 1];
    }
  }
  for (let i = 0; i < m + 1; i++) {
    for (let j = 1; j < n + 1; j++) {
      sum[j][i] += sum[j - 1][i];
    }
  }
  let answer = 0;
  for (let i = 0; i < n; i++) {
    for (let j = 0; j < m; j++) {
      if (board[i][j] + sum[i][j] > 0) answer++;
    }
  }
  return answer;
}
