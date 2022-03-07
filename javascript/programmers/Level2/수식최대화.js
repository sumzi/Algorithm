function solution(expression) {
  const arr = [
    ["+", "-", "*"],
    ["+", "*", "-"],
    ["-", "+", "*"],
    ["-", "*", "+"],
    ["*", "+", "-"],
    ["*", "-", "+"],
  ];
  let answer = 0;

  for (let i of arr) {
    const temp = expression.split(/(\D)/);
    for (let j of i) {
      while (temp.includes(j)) {
        const idx = temp.indexOf(j);
        temp.splice(idx - 1, 3, eval(temp.slice(idx - 1, idx + 2).join("")));
      }
    }
    answer = Math.max(answer, Math.abs(temp[0]));
  }
  return answer;
}
