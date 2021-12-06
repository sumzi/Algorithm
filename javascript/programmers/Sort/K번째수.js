function solution(array, commands) {
  var answer = [];
  commands.map((cmd) =>
    answer.push(
      array.slice(cmd[0] - 1, cmd[1]).sort((a, b) => a - b)[cmd[2] - 1]
    )
  );
  return answer;
}
