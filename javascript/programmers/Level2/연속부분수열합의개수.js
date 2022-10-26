function solution(elements) {
  const sum = new Set();
  const n = elements.length;
  elements.forEach((el, i) => {
    let tmp = 0;
    for (let j = i; j < i + n; j++) {
      tmp += elements[j % n];
      sum.add(tmp);
    }
  });
  return sum.size;
}
