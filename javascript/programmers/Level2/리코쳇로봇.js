const DIR = [
  [0, 1],
  [0, -1],
  [1, 0],
  [-1, 0],
];
function solution(board) {
  let answer = -1;
  let start = null;
  const n = board.length;
  const m = board[0].length;
  const arr = board.map((a) => [...a]);
  arr.forEach((a, i) => {
    a.forEach((b, j) => {
      if (b === "R") {
        start = [i, j];
        arr[i][j] = "V";
      }
    });
  });
  const q = [[...start, 1]];
  const move = (x, y, a, b) => {
    while (true) {
      const nx = x + a;
      const ny = y + b;
      if (0 > nx || nx >= n || 0 > ny || ny >= m || arr[nx][ny] === "D") {
        break;
      }
      x += a;
      y += b;
    }
    return [x, y];
  };

  while (q.length) {
    const [x, y, count] = q.shift();
    for (let i = 0; i < 4; i++) {
      const [nx, ny] = move(x, y, DIR[i][0], DIR[i][1]);

      if (arr[nx][ny] === "G") {
        return count;
      } else if (arr[nx][ny] === ".") {
        q.push([nx, ny, count + 1]);
        arr[nx][ny] = "V";
      }
    }
  }
  return answer;
}
