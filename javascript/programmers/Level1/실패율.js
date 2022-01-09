function solution(N, stages) {
  const arr = Array(N + 2).fill(0);
  stages.forEach((cur) => arr[cur]++);
  let n = stages.length;
  let m = 0;
  const tmp = [];
  for (let i = 1; i < N + 1; i++) {
    tmp.push([i, arr[i] / n]);
    n -= arr[i];
  }
  tmp.sort((a, b) => {
    if (a[1] > b[1]) return -1;
  });
  return tmp.map(([a, b]) => a);
}
