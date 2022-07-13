function solution(fees, records) {
  const answer = [];
  const tmp = new Map();
  const sum = new Map();
  records.forEach((record) => {
    const [a, b, c] = record.split(" ");
    const [h, m] = a.split(":");
    const time = Number(h) * 60 + Number(m);
    if (c === "IN") {
      tmp.set(b, time);
    }
    if (c === "OUT") {
      if (sum.has(b)) {
        sum.set(b, sum.get(b) + time - tmp.get(b));
      } else {
        sum.set(b, time - tmp.get(b));
      }
      tmp.delete(b);
    }
  });
  for ([a, b] of tmp) {
    if (sum.has(a)) {
      sum.set(a, sum.get(a) + (23 * 60 + 59) - b);
    } else {
      sum.set(a, 23 * 60 + 59 - b);
    }
  }
  for ([number, time] of sum) {
    console.log(number, time);
    if (fees[0] >= time) {
      answer.push([number, fees[1]]);
    } else {
      answer.push([
        number,
        fees[1] + Math.ceil((time - fees[0]) / fees[2]) * fees[3],
      ]);
    }
  }
  answer.sort((a, b) => a[0] - b[0]);
  return answer.map((a) => a[1]);
}
console.log(
  solution(
    [180, 5000, 10, 600],
    [
      "05:34 5961 IN",
      "06:00 0000 IN",
      "06:34 0000 OUT",
      "07:59 5961 OUT",
      "07:59 0148 IN",
      "18:59 0000 IN",
      "19:09 0148 OUT",
      "22:59 5961 IN",
      "23:00 5961 OUT",
    ]
  )
);
