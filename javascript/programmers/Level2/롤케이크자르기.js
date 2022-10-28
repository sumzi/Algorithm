function solution(topping) {
  const map = new Map();
  let a = 0,
    b = 0,
    answer = 0;

  topping.forEach((x) => {
    const tmp = map.get(x);
    if (map.has(x)) {
      tmp.cnt++;
      map.set(x, tmp);
    } else {
      a++;
      map.set(x, { cnt: 1, visited: false });
    }
  });

  topping.forEach((x) => {
    const tmp = map.get(x);
    if (!tmp.visited) {
      tmp.visited = true;
      b++;
    }
    tmp.cnt--;
    if (tmp.cnt === 0) a--;
    if (a === b) answer++;
  });
  return answer;
}
