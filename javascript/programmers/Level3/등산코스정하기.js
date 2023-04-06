function solution(n, paths, gates, summits) {
  const answer = [n, Infinity];
  const link = Array.from(Array(n + 1), () => []);
  const q = [];
  const intensity = Array(n + 1).fill(Infinity);
  const isSummits = Array(n + 1).fill(false);
  summits.sort((a, b) => a - b);
  summits.forEach((summit) => (isSummits[summit] = true));

  paths.forEach(([a, b, c]) => {
    link[a].push([b, c]);
    link[b].push([a, c]);
  });

  gates.forEach((gate) => {
    q.push([gate, 0]);
    intensity[gate] = 0;
  });

  while (q.length) {
    const [cur, cost] = q.shift();

    if (intensity[cur] < cost || isSummits[cur]) continue;

    for (let [next, nextCost] of link[cur]) {
      const num = Math.max(intensity[cur], nextCost);
      if (num < intensity[next]) {
        intensity[next] = num;
        q.push([next, intensity[next]]);
      }
    }
  }

  summits.forEach((summit) => {
    if (answer[1] > intensity[summit]) {
      answer[0] = summit;
      answer[1] = intensity[summit];
    }
  });

  return answer;
}
