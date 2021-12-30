function solution(s) {
  return s
    .split(" ")
    .map((word) => {
      return word
        .split("")
        .map((item, index) => {
          return index % 2 === 0 ? item.toUpperCase() : item.toLowerCase();
        })
        .join("");
    })
    .join(" ");
}
