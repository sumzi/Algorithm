function solution(lottos, win_nums) {
  var answer = [];
  var result = [6, 6, 5, 4, 3, 2, 1];
  var cnt = 0;
  var same = 0;
  lottos.forEach((lotto) => {
    if (lotto === 0) cnt++;
    else {
      if (win_nums.includes(lotto)) {
        same++;
      }
    }
  });
  answer.push(result[cnt + same]);
  answer.push(result[same]);
  return answer;
}
