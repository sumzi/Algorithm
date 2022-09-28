function solution(queue1, queue2) {
  const sum = (arr) => arr.reduce((acc, cur) => acc + cur, 0);
  let s1 = sum(queue1);
  let s2 = sum(queue2);
  if ((s1 + s2) % 2 === 1) return -1;
  const n = (s1 + s2) / 2;
  const queue = [...queue1, ...queue2];
  let left = 0,
    right = queue1.length,
    total = s1,
    answer = 0;
  while (left <= right) {
    if (total === n) {
      break;
    } else if (total < n) {
      if (queue.length === right) break;
      total += queue[right];
      right++;
      answer++;
    } else if (total > n) {
      total -= queue[left];
      left++;
      answer++;
    }
  }
  return total === n ? answer : -1;
}
console.log(solution([3, 2, 7, 2], [4, 6, 5, 1]));
