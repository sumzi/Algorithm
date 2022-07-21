function solution(key, lock) {
  const M = key.length;
  const N = lock.length;
  const q = [[0, 0, 0]];
  const visited = ["000"];
  const dir = [
    [0, -1],
    [0, 1],
    [-1, 0],
    [1, 0],
  ];

  const keys = [];
  for (let i = 0; i < M; i++) {
    for (let j = 0; j < M; j++) {
      if (key[i][j]) keys.push([i, j]);
    }
  }

  const isVisit = (x, y, r) => {
    if (-M >= x || x >= N || -M >= y || y >= N) return;
    const log = [x, y, r].join("");
    if (!visited.includes(log)) {
      visited.push(log);
      q.push([x, y, r]);
    }
  };

  const rotation = (r) => {
    let tmp = [...keys];
    for (let i = 0; i < r; i++) {
      tmp = tmp.map(([x, y]) => [y, M - 1 - x]);
    }
    return tmp;
  };

  const isUnlock = (x, y, r) => {
    const newKeys = rotation(r);
    const newLock = Array.from(Array(N), () => new Array(N));
    for (let i = 0; i < N; i++) {
      for (let j = 0; j < N; j++) {
        newLock[i][j] = lock[i][j];
      }
    }
    newKeys.forEach(([a, b]) => {
      if (0 <= x + a && x + a < N && 0 <= y + b && y + b < N) {
        newLock[x + a][y + b] = newLock[x + a][y + b] === 0 ? 1 : 0;
      }
    });
    for (let i = 0; i < N; i++) {
      for (let j = 0; j < N; j++) {
        if (!newLock[i][j]) return false;
      }
    }
    return true;
  };

  while (q.length > 0) {
    const [x, y, r] = q.shift();
    if (isUnlock(x, y, r)) {
      return true;
    }
    isVisit(x, y, (r + 1) % 4);
    dir.forEach(([a, b]) => isVisit(x + a, y + b, r));
  }
  return false;
}

console.log(
  solution(
    [
      [0, 0, 0],
      [1, 0, 0],
      [0, 1, 1],
    ],
    [
      [1, 1, 1],
      [1, 1, 0],
      [1, 0, 1],
    ]
  )
);
