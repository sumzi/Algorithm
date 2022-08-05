function solution(game_board, table) {
  let answer = 0;
  const n = game_board.length;
  const dir = [
    [-1, 0],
    [0, 1],
    [1, 0],
    [0, -1],
  ];
  let gb = [];
  let t = [];

  const findBlock = (x, y, z, arr) => {
    arr[x][y] = !z;
    const tmp = [[x, y]];
    dir.forEach(([a, b]) => {
      const nx = a + x;
      const ny = b + y;
      if (0 <= nx && nx < n && 0 <= ny && ny < n && arr[nx][ny] === z) {
        tmp.push(...findBlock(nx, ny, z, arr));
      }
    });
    return tmp;
  };
  const sortBlock = (arr) => {
    let minx = 50;
    let miny = 50;
    arr.forEach(([x, y]) => {
      minx = Math.min(minx, x);
      miny = Math.min(miny, y);
    });
    arr = arr.map(([x, y]) => [x - minx, y - miny]);
    arr.sort((a, b) => {
      if (a[0] === b[0]) return a[1] - b[1];
      else return a[0] - b[0];
    });
    return arr;
  };

  const rotation = (arr) => {
    const narr = arr.map(([x, y]) => [y, n - x]);
    return sortBlock(narr);
  };

  for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
      if (table[i][j]) {
        const block1 = findBlock(i, j, 1, table);
        t.push(sortBlock(block1));
      }
      if (!game_board[i][j]) {
        const block2 = findBlock(i, j, 0, game_board);
        gb.push(sortBlock(block2));
      }
    }
  }

  const isSame = (arrGb) => {
    for (let i = 0; i < 4; i++) {
      for (let j = 0; j < t.length; j++) {
        const arrT = t[j];
        if (arrGb.length !== arrT.length) continue;
        let flag = true;
        for (let k = 0; k < arrT.length; k++) {
          if (arrT[k][0] !== arrGb[k][0] || arrT[k][1] !== arrGb[k][1]) {
            flag = false;
            break;
          }
        }
        if (flag) {
          t.splice(j, 1);
          return true;
        }
      }
      arrGb = rotation(arrGb);
    }
    return false;
  };

  for (let i = 0; i < gb.length; i++) {
    if (isSame(gb[i])) {
      answer += gb[i].length;
    }
  }

  return answer;
}
