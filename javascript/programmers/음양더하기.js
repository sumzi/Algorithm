function solution(absolutes, signs) {
  return absolutes.reduce(
    (acc, cur, index) => (acc += signs[index] ? cur : -cur),
    0
  );
}
