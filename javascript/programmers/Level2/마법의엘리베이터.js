function solution(storey) {
  let answer = 0;
  while (storey > 0) {
    const num = storey % 10;

    if (num > 5) {
      storey += 10 - num;
      answer += 10 - num;
    } else if (num === 5 && Math.floor(storey / 10) % 10 >= 5) {
      storey += 5;
      answer += 5;
    } else {
      answer += num;
    }
    storey = Math.floor(storey / 10);
  }
  return answer;
}
console.log(solution(2554));
