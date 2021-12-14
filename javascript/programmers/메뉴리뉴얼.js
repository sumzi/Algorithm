function solution(orders, course) {
  var answer = [];
  let cnt = new Array(11).fill(0);
  let menu = new Map();
  function comb(idx, word, order) {
    if (idx === order.length) {
      if (word.length < 2) return;
      word = word.split("").sort().join("");
      menu.set(word, menu.has(word) ? menu.get(word) + 1 : 1);
      cnt[word.length] = Math.max(menu.get(word), cnt[word.length]);
      return;
    }
    comb(idx + 1, word, order);
    comb(idx + 1, word + order[idx], order);
  }
  orders.forEach((order) => comb(0, "", order));
  course.forEach((count) => {
    [...menu].forEach((item) => {
      if (item[1] > 1 && count === item[0].length && cnt[count] === item[1])
        answer.push(item[0]);
    });
  });
  return answer.sort();
}
