function solution(targets) {
  targets.sort((a, b) => {
    if (a[1] === b[1]) return a[0] - b[0];
    return a[1] - b[1];
  });
  let answer = 1;
  let end = targets[0][1];
  targets.forEach(([a, b]) => {
    if (end <= a) {
      answer++;
      end = b;
    }
  });
  return answer;
}
