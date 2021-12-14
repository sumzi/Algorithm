function solution(n, results) {
  var answer = 0;
  const win = [];
  const lose = [];
  const cnts = new Array(n + 1).fill(0);
  for (let i = 0; i < n + 1; i++) {
    win.push([]);
    lose.push([]);
  }
  results.forEach((result) => {
    win[result[0]].push(result[1]);
    lose[result[1]].push(result[0]);
  });
  console.log(win);
  console.log(lose);
  const check = (adj, cur) => {
    const visited = new Array(n + 1).fill(false);
    const q = [cur];
    while (q.length > 0) {
      const x = q.shift();
      if (visited[x]) continue;
      visited[x] = true;
      cnts[cur]++;
      adj[x].forEach((nx) => {
        if (!visited[nx]) q.push(nx);
      });
    }
  };
  for (let i = 1; i < n + 1; i++) {
    check(win, i);
    check(lose, i);
    if (cnts[i] === n + 1) answer++;
  }
  return answer;
}
