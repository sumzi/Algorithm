function stringToNumber(time) {
  const [h, m] = time.split(":");
  return Number(h) * 60 + Number(m);
}

function solution(book_time) {
  let answer = 0;
  let room = [];

  const book = book_time.map(([a, b]) => {
    return [stringToNumber(a), stringToNumber(b) + 10];
  });

  book.sort((a, b) => a[0] - b[0]);

  book.forEach(([start, end]) => {
    const tmp = room.filter(([a, b]) => start < b);
    room = tmp;
    room.push([start, end]);
    answer = Math.max(answer, room.length);
  });

  return answer;
}
