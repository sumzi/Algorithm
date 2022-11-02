function solution(cards) {
  const answer = [];
  const n = cards.length;
  const visited = Array(n + 1).fill(false);
  const findBox = (cur, arr) => {
    if (arr.length > 0 && arr.indexOf(cur) > -1) {
      answer.push(arr.length);
    } else {
      visited[cur] = true;
      findBox(cards[cur - 1], [...arr, cur]);
    }
  };
  for (let i = 1; i <= n; i++) {
    if (!visited[i]) findBox(i, []);
  }
  if (answer.length === 1) return 0;
  answer.sort((a, b) => b - a);
  return answer[0] * answer[1];
}
