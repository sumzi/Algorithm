function solution(n) {
  let answer = 0;
  const column = Array(n).fill(0);
  const valid = (i, num) => {
    for (let j = 0; j < i; j++) {
      if (column[j] === num || i - j === Math.abs(num - column[j])) {
        return false;
      }
    }
    return true;
  };
  const dfs = (i) => {
    if (i === n) {
      answer++;
      return;
    }
    for (let j = 0; j < n; j++) {
      if (valid(i, j)) {
        column[i] = j;
        dfs(i + 1);
      }
    }
  };
  for (let i = 0; i < n; i++) {
    column[0] = i;
    dfs(1, i);
  }
  return answer;
}
