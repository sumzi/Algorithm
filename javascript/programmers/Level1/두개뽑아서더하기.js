function solution(numbers) {
  const answer = new Set();
  const n = numbers.length;
  for (let i = 0; i < n - 1; i++) {
    for (let j = i + 1; j < n; j++) {
      answer.add(numbers[i] + numbers[j]);
    }
  }
  return [...answer].sort((a, b) => a - b);
}
