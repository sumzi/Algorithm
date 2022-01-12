function solution(p) {
  let answer = "";
  let l = 0,
    r = 0,
    check = true;
  for (let i = 0; i < p.length; i++) {
    if (p[i] === "(") l++;
    else r++;
    if (l < r) check = false;
    if (l === r) {
      let u = p.slice(0, i + 1);
      let v = p.slice(i + 1, p.length);
      if (check) {
        answer += u;
        answer += solution(v);
      } else {
        answer += "(";
        answer += solution(v);
        answer += ")";
        for (let j = 1; j < i; j++) {
          answer += u[j] === "(" ? ")" : "(";
        }
      }
      return answer;
    }
  }
  return answer;
}
