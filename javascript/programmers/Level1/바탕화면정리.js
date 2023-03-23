function solution(wallpaper) {
  const n = wallpaper.length;
  const m = wallpaper[0].length;
  const answer = [n, m, 0, 0];
  wallpaper.forEach((row, i) => {
    [...row].forEach((col, j) => {
      if (col === "#") {
        answer[0] = Math.min(answer[0], i);
        answer[1] = Math.min(answer[1], j);
        answer[2] = Math.max(answer[2], i + 1);
        answer[3] = Math.max(answer[3], j + 1);
      }
    });
  });
  return answer;
}
