function solution(arr) {
  if (arr.length === 1) return [-1];
  const num = arr.reduce((acc, cur) => Math.min(acc, cur), arr[0]);
  return arr.filter((cur) => cur !== num);
}