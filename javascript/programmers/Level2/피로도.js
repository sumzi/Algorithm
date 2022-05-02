function solution(k, dungeons) {
  let answer = -1;
  const n = dungeons.length;
  const index = [];
  const permutation = (a) => {
    if (a === n) {
      let x = k;
      let y = 0;
      for (let i = 0; i < n; i++) {
        if (x < dungeons[index[i]][0] || x - dungeons[index[i]][1] < 0) break;
        y++;
        x -= dungeons[index[i]][1];
      }
      answer = Math.max(answer, y);
      return;
    }
    for (let i = 0; i < n; i++) {
      if (index.includes(i)) continue;
      index.push(i);
      permutation(a + 1);
      index.pop();
    }
  };
  permutation(0);
  return answer;
}
