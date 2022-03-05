function solution(arr) {
  const answer = [0, 0];
  const quad = (n, x, y) => {
    if (n === 1) return arr[x][y];
    const tmp = [0, 0, 0];
    tmp[quad(n / 2, x, y)]++;
    tmp[quad(n / 2, x + n / 2, y)]++;
    tmp[quad(n / 2, x, y + n / 2)]++;
    tmp[quad(n / 2, x + n / 2, y + n / 2)]++;
    if (tmp[2] !== 0) {
      answer[0] += tmp[0];
      answer[1] += tmp[1];
      return 2;
    } else if (tmp[0] === 0) return 1;
    else if (tmp[1] === 0) return 0;
    else {
      answer[0] += tmp[0];
      answer[1] += tmp[1];
      return 2;
    }
  };
  const num = quad(arr.length, 0, 0);
  if (num !== 2) answer[num]++;
  return answer;
}
