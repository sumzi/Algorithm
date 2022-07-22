// 1. timetable 시간 계산해서 오름차순으로 정렬
// 2. n-1 for문 돌리면서 해당 차 순서에 m 만큼씩 제거
//   - 제거할 때 해당 차시간보다 작거나 같을 경우만 가능
//   - 해당 차시간 보다 크다면 for문 종료
// 3. 마지막 차에서는 꼭 탑승을 해야함
//   - 차 시간 보다 작거나 같은 사람으로 필터링함
//   - 만약 남은 사람이 m 보다 작다면
//     return 해당 차시간
//   - 크다면 person[m]-1
// 4. '00:00' 문자열로 바꾼다.
//   - time/60 : time%60
//   - 숫자가 한자리수이면 0+시간 으로 바꾼다.
function solution(n, t, m, timetable) {
  let crew = timetable
    .map((time) => {
      time = time.split(":");
      return +time[0] * 60 + +time[1];
    })
    .sort((a, b) => a - b);

  let bus = 540;
  for (let i = 0; i < n - 1; i++) {
    for (let j = 0; j < m; j++) {
      if (crew.length === 0 || bus < crew[0]) break;
      crew.shift();
    }
    bus += t;
  }
  crew = crew.filter((time) => time <= bus);

  let con = 0;
  if (crew.length < m) {
    con = bus;
  } else {
    con = crew[m - 1] - 1;
  }
  const hour = Math.floor(con / 60);
  const min = con % 60;
  return ("0" + hour).slice(-2) + ":" + ("0" + min).slice(-2);
}

console.log(solution(2, 10, 2, ["09:10", "09:09", "08:00"]));
