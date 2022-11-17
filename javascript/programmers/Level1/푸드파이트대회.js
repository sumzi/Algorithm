function solution(food) {
  let result = [];
  food.forEach((item, i) => {
    if (item !== 1) {
      for (let j = 0; j < Math.floor(item / 2); j++) {
        result.push(i);
      }
    }
  });

  return result.join("") + "0" + result.reverse().join("");
}
