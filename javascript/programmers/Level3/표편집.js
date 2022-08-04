function solution(n, k, cmd) {
  class Node {
    constructor(index) {
      this.index = index;
      this.prev = null;
      this.next = null;
    }
  }
  const answer = Array(n).fill("O");
  const deleted = [];
  const arr = Array.from(Array(n), () => new Node());
  for (let i = 0; i < n; i++) {
    arr[i].index = i;
    if (i < n - 1) arr[i].next = i + 1;
    if (0 < i) arr[i].prev = i - 1;
  }
  cmd.forEach((cur) => {
    const [x, y] = cur.split(" ");
    if (x === "U") {
      for (let i = 0; i < +y; i++) {
        k = arr[k].prev;
      }
    } else if (x === "D") {
      for (let i = 0; i < +y; i++) {
        k = arr[k].next;
      }
    } else if (x === "C") {
      deleted.push([k, arr[k].prev, arr[k].next]);
      const { prev, next } = arr[k];
      if (arr[prev]) arr[prev].next = next;
      if (arr[next]) arr[next].prev = prev;
      k = next ? next : prev;
    } else if (x === "Z") {
      const [index, prev, next] = deleted.pop();
      if (arr[prev]) arr[prev].next = index;
      if (arr[next]) arr[next].prev = index;
    }
  });
  deleted.forEach((x) => (answer[x[0]] = "X"));
  return answer.join("");
}
console.log(
  solution(8, 2, ["D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"])
);
