function solution(n, k) {
  let answer = 0;
  const numbers = n
    .toString(k)
    .split("0")
    .map((x) => +x);
  const isPrime = (num) => {
    if (num < 2) return false;
    for (let i = 2; i <= Math.sqrt(num); i++) {
      if (num % i === 0) return false;
    }
    return true;
  };

  numbers.forEach((number) => {
    if (isPrime(number)) answer++;
  });
  return answer;
}
