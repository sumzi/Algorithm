function solution(gems) {
  const n = gems.length;
  let answer = [1, n];
  const map = new Map();
  let start = 0,
    end = 0,
    gemNum = new Set(gems).size;
  map.set(gems[0], 1);
  while (end < n) {
    if (map.size === gemNum) {
      if (answer[1] - answer[0] > end - start) answer = [start + 1, end + 1];
      map.set(gems[start], map.get(gems[start]) - 1);
      if (map.get(gems[start]) === 0) map.delete(gems[start]);
      start++;
    } else {
      end++;
      if (end < n) {
        const tmp = map.get(gems[end]);
        map.set(gems[end], tmp ? tmp + 1 : 1);
      }
    }
  }
  return answer;
}
console.log(solution(["A", "B", "B", "B", "B", "B", "B", "C", "B", "A"]));
console.log(solution(["xyz"]));
console.log(solution(["a", "a", "a", "b", "b"]));
console.log(solution(["A", "B", "C", "B", "F", "D", "A", "F", "B", "D", "B"]));
