function solution(n, words) {
  let word = words[0][0];
  const check = new Set();
  for (let i = 0; i < words.length; i++) {
    if (words[i][0] !== word) {
      return [(i % n) + 1, Math.floor(i / n) + 1];
    } else {
      if (check.has(words[i])) {
        return [(i % n) + 1, Math.floor(i / n) + 1];
      } else {
        check.add(words[i]);
        word = words[i][words[i].length - 1];
      }
    }
  }
  return [0, 0];
}
