function solution(cacheSize, cities) {
  if (cacheSize === 0) return 5 * cities.length;
  let answer = 0;
  const cache = [];
  cities.forEach((city) => {
    city = city.toUpperCase();
    const check = cache.indexOf(city);
    if (check === -1) {
      if (cache.length === cacheSize) {
        cache.shift();
        cache.push(city);
      } else {
        cache.push(city);
      }
      answer += 5;
    } else {
      if (cache.length !== 1) {
        cache.splice(check, 1);
        cache.push(city);
      }
      answer++;
    }
  });
  return answer;
}
