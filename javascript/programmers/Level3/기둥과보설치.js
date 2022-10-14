function solution(n, build_frame) {
  const answer = [];
  const build = (arr, x, y, a) => {
    const result = a ? build_floor(arr, x, y) : build_pillar(arr, x, y);
    if (result) arr.push([x, y, a]);
  };
  const build_pillar = (arr, x, y) => {
    let flag = false;
    if (y === 0) {
      flag = true;
    } else if (arr.find(([i, j, k]) => i === x && j === y && k === 1)) {
      flag = true;
    } else if (arr.find(([i, j, k]) => i === x - 1 && j === y && k === 1)) {
      flag = true;
    } else if (arr.find(([i, j, k]) => i === x && j === y - 1 && k === 0)) {
      flag = true;
    }

    return flag;
  };
  const build_floor = (arr, x, y) => {
    let flag = false;
    if (arr.find(([i, j, k]) => i === x && j === y - 1 && k === 0)) {
      flag = true;
    } else if (arr.find(([i, j, k]) => i === x + 1 && j === y - 1 && k === 0)) {
      flag = true;
    } else if (
      arr.find(([i, j, k]) => i === x - 1 && j === y && k === 1) &&
      arr.find(([i, j, k]) => i === x + 1 && j === y && k === 1)
    ) {
      flag = true;
    }

    return flag;
  };
  const destroy = (arr, x, y, a) => {
    const arr_copy = [...arr];
    const index = arr_copy.findIndex(([i, j, k]) => i === x && j === y && k === a);
    arr_copy.splice(index, 1);

    for (const [i, j, k] of arr_copy) {
      if (k) {
        if (!build_floor(arr_copy, i, j)) {
          return;
        }
      } else {
        if (!build_pillar(arr_copy, i, j)) {
          return;
        }
      }
    }
    arr.splice(index, 1);
  };

  build_frame.forEach(([x, y, a, b]) => {
    if (b) {
      build(answer, x, y, a);
    } else {
      destroy(answer, x, y, a);
    }
  });
  answer.sort((a, b) =>
    a[0] === b[0] ? (a[1] === b[1] ? a[2] - b[2] : a[1] - b[1]) : a[0] - b[0]
  );
  return answer;
}
