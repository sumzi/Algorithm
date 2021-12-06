function solution(nums) {
  var answer = 0;
  let prime = Array(3000).fill(true);
  for (var i = 2; i < 3000; i++) {
    for (var j = i + i; j < 3000; j += i) {
      prime[j] = false;
    }
  }
  function combination(cur, cnt, sum) {
    if (cur > nums.length) return;
    if (cnt == 3) {
      if (prime[sum]) {
        answer++;
      }
      return;
    }
    for (var k = cur; k < nums.length; k++) {
      combination(k + 1, cnt + 1, sum + nums[k]);
    }
  }
  combination(0, 0, 0);
  return answer;
}
