function solution(n, stations, w) {
  let answer = 0;
  let cur = 1;
  const m = w * 2 + 1;
  stations.forEach((station) => {
    const cnt = station - cur - w;
    if (cnt > 0) {
      answer += Math.floor((cnt - 1) / m) + 1;
    }
    cur = station + w + 1;
  });

  const cnt = n - cur + 1;
  if (cnt > 0) {
    answer += Math.floor((cnt - 1) / m) + 1;
  }

  return answer;
}
