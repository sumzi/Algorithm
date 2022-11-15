function solution(number) {
  let answer = 0;
  const n = number.length;
  const check = (cur, index, cnt) => {
    if (cnt === 3) {
      if (cur === 0) answer++;
      return;
    }
    for (let i = index + 1; i < n; i++) {
      check(cur + number[i], i, cnt + 1);
    }
  };
  for (let i = 0; i < n - 2; i++) {
    check(number[i], i, 1);
  }
  return answer;
}
