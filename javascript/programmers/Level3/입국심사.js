function solution(n, times) {
  let start = 1,
    end = Math.max(...times) * n,
    mid = 1,
    m = times.length;
  while (start < end) {
    let num = 0;
    mid = Math.floor((start + end) / 2);
    for (let i = 0; i < m; i++) {
      num += Math.floor(mid / times[i]);
      if (num >= n) break;
    }
    if (num >= n) {
      end = mid;
    } else {
      start = mid + 1;
    }
  }
  return start;
}

console.log(solution(6, [7, 10]));
