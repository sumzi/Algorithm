function solution(n) {
  const cnt = [...n.toString(2)].reduce(
    (acc, cur) => (cur === "1" ? acc + 1 : acc + 0),
    0
  );

  while (true) {
    n++;
    const m = [...n.toString(2)].reduce(
      (acc, cur) => (cur === "1" ? acc + 1 : acc + 0),
      0
    );
    if (cnt === m) {
      return n;
    }
  }
}
