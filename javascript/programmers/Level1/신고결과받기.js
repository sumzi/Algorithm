function solution(id_list, report, k) {
  const count = {};
  const map = new Map();
  id_list.forEach((id) => map.set(id, new Set()));
  report.forEach((item) => {
    const [a, b] = item.split(" ");
    map.get(a).add(b);
  });
  for (const [key, value] of map) {
    for (const item of value) {
      count[item] = count[item] ? count[item] + 1 : 1;
    }
  }
  return id_list.map((id) => {
    let num = 0;
    for (const name of map.get(id)) {
      if (count[name] && count[name] >= k) {
        num++;
      }
    }
    return num;
  });
}
