function solution(board) {
  const n = board.length;
  const logs = new Set();
  const queue = [[[0, 0], [0, 1], 0]];
  const dir = [
    [-1, 0],
    [1, 0],
    [0, -1],
    [0, 1],
  ];

  const checkLog = (a, b) => {
    const log = [a, b].join("");
    if (logs.has(log)) return true;
    return false;
  };

  const addLog = (a, b) => {
    const log = [a, b].join("");
    logs.add(log);
  };

  const addRobot = (a, b, c) => {
    const tmp = [a, b];
    tmp.sort((x, y) => {
      if (x[0] === y[0]) return x[1] - y[1];
      return x[0] - y[0];
    });
    a = tmp[0];
    b = tmp[1];
    if (!checkLog(a, b)) queue.push([a, b, c]);
  };

  const checkLoc = (a) => {
    if (0 > a[0] || n <= a[0] || 0 > a[1] || n <= a[1]) return false;
    return true;
  };

  while (queue.length > 0) {
    const [a, b, c] = queue.shift();

    if ((a[0] === n - 1 && a[1] === n - 1) || (b[0] === n - 1 && b[1] === n - 1)) return c;

    if (checkLog(a, b)) continue;
    addLog(a, b);

    dir.forEach((d) => {
      let na = [a[0] + d[0], a[1] + d[1]];
      let nb = [b[0] + d[0], b[1] + d[1]];
      if (checkLoc(na) && !board[na[0]][na[1]] && checkLoc(nb) && !board[nb[0]][nb[1]])
        addRobot(na, nb, c + 1);
    });

    if (a[0] === b[0]) {
      let na = [a[0] + dir[0][0], a[1] + dir[0][1]];
      let nb = [b[0] + dir[0][0], b[1] + dir[0][1]];
      if (checkLoc(na) && !board[na[0]][na[1]] && checkLoc(nb) && !board[nb[0]][nb[1]]) {
        addRobot(na, a, c + 1);
        addRobot(nb, b, c + 1);
      }
      na = [a[0] + dir[1][0], a[1] + dir[1][1]];
      nb = [b[0] + dir[1][0], b[1] + dir[1][1]];
      if (checkLoc(na) && !board[na[0]][na[1]] && checkLoc(nb) && !board[nb[0]][nb[1]]) {
        addRobot(a, na, c + 1);
        addRobot(b, nb, c + 1);
      }
    } else {
      let na = [a[0] + dir[2][0], a[1] + dir[2][1]];
      let nb = [b[0] + dir[2][0], b[1] + dir[2][1]];
      if (checkLoc(na) && !board[na[0]][na[1]] && checkLoc(nb) && !board[nb[0]][nb[1]]) {
        addRobot(na, a, c + 1);
        addRobot(nb, b, c + 1);
      }
      na = [a[0] + dir[3][0], a[1] + dir[3][1]];
      nb = [b[0] + dir[3][0], b[1] + dir[3][1]];
      if (checkLoc(na) && !board[na[0]][na[1]] && checkLoc(nb) && !board[nb[0]][nb[1]]) {
        addRobot(a, na, c + 1);
        addRobot(b, nb, c + 1);
      }
    }
  }
}
