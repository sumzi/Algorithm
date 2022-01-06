function solution(s, n) {
  return [...s]
    .map((a) => {
      if (a === " ") return " ";
      const m = a.charCodeAt();
      if (m < 97) {
        return 90 < m + n
          ? String.fromCharCode(m + n - 26)
          : String.fromCharCode(m + n);
      } else {
        return 122 < m + n
          ? String.fromCharCode(m + n - 26)
          : String.fromCharCode(m + n);
      }
    })
    .join("");
}
