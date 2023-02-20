function solution(numbers) {
  const n = numbers.length;
  const answer = Array(n).fill(-1);
  const stack = [];
  numbers.forEach((num, index) => {
    while (stack.length && numbers[stack[stack.length - 1]] < num) {
      answer[stack.pop()] = num;
    }
    stack.push(index);
  });
  return answer;
}
console.log(solution([2, 3, 3, 5]));
