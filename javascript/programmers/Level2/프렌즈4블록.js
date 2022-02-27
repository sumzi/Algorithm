function solution(m, n, board) {
  board = board.map((a) => [...a]);
  while (true) {
    const tmp = [];
    for (let i = 0; i < m - 1; i++) {
      for (let j = 0; j < n - 1; j++) {
        if (
          board[i][j] &&
          board[i][j] === board[i][j + 1] &&
          board[i][j] === board[i + 1][j] &&
          board[i][j] === board[i + 1][j + 1]
        ) {
          tmp.push([i, j]);
        }
      }
    }
    if (tmp.length === 0) return [].concat(...board).filter((a) => !a).length;
    tmp.forEach(([x, y]) => {
      board[x][y] = 0;
      board[x][y + 1] = 0;
      board[x + 1][y] = 0;
      board[x + 1][y + 1] = 0;
    });
    // 당기기
    for (let i = m - 1; i > 0; i--) {
      if (!board[i].some((x) => !x)) continue;
      for (let a = 0; a < n; a++) {
        for (let b = i - 1; b > -1 && !board[i][a]; b--) {
          if (board[b][a]) {
            board[i][a] = board[b][a];
            board[b][a] = 0;
            break;
          }
        }
      }
    }
  }
}
