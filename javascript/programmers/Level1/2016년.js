function solution(a, b) {
  const month = [0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
  const week = ["SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"];
  let day = 4;
  for (let i = 1; i < a; i++) {
    day += month[i];
  }
  day += b;
  return week[day % 7];
}
