function solution(places) {
  const dx = [0, 0, -1, 1];
  const dy = [-1, 1, 0, 0];
  return places.map((place) => {
    place = place.map((p) => p.split(""));
    const bfs = (a, b) => {
      const visited = Array.from(Array(5), () => Array(5).fill(false));
      visited[a][b] = true;
      const q = [[a, b, 0]];
      while (q.length != 0) {
        const [x, y, z] = q.shift();
        if (z === 3) return false;
        if (z != 0 && place[x][y] === "P") return true;
        for (let i = 0; i < 4; i++) {
          const nx = x + dx[i];
          const ny = y + dy[i];
          if (
            0 <= nx &&
            nx < 5 &&
            0 <= ny &&
            ny < 5 &&
            !visited[nx][ny] &&
            place[nx][ny] != "X"
          ) {
            q.push([nx, ny, z + 1]);
            visited[nx][ny] = true;
          }
        }
      }
    };

    for (let i = 0; i < 5; i++) {
      for (let j = 0; j < 5; j++) {
        if (place[i][j] === "P") {
          if (bfs(i, j)) return 0;
        }
      }
    }
    return 1;
  });
}

console.log(
  solution([
    ["POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"],
    ["POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"],
    ["PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"],
    ["OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"],
    ["PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"],
  ])
);
