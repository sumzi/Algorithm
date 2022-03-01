function solution(s) {
  const answer = [];
  s = s
    .slice(2, -2)
    .split("},{")
    .map((a) => a.split(",").filter((b) => b !== ""))
    .sort((a, b) => a.length - b.length);
  s.forEach((a) => {
    for (let i = 0; i < a.length; i++) {
      if (!answer.includes(a[i])) {
        answer.push(a[i]);
        break;
      }
    }
  });
  return answer.map((a) => +a);
}
