function solution(n) {
  var answer = "";
  let a = n,
    b = -1;
  while (a > 0) {
    b = parseInt(a % 3);
    a = parseInt(a / 3);
    if (b === 0) {
      answer = "4" + answer;
      a--;
    } else if (b === 1) {
      answer = "1" + answer;
    } else if (b === 2) {
      answer = "2" + answer;
    }
  }

  return answer;
}
