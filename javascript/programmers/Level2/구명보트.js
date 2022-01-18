function solution(people, limit) {
  let answer = 0,
    l = 0,
    r = people.length - 1;
  people.sort((a, b) => b - a);
  while (l < r) {
    if (people[l] + people[r] <= limit) {
      l++;
      r--;
    } else {
      l++;
    }
    answer++;
    if (l === r) answer++;
  }
  return answer++;
}
