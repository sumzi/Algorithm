const dir = [
  [0, 1],
  [0, -1],
  [1, 0],
  [-1, 0],
];
function solution(maps) {
  const n = maps.length;
  const m = maps[0].length;
  let start = null,
    lever = null,
    exit = null;
  maps.forEach((map, i) =>
    [...map].forEach((a, j) => {
      if (a === "S") {
        start = [i, j];
      } else if (a === "E") {
        exit = [i, j];
      } else if (a === "L") {
        lever = [i, j];
      }
    })
  );
  const findRoad = (s, e) => {
    const visited = Array.from(Array(n), () => Array(m).fill(0));
    const q = [[...s, 0]];
    while (q.length) {
      const [x, y, z] = q.shift();
      if (x === e[0] && y === e[1]) {
        return z;
      }
      if (visited[x][y]) continue;
      visited[x][y] = 1;
      dir.forEach(([a, b]) => {
        const nx = x + a;
        const ny = y + b;
        if (0 <= nx && nx < n && 0 <= ny && ny < m && maps[nx][ny] !== "X") {
          q.push([nx, ny, z + 1]);
        }
      });
    }
    return -1;
  };
  const first = findRoad(start, lever);
  const second = findRoad(lever, exit);
  if (first < 0 || second < 0) return -1;
  return first + second;
}
