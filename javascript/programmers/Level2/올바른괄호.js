function solution(s) {
  let count = 0;

  for (let i = 0; i < s.length; i++) {
    if (s[i] === "(") {
      count++;
    } else {
      if (count === 0) {
        return false;
      } else {
        count--;
      }
    }
  }
  return count === 0 ? true : false;
}

console.log(solution("()()"));
