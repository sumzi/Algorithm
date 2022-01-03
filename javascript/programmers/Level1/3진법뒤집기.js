function solution(n) {
  const m = n.toString(3).split("").reverse().join("");
  return parseInt(m, 3);
}
