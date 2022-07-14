function solution(info, query) {
  const map = {};
  function binarySearch(score, key) {
    const scoreArr = map[key];
    if (!scoreArr) return 0;
    let start = 0,
      end = scoreArr.length,
      mid = 0;
    while (start < end) {
      mid = Math.floor((start + end) / 2);
      if (score <= scoreArr[mid]) {
        end = mid;
      } else {
        start = mid + 1;
      }
    }
    return scoreArr.length - start;
  }
  function combination(score, arr, cur) {
    const key = arr.join("");
    if (map[key]) map[key].push(score);
    else map[key] = [score];

    for (let i = cur; i < arr.length; i++) {
      const newArr = [...arr];
      newArr[i] = "-";
      combination(score, newArr, i + 1);
    }
  }
  info.forEach((i) => {
    i = i.split(" ");
    combination(+i.pop(), i, 0);
  });
  for (let key in map) {
    map[key].sort((a, b) => a - b);
  }
  return query.map((q) => {
    q = q.split(" ").filter((x) => x !== "and");
    return binarySearch(+q.pop(), q.join(""));
  });
}
