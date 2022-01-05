function solution(s) {
  const n = s.length;
  if (n === 4 || n === 6) {
    for (let i = 0; i < n; i++) {
      if (s[i] === "0") continue;
      if (!+s[i]) return false;
    }
    return true;
  }
  return false;
}
