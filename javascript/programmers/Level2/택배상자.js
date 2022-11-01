function solution(order) {
  let answer = 0,
    box = 1,
    index = 0;
  const n = order.length;
  const tmp = [];
  while (box <= n) {
    if (box === order[index]) {
      box++;
      index++;
      answer++;
    } else {
      tmp.push(box);
      box++;
    }
    while (tmp.length > 0 && tmp.slice(-1)[0] === order[index]) {
      tmp.pop();
      answer++;
      index++;
    }
  }
  return answer;
}
