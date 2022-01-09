function solution(n) {
  let answer = 1;
  while (true) {
    const tmp = answer ** 2;
    if (n === tmp) {
      return (answer + 1) ** 2;
    } else if (n > tmp) {
      answer++;
    } else {
      return -1;
    }
  }
}
