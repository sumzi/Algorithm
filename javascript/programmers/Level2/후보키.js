function solution(relation) {
  const key = [];
  const row = relation.length;
  const col = relation[0].length;
  const check = Array(col).fill(false);
  const sum = (arr) => arr.reduce((acc, cur) => (acc += 1 << cur), 0);

  const minimality = (data) => key.some((k) => (data & k) === k);

  const uniqueness = (arr) => {
    const data = relation.map((r) =>
      arr.reduce((acc, cur) => (acc += r[cur]), "")
    );
    const cnt = new Set(data).size;
    if (cnt === row) return true;
    return false;
  };

  const combination = (idx, count, arr) => {
    if (count === 0) {
      const bit = sum(arr);
      if (!minimality(bit) && uniqueness(arr)) {
        key.push(bit);
      }
      return;
    }

    for (let i = idx; i < col; i++) {
      if (!check[i]) {
        const nArr = [...arr, i];
        check[i] = true;
        combination(i + 1, count - 1, nArr);
        check[i] = false;
      }
    }
  };

  for (let i = 1; i <= col; i++) {
    combination(0, i, []);
  }
  return key.length;
}
