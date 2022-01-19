function solution(s) {
  const answer = [0, 0];
  while (true) {
    const n = s.length;
    let m = [...s].reduce((acc, cur) => acc + (cur === "0" ? 1 : 0), 0);
    answer[0]++;
    answer[1] += m;
    if (n - m === 1) {
      break;
    }
    s = (n - m).toString(2);
  }
  return answer;
}
