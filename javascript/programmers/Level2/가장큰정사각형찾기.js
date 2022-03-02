function solution(board) {
  let answer = 0;
  const n = board.length;
  const m = board[0].length;
  for (let i = 0; i < n; i++) {
    for (let j = 0; j < m; j++) {
      if (i === 0 || j === 0) answer = Math.max(answer, board[i][j]);
      else if (board[i][j]) {
        const num = Math.min(
          board[i - 1][j - 1],
          board[i][j - 1],
          board[i - 1][j]
        );
        if (num) {
          board[i][j] = num + 1;
          answer = Math.max(answer, num + 1);
        }
      }
    }
  }
  return answer ** 2;
}
