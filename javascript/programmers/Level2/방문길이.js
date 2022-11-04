function solution(dirs) {
  const s = new Set();
  let x = 0,
    y = 0;
  [...dirs].forEach((d) => {
    if (d === "U" && y < 5) {
      s.add(x + "," + (y + 0.5));
      y++;
    } else if (d === "D" && y > -5) {
      s.add(x + "," + (y - 0.5));
      y--;
    } else if (d === "L" && x > -5) {
      s.add(x - 0.5 + "," + y);
      x--;
    } else if (d === "R" && x < 5) {
      s.add(x + 0.5 + "," + y);
      x++;
    }
  });
  return s.size;
}
