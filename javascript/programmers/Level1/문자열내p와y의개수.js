function solution(s) {
  s = s.toLowerCase();
  let p = 0,
    y = 0;
  [...s].forEach((i) => {
    if (i === "p") p++;
    else if (i === "y") y++;
  });
  return p === y ? true : false;
}
