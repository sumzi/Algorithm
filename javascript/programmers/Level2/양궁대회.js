function solution(n, info) {
  let answer = Array(11).fill(0);
  let max = 0;
  const recursion = (i, cnt, ryan, a, b) => {
    if (cnt > n) return;
    if (i > 10) {
      const tmp = b - a;
      if (tmp > max) {
        ryan[10] = n - cnt;
        max = tmp;
        answer = ryan;
      }
      return;
    }
    if (n > cnt) {
      const newRyan = [...ryan];
      newRyan[10 - i] = info[10 - i] + 1;
      recursion(i + 1, cnt + info[10 - i] + 1, newRyan, a, b + i);
    }
    if (info[10 - i] > 0) {
      recursion(i + 1, cnt, ryan, a + i, b);
    } else {
      recursion(i + 1, cnt, ryan, a, b);
    }
  };
  recursion(0, 0, answer, 0, 0);
  return max > 0 ? answer : [-1];
}

console.log(solution(5, [2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0]));
