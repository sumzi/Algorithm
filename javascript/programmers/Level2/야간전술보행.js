function solution(distance, scope, times) {
  scope.forEach((a, i) => {
    a.sort((x, y) => x - y);
    a.push(i);
    return a;
  });
  scope.sort((a, b) => a[0] - b[0]);
  for (let i = 0; i < scope.length; i++) {
    const [start, end, index] = scope[i];
    const [work, rest] = times[index];
    for (let j = start; j <= end; j++) {
      if (j > distance) break;
      const tmp = j % (work + rest);
      if (0 < tmp && tmp <= work) return j;
    }
  }
  return distance;
}
