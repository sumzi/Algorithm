function solution(operations) {
  const q = [];
  operations.forEach((operation) => {
    const [a, b] = operation.split(" ");
    const num = Number(b);
    if (a === "I") {
      q.push(num);
    } else if (a === "D") {
      if (num > 0) {
        q.sort((x, y) => y - x);
      } else {
        q.sort((x, y) => x - y);
      }
      q.shift();
    }
  });
  if (q.length === 0) return [0, 0];
  q.sort((x, y) => x - y);
  return [q[q.length - 1], q[0]];
}
