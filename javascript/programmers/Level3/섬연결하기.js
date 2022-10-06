function solution(n, costs) {
  let answer = 0;
  const arr = Array.from(Array(n), (_, i) => i);
  const getParent = (x) => {
    if (arr[x] === x) return x;
    return (arr[x] = getParent(arr[x]));
  };
  costs.sort((a, b) => a[2] - b[2]);
  costs.forEach(([a, b, c]) => {
    const x = getParent(a);
    const y = getParent(b);
    if (x !== y) {
      answer += c;
      arr[y] = x;
    }
  });
  return answer;
}
