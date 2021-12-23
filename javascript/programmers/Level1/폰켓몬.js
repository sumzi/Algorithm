function solution(nums) {
  var answer = 0;
  let cur = 0;
  console.log(nums.sort());
  nums.sort().forEach((num) => {
    if (cur !== num) {
      cur = num;
      answer++;
    }
  });
  return answer > nums.length / 2 ? nums.length / 2 : answer;
}
