function solution(dart) {
  const n = dart.length;
  const answer = Array(3).fill(0);
  const bonus = { S: 1, D: 2, T: 3 };
  let idx = 0;
  for (let i = 0; i < 3; i++) {
    if (dart[idx] === "1" && dart[idx + 1] === "0") {
      idx += 2;
      answer[i] = 10;
    } else {
      answer[i] = parseInt(dart[idx]);
      idx++;
    }
    answer[i] = Math.pow(answer[i], bonus[dart[idx]]);
    idx++;
    if (idx < n && dart[idx] === "*") {
      idx++;
      answer[i] *= 2;
      if (i !== 0) answer[i - 1] *= 2;
    } else if (idx < n && dart[idx] === "#") {
      idx++;
      answer[i] *= -1;
    }
  }

  return answer.reduce((acc, cur) => acc + cur, 0);
}
