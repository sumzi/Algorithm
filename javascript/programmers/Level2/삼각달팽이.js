function solution(n) {
  const answer = [];
  const arr = Array.from(Array(n), () => Array(n).fill(0));
  const dir = [
    [1, 0],
    [0, 1],
    [-1, -1],
  ];
  let x = -1;
  let y = 0;
  let z = 0;
  let num = 1;

  for (let i = n; i > 0; i--) {
    for (let j = 0; j < i; j++) {
      x += dir[z][0];
      y += dir[z][1];
      arr[x][y] = num;
      num++;
    }
    z = (z + 1) % 3;
  }
  for (let i = 0; i < n; i++) {
    for (let j = 0; j <= i; j++) {
      answer.push(arr[i][j]);
    }
  }
  return answer;
}
console.log(solution(4));
