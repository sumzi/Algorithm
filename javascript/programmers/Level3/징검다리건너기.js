function solution(stones, k) {
  let start = 1,
    end = 200000000,
    mid = 1;
  const isPass = (n) => {
    let x = 0;
    return !stones.some((stone) => {
      if (stone - n < 0) {
        x++;
        if (x === k) return true;
      } else {
        x = 0;
      }
      return false;
    });
  };
  while (start + 1 < end) {
    mid = Math.floor((start + end) / 2);
    if (isPass(mid)) {
      start = mid;
    } else {
      end = mid;
    }
  }
  return start;
}
console.log(solution([2, 4, 5, 3, 2, 1, 4, 2, 5, 1], 3));
