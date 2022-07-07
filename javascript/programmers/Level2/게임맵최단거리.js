function solution(maps) {
  const n = maps.length;
  const m = maps[0].length;
  const q = [[0, 0]];
  maps[0][0] = 0;
  const dir = [
    [0, 1],
    [0, -1],
    [1, 0],
    [-1, 0],
  ];
  while (q.length != 0) {
    const [x, y] = q.shift();
    if (x === n - 1 && y === m - 1) return maps[n - 1][m - 1] + 1;
    dir.forEach(([dx, dy]) => {
      const nx = x + dx;
      const ny = y + dy;
      if (0 <= nx && nx < n && 0 <= ny && ny < m && maps[nx][ny] === 1) {
        maps[nx][ny] = maps[x][y] + 1;
        q.push([nx, ny]);
      }
    });
  }
  return -1;
}
