function solution(n, edge) {
  var answer = 0;
  let q = [1];
  let adj = Array(n + 1)
    .fill(null)
    .map(() => Array());
  let visited = Array(n + 1).fill(false);
  for (let i of edge) {
    adj[i[0]].push(i[1]);
    adj[i[1]].push(i[0]);
  }
  visited[1] = true;
  while (q.length > 0) {
    answer = q.length;
    let cnt = q.length;
    for (let i = 0; i < cnt; i++) {
      let x = q.shift();
      for (let j = 0; j < adj[x].length; j++) {
        let nx = adj[x][j];
        if (visited[nx] == false) {
          visited[nx] = true;
          q.push(nx);
        }
      }
    }
  }
  return answer;
}
