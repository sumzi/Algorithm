function solution(n) {
  let answer = "수박".repeat(n / 2);

  if (n % 2 == 0) {
    return answer;
  } else {
    return answer + "수";
  }
}
