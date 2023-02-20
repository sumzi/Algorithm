function solution(maps) {
  const n = maps.length;
  const m = maps[0].length;
  const visited = Array.from(Array(n), () => Array(m).fill(false));
  const answer = [];
  const dir = [
    [0, 1],
    [0, -1],
    [1, 0],
    [-1, 0],
  ];

  const totalDay = (x, y) => {
    let cnt = Number(maps[x][y]);
    for (let i = 0; i < 4; i++) {
      const nx = x + dir[i][0];
      const ny = y + dir[i][1];
      if (0 <= nx && nx < n && 0 <= ny && ny < m) {
        if (maps[nx][ny] !== "X" && !visited[nx][ny]) {
          visited[nx][ny] = true;
          cnt += totalDay(nx, ny);
        }
      }
    }
    return cnt;
  };

  for (let i = 0; i < n; i++) {
    for (let j = 0; j < m; j++) {
      if (maps[i][j] !== "X" && !visited[i][j]) {
        visited[i][j] = true;
        const result = totalDay(i, j);
        answer.push(result);
      }
    }
  }

  if (answer.length === 0) return [-1];
  answer.sort((a, b) => a - b);
  return answer;
}
console.log(solution(["X591X", "X1X5X", "X231X", "1XXX1"]));
