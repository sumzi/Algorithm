function solution(x) {
  let num = 0;
  let y = x;
  while (y > 0) {
    num += y % 10;
    y = Math.floor(y / 10);
  }
  return x % num === 0 ? true : false;
}
