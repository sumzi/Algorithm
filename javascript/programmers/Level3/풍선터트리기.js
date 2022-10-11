function solution(a) {
  let answer = 0;
  const n = a.length;
  if (n === 1) {
    return 1;
  } else if (n === 2) {
    return 2;
  } else if (n > 2) {
    answer = 2;
  }
  const dp1 = new Array(n).fill(0);
  const dp2 = new Array(n).fill(0);
  dp1[0] = a[0];
  dp2[n - 1] = a[n - 1];
  for (let i = 1; i < n; i++) {
    dp1[i] = Math.min(dp1[i - 1], a[i]);
  }
  for (let i = n - 2; i >= 0; i--) {
    dp2[i] = Math.min(dp2[i + 1], a[i]);
  }

  for (let i = 1; i < n - 1; i++) {
    let cnt = 0;
    if (a[i] > dp1[i - 1]) cnt++;
    if (a[i] > dp2[i + 1]) cnt++;
    if (cnt < 2) answer++;
  }
  return answer;
}
