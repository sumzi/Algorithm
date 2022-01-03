function solution(sizes) {
  let x = 0;
  let y = 0;
  sizes.forEach(([a, b]) => {
    let [i, j] = a < b ? [a, b] : [b, a];
    x = Math.max(i, x);
    y = Math.max(j, y);
  });
  return x * y;
}
