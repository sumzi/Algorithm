function solution(arr) {
  const gcd = (a, b) => {
    if (b === 0) return a;
    return gcd(b, a % b);
  };
  let answer = 1;
  for (let i = 0; i < arr.length; i++) {
    answer = (answer * arr[i]) / gcd(answer, arr[i]);
  }
  return answer;
}
