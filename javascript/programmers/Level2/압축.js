function solution(msg) {
  const answer = [];
  let len = 1,
    num = 27,
    start = 0;
  const n = msg.length;
  let dict = {};
  for (let i = 1; i <= 26; i++) {
    dict[String.fromCharCode(i + 64)] = i;
  }
  while (start < n) {
    for (let i = len; i > 0; i--) {
      if (start + i > n) continue;
      const word = msg.slice(start, start + i);
      if (dict[word]) {
        answer.push(dict[word]);
        if (start + i + 1 <= n && !dict[msg.slice(start, start + i + 1)]) {
          dict[msg.slice(start, start + i + 1)] = num;
          num++;
          len = Math.max(len, i + 1);
        }
        start += i;

        break;
      }
    }
  }
  return answer;
}
console.log(solution("KAKAO"));
