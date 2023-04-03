function solution(plans) {
  const n = plans.length;
  const answer = [];
  const stack = [];
  const plan = plans.map(([a, b, c]) => {
    const [h, m] = b.split(":");
    return [a, Number(h) * 60 + Number(m), Number(c)];
  });
  plan.sort((a, b) => a[1] - b[1]);
  plan.forEach(([a, b, c], i) => {
    let time = b + c;
    if (i !== n - 1) {
      if (time <= plan[i + 1][1]) {
        answer.push(a);

        while (stack.length) {
          const [x, y] = stack.pop();
          time += y;
          if (time <= plan[i + 1][1]) {
            answer.push(x);
          } else {
            stack.push([x, time - plan[i + 1][1]]);
            break;
          }
        }
      } else {
        stack.push([a, time - plan[i + 1][1]]);
      }
    } else {
      answer.push(a);
    }
  });
  stack.reverse();
  stack.forEach(([a, b]) => answer.push(a));
  return answer;
}
