function solution(s) {
  const n = s.length;
  for (let i = n - 1; i >= 0; i--) {
    for (let j = 0; j <= n - i; j++) {
      let l = j,
        r = j + i,
        flag = true;
      while (l <= r) {
        if (s[l] !== s[r]) {
          flag = false;
          break;
        }
        l++;
        r--;
      }
      if (flag) return i + 1;
    }
  }
}
