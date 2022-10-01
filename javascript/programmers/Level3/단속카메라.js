function solution(routes) {
  routes.sort((a, b) => a[0] - b[0]);
  let [start, end] = routes[0];
  let answer = 1;
  routes.forEach(([cin, cout]) => {
    if (start <= cin && cin <= end) {
      start = cin;
      end = Math.min(end, cout);
    } else {
      answer++;
      start = cin;
      end = cout;
    }
  });
  return answer;
}
