function solution(n, works) {
  if (works.reduce((acc, cur) => acc + cur, 0) <= n) return 0;
  works.sort((a, b) => b - a);
  const len = works.length;

  while (n > 0) {
    for (let i = 0; i < len; i++) {
      if (works[0] <= works[i]) {
        works[i]--;
        n--;
        if (!n) break;
      }
    }
  }
  console.log(works);
  return works.reduce((acc, cur) => acc + cur * cur, 0);
}
