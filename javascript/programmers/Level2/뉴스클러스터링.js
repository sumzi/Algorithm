function solution(str1, str2) {
  const cut = (str) => {
    const regExp = /^[A-Z]*$/;
    const arr = [];
    str = str.toUpperCase();
    for (let i = 0; i < str.length - 1; i++) {
      const tmp = str.slice(i, i + 2);
      if (regExp.test(tmp)) arr.push(tmp);
    }
    return arr.sort();
  };
  const word1 = cut(str1);
  const word2 = cut(str2);
  let a = 0,
    cnt = 0;
  word1.forEach((word) => {
    for (let i = a; i < word2.length; i++) {
      if (word === word2[i]) {
        a = i + 1;
        cnt++;
        break;
      }
    }
  });
  return Math.floor(
    (cnt === 0 && word1.length + word2.length - cnt === 0
      ? 1
      : cnt / (word1.length + word2.length - cnt)) * 65536
  );
}
