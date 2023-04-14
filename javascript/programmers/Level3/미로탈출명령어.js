const DIR = [
  [-1, 0, "u"],
  [0, 1, "r"],
  [0, -1, "l"],
  [1, 0, "d"],
];
function solution(n, m, x, y, r, c, k) {
  const stack = [[x, y, ""]];
  let answer = "impossible";
  while (stack.length) {
    const [a, b, road] = stack.pop();
    if (road.length === k && a === r && b === c) {
      answer = road;
      break;
    }
    const count = k - road.length;
    const minDist = Math.abs(a - r) + Math.abs(b - c);
    if (count < minDist || count % 2 !== minDist % 2) continue;
    for (let [i, j, dir] of DIR) {
      const na = a + i;
      const nb = b + j;
      if (na < 1 || n < na || nb < 1 || m < nb) continue;
      stack.push([na, nb, road + dir]);
    }
  }
  return answer;
}
