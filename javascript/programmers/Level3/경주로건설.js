function solution(board) {
  const n = board.length;
  const dp = Array.from(Array(n), () =>
    Array.from(Array(n), () => Array(4).fill(Infinity))
  );
  dp[0][0][0] = dp[0][0][1] = dp[0][0][2] = dp[0][0][3] = 0;
  const dir = [
    [-1, 0],
    [0, 1],
    [1, 0],
    [0, -1],
  ];
  const q = [
    [0, 0, 0, 0],
    [0, 0, 0, 1],
    [0, 0, 0, 2],
    [0, 0, 0, 3],
  ];
  while (q.length > 0) {
    q.sort((a, b) => a[0] - b[0]);
    const [cost, x, y, z] = q.shift();
    if (x === n - 1 && y === n - 1) {
      console.log(cost);
      return cost;
    }
    if (dp[x][y][z] < cost) continue;
    for (let i = 0; i < 4; i++) {
      const nx = x + dir[i][0];
      const ny = y + dir[i][1];
      if (0 <= nx && nx < n && 0 <= ny && ny < n && !board[nx][ny]) {
        const ncost = cost + (z === i ? 100 : 600);
        if (dp[nx][ny][i] > ncost) {
          dp[nx][ny][i] = ncost;
          q.push([ncost, nx, ny, i]);
        }
      }
    }
  }
}
